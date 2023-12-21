package com.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.dao.BannerDao;
import com.main.vo.BannerVo;

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
	public BannerVo selectbannerdetail(String seq_id) {
		// TODO Auto-generated method stub
		return bannerDao.selectbannerdetail(seq_id);
	}

	@Override
	public void bannerupdate(BannerVo bannervo) {
		// TODO Auto-generated method stub
		bannerDao.bannerupdate(bannervo);
	}

	@Override
	public String bannerdelete(String seq_id) {
		// TODO Auto-generated method stub
		return bannerDao.bannerdelete(seq_id);
	}


}
