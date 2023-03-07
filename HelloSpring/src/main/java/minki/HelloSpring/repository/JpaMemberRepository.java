package minki.HelloSpring.repository;

import minki.HelloSpring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    //jpa를 쓰려면 아래 entitymanager를 주입받아야한다
    private final EntityManager em;
    public JpaMemberRepository(EntityManager em)
    {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        //persist는 영구 저장하다 조회하다는 뜻
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //멤버 클래스에서 id를 찾아 멤버 객체에 집어넣는 함수
        Member member = em.find(Member.class,id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        //쿼리를 적고 이름 같은것을
        List<Member> result=  em.createQuery("select m from MEMBER m where m.name = :name",Member.class)
                .setParameter("name" , name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
