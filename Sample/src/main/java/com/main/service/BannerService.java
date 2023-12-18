package com.main.service;

import java.util.List;
import java.util.Map;

import com.main.vo.BannerVo;

public interface BannerService {

	int selectTotalCount(Map<String, Object> keyword);
	
	List<BannerVo> selectbannerList(Map<String, Object> map);

	int insertbanner(BannerVo bannervo);

	BannerVo selectbannerdetail(String seq_id);
}
