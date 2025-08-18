package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    // 인터페이스 설계

    /* @return 할인 대상 금액 */

    // 파라미터로 member 와 price 를 넘김
    int discount(Member member, int price);

}
