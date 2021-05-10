package what.the.springcore;

import what.the.springcore.member.Grade;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberService;
import what.the.springcore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(">>> new  :::" + member.getName());
        System.out.println(">>> find :::" + findMember.getName());
    }
}
