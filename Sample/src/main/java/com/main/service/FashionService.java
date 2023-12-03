package com.main.service;

import java.util.List;
import java.util.Map;

import com.main.vo.FashionVo;

public interface FashionService {

	List<FashionVo> selectFashionList(Map<String, Object> map);

	int selectTotalCount(Map<String, Object> keyword);

	int insertfashion(FashionVo fashionvo);

}
