package hello.core.order;

import hello.core.discount.DiscountPolicy;
//import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    //final 중요 생성자 주입을 사용하면 final 활용가능!!
    private final DiscountPolicy discountPolicy;//이렇게 하면 dip는 지켰는데 ocp는 못지(null값 반환되면 아래 매서드에서 오류ㄱ)
    //즉, 디카프리오가 로미오 역할을 선택하는 것데 로미오 역할이 디카프리오를 선택하는 것이여서
    //생성자 주입을 하면final 키워드를 제대로 사용할 수 있음//final 한번 정해지면 안바뀌다는 것임
    //->즉 생성자에서만 값을 세팅할 수 있다, 그리고 실수로 생성자에서 누락하는 것 있으면 final 부분에 빨간줄 생김 (생성자 주입의 장점)


    //@Autowired없어도 생성자 하나라 스프링이 자동으로 autowired해줌 생략가능

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
