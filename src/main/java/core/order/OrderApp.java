package core.order;

import core.order.member.*;
import core.order.member.MemberService;
import core.order.member.MemberServiceImpl;
import core.order.order.Order;
import core.order.order.OrderService;
import core.order.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
