package what.the.springcore.order;

import what.the.springcore.discount.DiscountPolicy;
import what.the.springcore.discount.FixDiscountPolicy;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberRepository;
import what.the.springcore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
