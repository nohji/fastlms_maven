package com.zerobase.fastlms.fastlms.admin.mapper;

import com.zerobase.fastlms.fastlms.admin.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> selectList(MemberDto parameter);
}
