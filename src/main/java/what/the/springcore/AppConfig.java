package what.the.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import what.the.springcore.discount.DiscountPolicy;
import what.the.springcore.discount.FixDiscountPolicy;
import what.the.springcore.discount.RateDiscountPolicy;
import what.the.springcore.member.MemberRepository;
import what.the.springcore.member.MemberService;
import what.the.springcore.member.MemberServiceImpl;
import what.the.springcore.member.MemoryMemberRepository;
import what.the.springcore.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    // 스프링 컨테이너에 등록된 객체를 '스프링 빈'이라고 한다.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderServiceImpl orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
