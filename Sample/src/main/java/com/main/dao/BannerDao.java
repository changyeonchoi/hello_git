package com.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.vo.BannerVo;

@Service(value = "bannerDao")
public class BannerDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int selectTotalCount(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("bannerDao.selectTotalCount", keyword);
	}

	public List<BannerVo> selectbannerList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("bannerDao.selectbannerList", map);
	}

	public int insertbanner(BannerVo bannervo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("bannerDao.insertbanner", bannervo);
	}

	public BannerVo selectbannerdetail(String seq_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("bannerDao.selectbannerdetail", seq_id);
	}


}
