package com.main.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.dao.HeartDao;
import com.main.vo.HeartVo;

@Service(value = "heartservice")
public class HeartServiceImpl implements HeartService {
	
	@Resource(name = "heartDao")
	private HeartDao heartDao;

	@Override
	public List<HeartVo> selectHeartList(HeartVo heartvo) {
		List<HeartVo> heartList = null;
		
		heartList = heartDao.selectHeartList(heartvo);
		
		return heartList;
	}

}
