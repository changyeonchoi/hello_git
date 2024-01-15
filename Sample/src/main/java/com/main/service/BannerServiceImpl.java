package com.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.dao.BannerDao;
import com.main.vo.BannerVo;
import com.main.vo.ProductVo;

@Service(value = "bannerservice")
public class BannerServiceImpl implements BannerService {
	
	@Resource(name = "bannerDao")
	private BannerDao bannerDao;

	@Override
	public int selectTotalCount(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		return bannerDao.selectTotalCount(keyword);
	}

	@Override
	public List<BannerVo> selectbannerList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BannerVo> bannerList = null;
		
		bannerList = bannerDao.selectbannerList(map);
		
		return bannerList;
	}

	@Override
	public int insertbanner(BannerVo bannervo) {
		// TODO Auto-generated method stub
		return bannerDao.insertbanner(bannervo);
	}

	@Override
	public BannerVo selectbannerdetail(Integer seq_id) {
		// TODO Auto-generated method stub
		return bannerDao.selectbannerdetail(seq_id);
	}

	@Override
	public void bannerupdate(BannerVo bannervo) {
		// TODO Auto-generated method stub
		bannerDao.bannerupdate(bannervo);
	}

	@Override
	public String bannerdelete(Integer seq_id) {
		// TODO Auto-generated method stub
		return bannerDao.bannerdelete(seq_id);
	}

	@Override
	public List<BannerVo> selectCouponList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<BannerVo> CouponProductList = null;
		
		CouponProductList = bannerDao.selectCouponList(map);
		
		return CouponProductList;
	}

	@Override
	public void couponupdate(BannerVo bannervo) {
		// TODO Auto-generated method stub
		bannerDao.couponupdate(bannervo);
	}

	@Override
	public void coupondelete(Integer seq_id) {
		// TODO Auto-generated method stub
		bannerDao.coupondelete(seq_id);
	}


}
