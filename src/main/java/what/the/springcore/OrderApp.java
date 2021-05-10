package what.the.springcore;

import what.the.springcore.member.Grade;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberService;
import what.the.springcore.order.Order;
import what.the.springcore.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "asdf", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemmmm", 100000);

        System.out.println("order ::: " + order);
        System.out.println("order ::: " + order.calculatePrice());
    }
}
