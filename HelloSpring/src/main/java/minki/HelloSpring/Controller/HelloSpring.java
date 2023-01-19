package minki.HelloSpring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpring {
    //hello 라는 html에 들어가서 data항복을 helloSpring으로 변경
    @GetMapping("hello")
    public String Hello(Model model)
    {
        model.addAttribute("data" , "helloSpring!!");
        return "hello";
    }

    /*mvc 방식 : url에 localhost:8080/hello-spring?name="hellospring" 이라고 입력하면 name이 hellospring으로 바뀜 페이지소스도
    바뀜*/
    @GetMapping("hello-spring")
    @ResponseBody
    public String Hellomvc(@RequestParam("name") String name,Model model)
    {
        model.addAttribute("name" , name);
        return "hello-spring";
    }

    /*api 방식 api 방식은 객체를 리턴하며 이는 ResponseBody를 사용한다 해당 ResponseBody를 시용하면 뷰리졸버가 아닌
    jasonConverter가 jason 형식으로 리턴함 json 은 키 밸류 쌍을 의미한다
     */
    @GetMapping("hello-api")
    @ResponseBody
    public hello helloapi(@RequestParam("name") String name)
    {
        hello _hello = new hello();
        _hello.setName(name);
        return _hello;
    }

    static class hello
    {
        private String name;
        public String getName()
        {
            return name;
        }
        public void setName(String Name)
        {
            this.name = Name;
        }

    }

}
