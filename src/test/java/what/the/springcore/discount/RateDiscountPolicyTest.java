package what.the.springcore.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import what.the.springcore.member.Grade;
import what.the.springcore.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% OK")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVip", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 10% NO")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }

}