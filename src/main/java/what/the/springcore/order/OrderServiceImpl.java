package what.the.springcore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import what.the.springcore.discount.DiscountPolicy;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
