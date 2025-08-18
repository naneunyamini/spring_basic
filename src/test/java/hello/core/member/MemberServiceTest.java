package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Bean;

public class MemberServiceTest {

    MemberService memberService;

    // MemberService memberService = new MemberServiceImpl();


    // Test 를 실행하기 전에 무조건 먼저 실행됨
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);

        //when
        /* 회원가입을 했을 때 */
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then (검증)
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
