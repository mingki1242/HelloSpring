package minki.HelloSpring.Controller;

import minki.HelloSpring.Service.MemberService;
import minki.HelloSpring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService)
    {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String CreateForm()
    {
        return "/Members/createMemberForm";
    }

    @GetMapping(value = "/members")
    public String list(Model model)
    {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "Members/memberList";
    }

    @PostMapping(value = "/members/new")
    public String Create(MemberForm memberForm)
    {
        Member member = new Member();
        member.setName(memberForm.getName());
        memberService.Join(member);
        return "redirect:/";
    }





}
