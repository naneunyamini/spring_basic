package hello.core.member;

// MemberService 인터페이스
public interface MemberService {

    // 회원가입하기
    void join(Member member);

    Member findMember(Long memberId);
}
