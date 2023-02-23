package minki.HelloSpring;

import minki.HelloSpring.Controller.MemberController;
import minki.HelloSpring.Service.MemberService;
import minki.HelloSpring.repository.JpaMemberRepository;
import minki.HelloSpring.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class MemberConfig {
    private final DataSource dataSource;
    private final EntityManager em;
    public MemberConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        //return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
}
