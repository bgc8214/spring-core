package core.order.discount;

import core.order.member.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import core.order.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy =  new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10퍼센트 할인이 적용되어야야 한다.")
    public void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 1000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("BASIC은  10퍼센트 할인이 적용안되어야 한다.")
    public void vip_x(){
        //given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 1000);
        //then
        assertThat(discount).isEqualTo(0);
    }


}