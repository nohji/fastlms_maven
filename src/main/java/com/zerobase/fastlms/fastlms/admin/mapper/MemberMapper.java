package com.zerobase.fastlms.fastlms.admin.mapper;

import com.zerobase.fastlms.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.fastlms.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    long selectListCount(MemberParam parameter);
    List<MemberDto> selectList(MemberParam parameter);
}
