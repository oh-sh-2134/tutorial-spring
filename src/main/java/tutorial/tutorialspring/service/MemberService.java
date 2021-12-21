package tutorial.tutorialspring.service;

import tutorial.tutorialspring.domin.Member;
import tutorial.tutorialspring.repository.MemberRepository;
import tutorial.tutorialspring.repository.MemoryMemberRepository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
            회원가입
    */
    public Long join(Member member){
        validateDuvalidateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuvalidateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }
    // 전체 회원 조회
    public List<Member> findMembers(){ return memberRepository.findAll();}

    // 회원 조회
    public Optional<Member> findOne(Long MemberId) {return memberRepository.findById(MemberId);}
}
