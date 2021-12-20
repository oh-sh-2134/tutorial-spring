package tutorial.tutorialspring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tutorial.tutorialspring.domin.Member;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

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
        // save에서 이미 검증함
    }

    @Test
    void findByName() {
        //given
        Member member = new Member();
        member.setName("osh");

        //when
        repository.save(member);

        //then
        Member result = new Member();
        if(repository.findByName(member.getName()).isPresent())
            result = repository.findByName(member.getName()).get();

        assertThat(result).isEqualTo(member);
    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member();
        member1.setName("name1");


        Member member2 = new Member();
        member2.setName("name2");


        //when
        repository.save(member1);
        repository.save(member2);


        //then
        assertThat(repository.findAll().size()).isEqualTo(2);
    }
}