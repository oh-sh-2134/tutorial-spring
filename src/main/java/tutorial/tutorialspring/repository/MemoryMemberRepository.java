package tutorial.tutorialspring.repository;

import tutorial.tutorialspring.domin.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // store.values는 colletion 타입으로 뿌려줌 -> filter와 람다를 사용하기 위해 stream
                .filter(member -> member.getName().equals(name)) // filter와 람다를 이용해서 name와 같은 String을 찾음
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
