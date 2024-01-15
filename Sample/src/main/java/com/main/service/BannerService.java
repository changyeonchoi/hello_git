package com.main.service;

import java.util.List;
import java.util.Map;

import com.main.vo.BannerVo;

public interface BannerService {

	int selectTotalCount(Map<String, Object> keyword);
	
	List<BannerVo> selectbannerList(Map<String, Object> map);

	int insertbanner(BannerVo bannervo);

	BannerVo selectbannerdetail(Integer seq_id);

	void bannerupdate(BannerVo bannervo);

	String bannerdelete(Integer seq_id);

	List<BannerVo> selectCouponList(Map<String, Object> map);

	void couponupdate(BannerVo bannervo);

	void coupondelete(Integer seq_id);

}
