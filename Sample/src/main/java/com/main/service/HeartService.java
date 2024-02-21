package com.main.service;

import java.util.List;

import com.main.vo.HeartVo;

public interface HeartService {

	List<HeartVo> selectHeartList(HeartVo heartvo);

}
