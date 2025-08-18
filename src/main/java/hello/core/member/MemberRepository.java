package hello.core.member;

// MemberRepository 인터페이스 설계
public interface MemberRepository {

    // 회원 저장
    void save(Member member);

    // 회원의 아이디로 회원 찾기
    Member findById(Long memberId);
}
