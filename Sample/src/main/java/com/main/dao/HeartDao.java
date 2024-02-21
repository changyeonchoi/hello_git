package com.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.vo.HeartVo;

@Service(value = "heartDao")
public class HeartDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<HeartVo> selectHeartList(HeartVo heartvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("heartDao.selectHeartList", heartvo);
	}

}
