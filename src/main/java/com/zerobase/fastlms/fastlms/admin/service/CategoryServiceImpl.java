package com.zerobase.fastlms.fastlms.admin.service;

import com.zerobase.fastlms.fastlms.admin.dto.CategoryDto;
import com.zerobase.fastlms.fastlms.admin.entity.Category;
import com.zerobase.fastlms.fastlms.admin.model.CategoryInput;
import com.zerobase.fastlms.fastlms.admin.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private Sort getSortBySortValueDesc(){
        return Sort.by(Sort.Direction.DESC, "sortValue");
    }
    @Override
    public List<CategoryDto> list() {
        List<Category> categories= categoryRepository.findAll(getSortBySortValueDesc());
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
    public boolean update(CategoryInput parameter) {
        Optional<Category> optionalCategory = categoryRepository.findById(parameter.getId());
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            category.setCategoryName(parameter.getCategoryName());
            category.setSortValue(parameter.getSortValue());
            category.setUsingYn(parameter.isUsingYn());
            categoryRepository.save(category);
        }
        return true;
    }

    @Override
    public boolean del(long id) {
        categoryRepository.deleteById(id);
        return true;
    }
}
