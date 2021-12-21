package tutorial.tutorialspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tutorial.tutorialspring.repository.MemberRepository;
import tutorial.tutorialspring.repository.MemoryMemberRepository;
import tutorial.tutorialspring.service.MemberService;

@Configuration
public class SpirngConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
