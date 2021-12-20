package tutorial.tutorialspring.repository;

import org.junit.jupiter.api.Test;
import tutorial.tutorialspring.domin.Member;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    @Test
    void save() {

        //given
        Member member = new Member();
        member.setName("osh");

        //when
        repository.save(member);

        //then
        Member result = new Member();
        if(repository.findById(member.getId()).isPresent())
            result = repository.findById(member.getId()).get();

        assertThat(result).isEqualTo(member);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findAll() {
    }
}