package com.zerobase.fastlms.fastlms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPage {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
