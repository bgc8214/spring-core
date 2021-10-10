package core.order;

import core.order.discount.DiscountPolicy;
import core.order.discount.RateDiscountPolicy;
import core.order.member.MemberRepository;
import core.order.member.MemberService;
import core.order.member.MemberServiceImpl;
import core.order.member.MemoryMemberRepository;
import core.order.order.OrderService;
import core.order.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
