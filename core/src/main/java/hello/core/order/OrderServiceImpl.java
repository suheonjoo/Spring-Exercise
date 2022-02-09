package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //여기 실제로는 추상에도 의존하고 구현에도 의존한 것임 -> dip위반(인터페이스만 의존해야하는데 )
    //그래서 의존성 때문에  FixDiscountPolicy을 RateDiscountPolicy로 변경하는 순간 OrderServiceImpl도 변경 해야 함
    // ->ocp 위반 (변경하지 않고 확장할 수 없어서)

    //그래서 아래와 같이 바꿈
    private DiscountPolicy discountPolicy;//이렇게 하면 dip는 지켰는데 ocp는 못지(null값 반환되면 아래 매서드에서 오류ㄱ)


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {//주문이 들어모년
        //여기도 =뒤에만 치고 command option v 이용하기
        Member member = memberRepository.findById(memberId);    //회원정보를 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인정보를 가져옴
        //여기가 중요한데 설계가 잘됨
        //여기서 order서비스에서는 할인에 대한정보는 모름 이를 discountPolicy에서 알아서 해줘 이 뜻임
        //->즉 이게 단일 체계 원칙을 잘 지킨 것(만약 할인에 대해 고칠게 있으면 할인쪽만 고치면 됨)

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
