package com.zerobase.fastlms.fastlms.member.controller;

import com.zerobase.fastlms.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.fastlms.member.model.ResetPasswordInput;
import com.zerobase.fastlms.fastlms.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/register")
    public String register() {
        return "member/register";
    }

    @PostMapping ("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request, HttpServletResponse response, MemberInput parameter) {

        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);

        return "member/register_complete";
    }

    @RequestMapping ("/member/login")
    public String login() {
        //System.out.println("1");
        return "member/login";
    }

    @GetMapping("member/find-password")
    public String findPassword(){
        return "member/find_password";
    }

    @PostMapping("member/find-password")
    public String findPasswordSubmit( Model model, ResetPasswordInput parameter){
       boolean result = false;
       try{
           result = memberService.sendResetPassword(parameter);
       } catch (Exception e){
       }
       model.addAttribute("result", result);

       return "member/find_password_result";
    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest request){
        String uuid = request.getParameter("id");

        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);

        return "member/email_auth";

    }
    @GetMapping("/member/info")
    public String memberInfo() {
        return "/member/info";
    }

    @GetMapping("/member/reset/password")
    public String resetPassword(Model model, HttpServletRequest request) {

        String uuid = request.getParameter("id");

        boolean result = memberService.checkResetPassword(uuid);
        //System.out.println(result);
        model.addAttribute("result", result);

        return "/member/reset_password";
    }
    @PostMapping("/member/reset/password")
    public String resetPassword(Model model, ResetPasswordInput parameter) {
        boolean result = false;
        try {
            result =memberService.resetPassword(parameter.getId(), parameter.getPassword());
        } catch (Exception e){
        }
        model.addAttribute("parameter", parameter);
        return "/member/reset_password_result";
    }
}
