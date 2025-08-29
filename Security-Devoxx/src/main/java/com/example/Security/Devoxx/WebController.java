package com.example.Security.Devoxx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String publicPage(){
        return "Hello Public Page";
    }

    @GetMapping("/private")
    public String privatePage(){
        return "This is private page";
    }


}
