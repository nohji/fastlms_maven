package com.zerobase.fastlms.fastlms.admin.dto;

import com.zerobase.fastlms.fastlms.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberDto  {
    String userId;
    String userName;
    String phone;
    String password;
    LocalDateTime regDt;

    boolean emailAuthYn;
    LocalDateTime emailAuthDt;
    String emailAuthKey;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;
    String userStatus;

    //추가 컬럼
    long totalCount;
    long seq;


    public static MemberDto of(Member member){

        return MemberDto.builder()
                .userId(member.getUserId())
                .emailAuthDt(member.getEmailAuthDt())
                .emailAuthKey(member.getEmailAuthKey())
                .emailAuthYn(member.isEmailAuthYn())
//              .password(member.getPassword())
                .phone(member.getPhone())
                .regDt(member.getRegDt())
                .userName(member.getUserName())
                .resetPasswordKey(member.getResetPasswordKey())
                .resetPasswordLimitDt(member.getResetPasswordLimitDt())
                .adminYn(member.isEmailAuthYn())
                .userStatus(member.getUserStatus())
                .build();
    }
}
