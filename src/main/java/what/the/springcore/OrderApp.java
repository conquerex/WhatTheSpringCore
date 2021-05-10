package what.the.springcore;

import what.the.springcore.member.Grade;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberService;
import what.the.springcore.member.MemberServiceImpl;
import what.the.springcore.order.Order;
import what.the.springcore.order.OrderService;
import what.the.springcore.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "asdf", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemmmm", 100000);

        System.out.println("order ::: " + order);
    }
}
