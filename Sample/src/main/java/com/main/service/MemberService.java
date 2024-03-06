package com.main.service;

import java.util.List;
import java.util.Map;

import com.main.vo.MemberVo;
import com.main.vo.OrderVo;


public interface MemberService {

	boolean signupCheck(String user_id);
	
	String signupSuccess(MemberVo membervo);

	MemberVo login(MemberVo membervo);
	
	boolean idCheck(MemberVo membervo);

	boolean loginCheck(MemberVo membervo);
	
//	public List<MemberVo> selectMemberList(String search);
	
	public List<MemberVo> selectMemberList(Map<String, Object> map);
	
	public List<MemberVo> selectUserList(Map<String, Object> map);

	MemberVo selectMemberdetail(String user_id);
	
	MemberVo selectUserdetail(String user_id);

	int deleteMemberId(String user_id);

	void updateUser(MemberVo membervo);

	int selectTotalCount(Map<String, Object> map);
	
	int deleteUserId(String user_id);

	int selectTotalCountUser(Map<String, Object> map);

	List<MemberVo> selectUserOrderList(Map<String, Object> map);

	int ordercount(Map<String, Object> keyword);

	List<OrderVo> OrderList(Map<String, Object> map);

}
