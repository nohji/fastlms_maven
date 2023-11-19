package com.zerobase.fastlms.fastlms.course.repository;

import com.zerobase.fastlms.fastlms.admin.entity.Category;
import com.zerobase.fastlms.fastlms.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
