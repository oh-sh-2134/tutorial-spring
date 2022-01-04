package tutorial.tutorialspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tutorial.tutorialspring.repository.JdbcMemberRepository;
import tutorial.tutorialspring.repository.JdbcTemplateMemberRepository;
import tutorial.tutorialspring.repository.MemberRepository;
import tutorial.tutorialspring.repository.MemoryMemberRepository;
import tutorial.tutorialspring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpirngConfig {

    private final DataSource dataSource;

    public SpirngConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
