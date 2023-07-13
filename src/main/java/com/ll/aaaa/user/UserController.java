package com.ll.aaaa.user;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final SiteUserService siteUserService;
    @GetMapping("/user/signup")
    public String signup(UserCreateForm userCreateForm){
        return "signup_form";
    }

    @PostMapping("/user/signup")
    public String signupP(@Validated UserCreateForm userCreateForm, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            redirectAttributes.addFlashAttribute("popupMessage", "비밀번호가 일치하지 않습니다");
            return "signup_form";
        }
        try {
            siteUserService.createUser(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());
        }catch(DataIntegrityViolationException e) {
        e.printStackTrace();
        bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
        return "signup_form";
    }catch(Exception e) {
        e.printStackTrace();
        bindingResult.reject("signupFailed", e.getMessage());
        return "signup_form";
    }
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String login(){
        return "login_form";
    }

    @PostMapping("/user/login")
    public String loginOK(){
        return "redirect:/";
    }
}
