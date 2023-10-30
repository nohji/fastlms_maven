package com.zerobase.fastlms.fastlms.member.repository;

import com.zerobase.fastlms.fastlms.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
