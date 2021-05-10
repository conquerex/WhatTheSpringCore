package what.the.springcore;

import what.the.springcore.member.Grade;
import what.the.springcore.member.Member;
import what.the.springcore.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl(null);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(">>> new  :::" + member.getName());
        System.out.println(">>> find :::" + findMember.getName());
    }
}
