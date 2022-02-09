package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

import java.util.Arrays;

public class OrderApp {

    //psvm치고 엔터로 단축키 활용
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);//위 정보로 회원가입을 시키고

        //이것도 =뒤에만 입력하고 command option v이용
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);//이걸로(객체)로 출려가면 앞서 생성해준 toString으로 출려이 됨
        //  System.out.println("order.calculatePrice = " + order.calculatePrice());//할인 계산된 가격 출력

    }

}
