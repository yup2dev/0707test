package com.ll.aaaa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String root(){
        return "redirect:/article/list";
    }
}
