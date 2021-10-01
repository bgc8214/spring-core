package core.order.order;

import core.order.discount.DiscountPolicy;
import core.order.discount.FixDiscountPolicy;
import core.order.member.MemberRepository;
import core.order.member.MemoryMemberRepository;

import core.order.member.*;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
