package com.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.vo.BannerVo;
import com.main.vo.ProductVo;

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

	public BannerVo selectbannerdetail(Integer seq_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("bannerDao.selectbannerdetail", seq_id);
	}

	public void bannerupdate(BannerVo bannervo) {
		// TODO Auto-generated method stub
		sqlSession.update("bannerDao.bannerupdate", bannervo);
	}

	public String bannerdelete(Integer seq_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("bannerDao.bannerdelete", seq_id);
	}

	public List<BannerVo> selectCouponList(Map<String, Object> map) {
		return sqlSession.selectList("bannerDao.selectCouponList", map);
	}

	public void couponupdate(BannerVo bannervo) {
		// TODO Auto-generated method stub
		sqlSession.update("bannerDao.couponupdate", bannervo);
	}

	public void coupondelete(Integer seq_id) {
		// TODO Auto-generated method stub
		sqlSession.delete("bannerDao.coupondelete", seq_id);

	}



}
