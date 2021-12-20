package tutorial.tutorialspring.repository;

import tutorial.tutorialspring.domin.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(String name);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    List<Member> findAll();

}
