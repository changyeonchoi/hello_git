package com.main.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.main.service.BannerService;
import com.main.service.PageNavigigationService;
import com.main.vo.BannerVo;
import com.main.vo.MemberVo;

@Controller
public class BannerController {

	@Autowired
	BannerService bannerservice;
	
	@Autowired
	PageNavigigationService pagenavigigationservice;

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/bannerlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String banner(Model model
			, @RequestParam(value="code", required=false) String code 
			, @RequestParam(value = "search", defaultValue = "") String search
			, BannerVo bannervo
			, HttpSession session
			, HttpServletRequest request
			, @RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo
			, @RequestParam(name = "listSize", defaultValue = "10") int listSize
    		, @RequestParam(name = "naviSize", defaultValue = "20") int naviSize
    		, @RequestParam(value = "file_img", required=false) MultipartFile file_img
    		, @RequestParam(value = "banner_name", required=false) String banner_name
    		, @RequestParam(value = "banner_area", required=false) String banner_area
    		, @RequestParam(value = "banner_yn", required=false) String banner_yn
    		, @RequestParam(value = "user_id", required=false) String user_id
    		) throws IOException {
		
				MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
				
			    bannervo.setUser_id(membervo.getUser_id());
			    
			    Map<String, Object> keyword = new HashMap<String, Object>();
		    	keyword.put("search", search);
		    	keyword.put("code", code);
		    	
		    	int totalCount = bannerservice.selectTotalCount(keyword);
		    	
		    	System.out.println(totalCount);
		    	
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("pageNo", pageNo);
		    	map.put("totalCount", totalCount);
		    	map.put("listSize", listSize);
		    	map.put("naviSize", naviSize);
		    	map.put("search", search);
		    	map.put("code", code);
		    	
		    	PageNavigation pageNavigation = new PageNavigation(map);
		    	map.put("startRow", pageNavigation.getStartRow());
		    	map.put("endRow", pageNavigation.getEndRow());
		    	
		    	PageNavigation navigation = pagenavigigationservice.makePageNavigation(map);
				
		    	List<BannerVo> bannerList = bannerservice.selectbannerList(map);

				model.addAttribute("pageAttribute", map);
				model.addAttribute("banner", bannerList);
				model.addAttribute("navigation", navigation);
				
				return "/bannerlist";
	}
	
	@RequestMapping(value = "/bannerenroll", method = {RequestMethod.GET, RequestMethod.POST})
	public String bannerinsert (Model model
    		, @RequestParam(value = "file_img") MultipartFile file_img
    		, @RequestParam(value = "banner_name") String banner_name
    		, @RequestParam(value = "banner_area") String banner_area
    		, @RequestParam(value = "banner_yn") String banner_yn
    		, @RequestParam(value = "land_url") String land_url
    		, @RequestParam(value = "code") String code
    		, BannerVo bannervo
    		, HttpServletRequest request) throws IOException {
		
		MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
		
		bannervo.setUser_id(membervo.getUser_id());
		bannervo.setBanner_name(banner_name);
		bannervo.setFile_img(file_img, uploadPath, bannervo.getFile_img());
		bannervo.setBanner_area(banner_area);
		bannervo.setLand_url(land_url);
		bannervo.setBanner_yn(banner_yn);
		bannervo.setCode(code);
		
		return "/bannerinsert";
	}
	
	@RequestMapping(value = "/bannerdetail", method = {RequestMethod.GET, RequestMethod.POST})
	public String bannerdetail (Model model, String seq_id) {
		
		BannerVo bannervo = bannerservice.selectbannerdetail(seq_id);
		
		model.addAttribute("banner" , bannervo);
		
		return "/bannerdetail";
	}
}

