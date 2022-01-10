package tutorial.tutorialspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutorial.tutorialspring.domin.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository{

    Optional<Member> findByName(String name);
}
