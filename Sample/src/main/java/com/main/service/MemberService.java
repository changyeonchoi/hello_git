package com.main.service;

import com.main.vo.MemberVo;

public interface MemberService {

	boolean signupCheck(String user_id);
	
	String signupSuccess(MemberVo membervo);

	MemberVo login(MemberVo membervo);

	boolean loginCheck(MemberVo membervo);
	
}
