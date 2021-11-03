package helloworld.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // url에서 hello라는 태그를 발견할 경우 아래를 실행 (localhost:8080/hello)
    public String hello(Model model)
    {
        model.addAttribute("data", "hello!!");
        return "hello"; // hello.html 을 찾아서 이 페이지를 리턴 --> viewResolver가 수행
                        // viewResolver : 스프링 부트 템플릿엔진 기본 viewName 매핑 ('resources\templates\ + {ViewName} + .html')
    }

    @GetMapping("spring")
    public String spring(Model model)
    {
        model.addAttribute("data", "spring!!!");
        return "spring";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = true) String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello
    {
        private String name;

        public String getName()
        {
            return name;
        }
        public void setName(String name)
        {
            this.name = name;
        }
    }
}
