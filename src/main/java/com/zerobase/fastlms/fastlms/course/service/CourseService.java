package com.zerobase.fastlms.fastlms.course.service;

import com.zerobase.fastlms.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.fastlms.course.model.CourseInput;
import com.zerobase.fastlms.fastlms.course.model.CourseParam;

import java.util.List;

public interface CourseService {

    //  강좌 등록
    boolean add(CourseInput parameter);

    //  강좌 목록
    List<CourseDto> list(CourseParam parameter);
}
