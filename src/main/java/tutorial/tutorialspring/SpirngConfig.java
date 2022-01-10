package tutorial.tutorialspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tutorial.tutorialspring.repository.JpaMemberRepository;
import tutorial.tutorialspring.repository.MemberRepository;
import tutorial.tutorialspring.service.MemberService;

@Configuration
public class SpirngConfig {

/*  Jpa
    private final DataSource dataSource;
    private final EntityManager em;

    public SpirngConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
*/
    private final MemberRepository memberRepository;

    @Autowired
    public SpirngConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/*    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}
