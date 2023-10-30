package com.zerobase.fastlms.fastlms.member.controller;

import com.zerobase.fastlms.fastlms.member.entity.Member;
import com.zerobase.fastlms.fastlms.member.model.MemberInput;
import com.zerobase.fastlms.fastlms.member.repository.MemberRepository;
import com.zerobase.fastlms.fastlms.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String registerSubmit(HttpServletRequest request, HttpServletResponse response, MemberInput parameter) {

        boolean result = memberService.register(parameter);

        return "member/register_complete";
    }
}
