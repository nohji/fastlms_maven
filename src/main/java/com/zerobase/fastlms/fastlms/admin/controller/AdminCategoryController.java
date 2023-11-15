package com.zerobase.fastlms.fastlms.admin.controller;

import com.zerobase.fastlms.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.fastlms.admin.model.CategoryInput;
import com.zerobase.fastlms.fastlms.admin.model.MemberInput;
import com.zerobase.fastlms.fastlms.admin.model.MemberParam;
import com.zerobase.fastlms.fastlms.admin.service.CategoryService;
import com.zerobase.fastlms.fastlms.member.service.MemberService;
import com.zerobase.fastlms.fastlms.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminCategoryController {

    private final CategoryService categoryService;

    @GetMapping("admin/category/list.do")
    public String list(Model model, MemberParam parameter){

        List<CategoryDto> list = categoryService.list();
        model.addAttribute("list", list);

        return "admin/category/list";
    }

    @PostMapping("admin/category/add.do")
    public String list(Model model, CategoryInput parameter){

        boolean result = categoryService.add(parameter.getCategoryName());
        return "redirect:/admin/category/list.do";
    }
}
