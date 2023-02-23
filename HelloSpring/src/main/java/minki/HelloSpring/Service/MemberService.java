package minki.HelloSpring.Service;
import minki.HelloSpring.domain.Member;
import minki.HelloSpring.repository.JpaMemberRepository;

import minki.HelloSpring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Transactional
//@Service
public class MemberService {
    private final MemberRepository jpamemberRepository;
    @Autowired
    public MemberService(MemberRepository jpamemberRepository)
    {
        this.jpamemberRepository = jpamemberRepository;
    }

    //회원가입

    public Long Join(Member member)
    {
        jpamemberRepository.findByName(member.getName())
                .ifPresent(m->
                { throw new IllegalStateException("이미 존재하는 회원입니다!!");
        });
        jpamemberRepository.save(member);
        return member.getId();
    }

    //전체회원조회
    public List<Member> findMembers()
    {
        return jpamemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId)
    {
        return jpamemberRepository.findById(memberId);
    }


}
