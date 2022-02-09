package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();



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
