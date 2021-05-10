package what.the.springcore;

import what.the.springcore.discount.FixDiscountPolicy;
import what.the.springcore.member.MemberService;
import what.the.springcore.member.MemberServiceImpl;
import what.the.springcore.member.MemoryMemberRepository;
import what.the.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
