package what.the.springcore.order;

import org.junit.jupiter.api.Test;
import what.the.springcore.discount.FixDiscountPolicy;
import what.the.springcore.member.Grade;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "namemmm", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "kjkjj", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}