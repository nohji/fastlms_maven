package com.zerobase.fastlms.fastlms.admin.dto;

import com.zerobase.fastlms.fastlms.admin.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
    Long ID;
    String categoryName;
    int sortValue;
    boolean usingYn;

    public static List<CategoryDto> of (List<Category> categories) {
        if(categories != null) {
            List<CategoryDto> categoryList = new ArrayList<>();
            for (Category x : categories) {
                categoryList.add(of(x));
            }
            return categoryList;
        }
        return null;
    }

    public static CategoryDto of(Category category) {
        return CategoryDto.builder()
                .ID(category.getID())
                .categoryName(category.getCategoryName())
                .sortValue(category.getSortValue())
                .usingYn(category.isUsingYn())
                .build();
    }
}
