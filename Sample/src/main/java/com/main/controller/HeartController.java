package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.service.HeartService;
import com.main.vo.HeartVo;

@Controller
public class HeartController {
	
	@Autowired
	HeartService heartservice;
	
	@RequestMapping(value = "/heartlist", method = RequestMethod.GET)
	public String heart(Model model, HeartVo heartvo) {
		
	    List<HeartVo> heartList = heartservice.selectHeartList(heartvo);
	    
	    model.addAttribute("heartList" , heartList);
	    
	    return "/heartlist";
	}
	
	@RequestMapping(value = "/heartlist", method = RequestMethod.POST)
	public @ResponseBody List<HeartVo> heartajax(Model model, @RequestBody HeartVo heartvo) {
		
		System.out.println("Received product_selection: " + heartvo);

		List<HeartVo> heartList = heartservice.selectHeartList(heartvo);
		
		return heartList;
	}
	
}
