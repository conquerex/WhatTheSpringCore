package what.the.springcore.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
