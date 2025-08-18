package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberService 에 대한 구현체
    /* 가입을 하고 회원을 찾기 위해서는 앞에 만들었던 MemberRepository interface가 필요함 */
    // 구현 객체를 선택해줘야 함 -> MemoryMemberRepository
    private final MemberRepository memberRepository = new MemoryMemberRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
