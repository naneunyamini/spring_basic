package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.*;

public class OrderServiceImpl implements OrderService {


    // config 추가하기 전
   /*  private final MemberRepository memberRepository = new MemoryMemberRepository();
       DIP (의존성 역전) 지키기 : 인터페이스에만 의존하기 -> 하지만 null pointer exception 발생 !!
       private DiscountPolicy discountPolicy;
     */

    // config 추가 후
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // config 추가 후 생성자도 생성해야함
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    // 주문 생성 요청이 오면
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 조회하고
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책에다가 회원을 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice); // 값 반환해주기
    }
}
