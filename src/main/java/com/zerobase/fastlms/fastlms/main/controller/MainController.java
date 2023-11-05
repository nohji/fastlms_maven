package com.zerobase.fastlms.fastlms.main.controller;

import com.zerobase.fastlms.fastlms.components.MailComponents;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index(){
        //mailComponents.sendMailTest();

//        String email = "nogood1014@naver.com";
//        String subject = "안녕하세요. 제목입니다.";
//        String text = "<p>본문입니다.</p> <p>html 태그로 이뤄져있습니다.</p>";
//
//        mailComponents.sendMail(email, subject, text);

        return "index";
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        String msg = "<html>" +
                        "<head>" +
                            "<meta charset = \"UTF8\">" +
                        "</head>" +
                        "<body>" +
                            "<p> hello </p>" +
                            "<p> 안녕하세요!!! </p>" +
                        "</body>" +
                        "</html>";

        printWriter.write(msg);
        printWriter.close();

    }

    @RequestMapping("/error/denied")
    public String errorDenined() {
       return "error/denied";
    }
}
