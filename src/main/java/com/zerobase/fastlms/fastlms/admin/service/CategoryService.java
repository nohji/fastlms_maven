package com.zerobase.fastlms.fastlms.admin.service;

import com.zerobase.fastlms.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.fastlms.admin.entity.Category;
import com.zerobase.fastlms.fastlms.admin.model.CategoryInput;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> list();

    // 카테고리 신규 추가
    boolean add(String categoryName);

    // 카테고리 수정
    boolean update(CategoryInput parameter);

    // 카테고리 삭제
    boolean del(long id);



}
