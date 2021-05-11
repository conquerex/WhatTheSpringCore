package what.the.springcore;

import what.the.springcore.discount.DiscountPolicy;
import what.the.springcore.discount.FixDiscountPolicy;
import what.the.springcore.discount.RateDiscountPolicy;
import what.the.springcore.member.MemberRepository;
import what.the.springcore.member.MemberService;
import what.the.springcore.member.MemberServiceImpl;
import what.the.springcore.member.MemoryMemberRepository;
import what.the.springcore.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
