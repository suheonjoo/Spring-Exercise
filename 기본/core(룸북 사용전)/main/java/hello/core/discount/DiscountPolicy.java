package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {


    // 팁: /**하고 enter 누르면 파라미터하고 리턴 값에 대한 주석 자동으로 만들어줌
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
    //팁인데 빨강색 오류가 나면 f2를 누를면 오류난 곳으로 이동해줌
}
