package com.zerobase.fastlms.fastlms.member.service;

import com.zerobase.fastlms.fastlms.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    boolean register(MemberInput parameter);

    /* uuid에 해당하는 계정 활성화 */
    boolean emailAuth(String uuid);
}
