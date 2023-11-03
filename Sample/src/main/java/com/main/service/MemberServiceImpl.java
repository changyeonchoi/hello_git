package com.main.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.dao.MemberDao;
import com.main.vo.MemberVo;


@Service(value = "memberService")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "memberDao")
	private MemberDao memberDao;

	@Override
	public boolean signupCheck(String user_id) {
		boolean checkResult = false;
		
		checkResult = memberDao.signupCheck(user_id);
		
		return checkResult;
	}

	@Override
	public String signupSuccess(MemberVo membervo) {

		memberDao.signupSuccess(membervo);
		
		return null;
	}

	@Override
	public MemberVo login(MemberVo membervo) {
		
		return memberDao.login(membervo);
	}

	@Override
	public boolean loginCheck(MemberVo membervo) {
		
		boolean check = memberDao.loginCheck(membervo);
		
		return check;
	}
	
}