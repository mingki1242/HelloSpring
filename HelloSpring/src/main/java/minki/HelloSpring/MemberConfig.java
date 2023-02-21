package minki.HelloSpring;

import minki.HelloSpring.Service.MemberService;
import minki.HelloSpring.repository.MemberRepository;
import minki.HelloSpring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {
    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }
}
