package tutorial.tutorialspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tutorial.tutorialspring.repository.JdbcTemplateMemberRepository;
import tutorial.tutorialspring.repository.JpaMemberRepository;
import tutorial.tutorialspring.repository.MemberRepository;
import tutorial.tutorialspring.service.MemberService;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpirngConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public SpirngConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
