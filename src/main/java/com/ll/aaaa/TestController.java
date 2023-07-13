package com.ll.aaaa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/navTest")
    public String navbar(){
        return "navbar";
    }
    @GetMapping("/layTest")
    public String layTest(){
        return "layout";
    }
}
