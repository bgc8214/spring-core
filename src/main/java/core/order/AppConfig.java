package core.order;

import core.order.discount.FixDiscountPolicy;
import core.order.member.MemberService;
import core.order.member.MemberServiceImpl;
import core.order.member.MemoryMemberRepository;
import core.order.order.OrderService;
import core.order.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
