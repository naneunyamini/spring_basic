package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;

public class OrderServiceImpl implements OrderService {

    // 필요한 두 가지
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    // 주문 생성 요청이 오면
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 조회하고
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책에다가 회원을 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice); // 값 반환해주기
    }
}
