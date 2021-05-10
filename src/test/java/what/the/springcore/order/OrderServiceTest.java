package what.the.springcore.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import what.the.springcore.AppConfig;
import what.the.springcore.member.Grade;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberService;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "zxzxz", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemmmm", 100000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}