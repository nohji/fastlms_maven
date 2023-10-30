package com.zerobase.fastlms.fastlms;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
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
}
