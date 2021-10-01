package core.order.discount;

import core.order.member.Grade;
import core.order.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int dixcountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return dixcountFixAmount;
        } else {
            return 0;
        }
    }
}
