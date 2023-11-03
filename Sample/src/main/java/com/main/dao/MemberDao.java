package com.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.vo.MemberVo;

@Service(value = "memberDao")
public class MemberDao {
	
	@Autowired
	private SqlSession sqlSession;

	public boolean signupCheck(String user_id) {
		boolean checkResult = false;
		
		List<MemberVo> memberVo = sqlSession.selectList("memberDao.signupCheck",user_id);
		
		if(memberVo.size() > 0) {
			
		} else {
			checkResult = true;
		}
		return checkResult; 
	}

	public String signupSuccess(MemberVo membervo) {
		
		sqlSession.insert("memberDao.signupSuccess", membervo);
		
		return null;
	}

	public MemberVo login(MemberVo membervo) {
		MemberVo login = sqlSession.selectOne("memberDao.login", membervo);
		return login;
	}

	public boolean loginCheck(MemberVo membervo) {
		
		boolean check = false;
		
		try {
			MemberVo result = sqlSession.selectOne("memberDao.loginCheck", membervo);
			if(result == null) {
				check = false;
			} else {
				check = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
