package com.zerobase.fastlms.fastlms.admin.service;

import com.zerobase.fastlms.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.fastlms.admin.entity.Category;
import com.zerobase.fastlms.fastlms.admin.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> list() {
        List<Category> categories= categoryRepository.findAll();

        return CategoryDto.of(categories);
    }

    @Override
    public boolean add(String categoryName) {
        //카테고리명 중복 체크

        Category category = Category.builder()
                .categoryName(categoryName)
                .sortValue(0)
                .usingYn(true)
                .build();
        categoryRepository.save(category);

         return true;
    }

    @Override
    public boolean update(CategoryDto parameter) {
        return false;
    }

    @Override
    public boolean del(long id) {
        return false;
    }
}
