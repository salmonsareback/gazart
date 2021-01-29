package com.duke.gazart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@SpringBootApplication
@RestController
public class GazartApplication {

    public static void main(String[] args) {
        SpringApplication.run(GazartApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(value = "myName", defaultValue = "World")
                    String name
    ) {
        return String.format("Hello %s !", name);
    }

    @GetMapping("/hello2")
    public String sayHello2(
            @RequestParam(value = "myName", defaultValue = "World")
                    String name
    ) {
        return String.format("Hello2 %s !", name);
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(@RequestParam Map<String,String> allParams ){
        return "Les paramètres sont" +allParams.entrySet ();
    }

    //    @GetMapping("/redirectWithRedirectView")
    @GetMapping("/")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        // attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        // attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("http://heleneducatillon.com");
    }

}
