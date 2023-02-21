package minki.HelloSpring.Service;
import minki.HelloSpring.domain.Member;
import minki.HelloSpring.repository.MemberRepository;
import minki.HelloSpring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
//@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long Join(Member member)
    {
        memberRepository.findByName(member.getName())
                .ifPresent(m->
                { throw new IllegalStateException("이미 존재하는 회원입니다!!");
        });
        memberRepository.save(member);
        return member.getId();
    }

    //전체회원조회
    public List<Member> findMembers()
    {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findById(memberId);
    }


}
