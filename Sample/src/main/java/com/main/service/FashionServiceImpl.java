package com.main.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.dao.FashionDao;
import com.main.vo.FashionVo;


@Service(value = "fashionservice")
public class FashionServiceImpl implements FashionService {

	@Resource(name = "fashionDao")
	private FashionDao fashionDao;

	@Override
	public List<FashionVo> selectFashionList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<FashionVo> fashionList = null;
		
		fashionList = fashionDao.selectFashionList(map);
		
		return fashionList;
	}

	@Override
	public int selectTotalCount(Map<String, Object> keyword) {
		// TODO Auto-generated method stub
		return fashionDao.selectTotalCount(keyword);
	}

	@Override
	public int insertfashion(FashionVo fashionvo) {
		// TODO Auto-generated method stub
		return fashionDao.insertfashion(fashionvo);
	}

	@Override
	public FashionVo selectfashiondetail(String seq_id) {
		// TODO Auto-generated method stub
		return fashionDao.selectfashiondetail(seq_id);
	}

	@Override
	public String deletefashion(String seq_id) {
		// TODO Auto-generated method stub
		return fashionDao.deletefashion(seq_id);
	}

	@Override
	public void updatefashion(FashionVo fashionvo) {
		// TODO Auto-generated method stub
		fashionDao.updatefashion(fashionvo);
	}


}