package com.zerobase.fastlms.fastlms.member.service;

import com.zerobase.fastlms.fastlms.member.model.MemberInput;

public interface MemberService {
    boolean register(MemberInput parameter);

    /* uuid에 해당하는 계정 활성화 */
    boolean emailAuth(String uuid);
}
