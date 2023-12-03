package com.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.vo.FashionVo;


@Service(value = "fashionDao")
public class FashionDao {
	
	@Autowired
	private SqlSession sqlSession;

	public List<FashionVo> selectFashionList(Map<String, Object> map) {
		return sqlSession.selectList("fashionDao.selectFashionList", map);
	}

	public int selectTotalCount(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("fashionDao.selectTotalCount", keyword);
	}

	public int insertfashion(FashionVo fashionvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("fashionDao.insertfashion", fashionvo);
	}

}
