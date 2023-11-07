package com.main.service;

import java.util.List;
import java.util.Map;

import com.main.vo.MemberVo;

public interface MemberService {

	boolean signupCheck(String user_id);
	
	String signupSuccess(MemberVo membervo);

	MemberVo login(MemberVo membervo);

	boolean loginCheck(MemberVo membervo);
	
	public List<MemberVo> selectMemberList(String search);
	
	public List<MemberVo> selectMemberList();

	MemberVo selectMemberdetail(String user_id);

	int deleteUserId(String user_id);

	void updateUser(MemberVo membervo);
	
//	List<MemberVo> searchMembers(String search, int page, int pageSize);
//	
//    int countSearchedMembers(String search);

}
