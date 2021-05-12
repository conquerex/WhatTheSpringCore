package what.the.springcore.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import what.the.springcore.discount.DiscountPolicy;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberRepository;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    // final : 컴파일 오류를 일으켜 초기화 강제
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 조회 빈이 2개 이상 >> 필드명 혹은 파라미터명을 매칭 - rateDiscountPolicy
//    @Autowired // 생성자가 1개일 때, @Autowired 생략 가능
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = rateDiscountPolicy;
//    }

//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
/*
    // 수정자 주입 : 아래 set 메서드가 2개 있을 때 위 생성자 주입은 필요없다.
    @Autowired(required = false)
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }
*/

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
