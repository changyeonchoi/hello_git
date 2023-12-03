package com.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.main.service.FashionService;
import com.main.service.PageNavigigationService;
import com.main.vo.FashionVo;
import com.main.vo.MemberVo;
import javax.annotation.Resource;

import com.main.utils.UploadFileUtils;

@Controller
public class FashionController {   
	
	@Autowired
	FashionService fashionservice;
	
	@Autowired
	PageNavigigationService pagenavigigationservice;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/fashion{type}", method = {RequestMethod.GET, RequestMethod.POST})
	public String fashion(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo,
			@RequestParam(name = "listSize", defaultValue = "10") int listSize,
    		@RequestParam(name = "naviSize", defaultValue = "20") int naviSize,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam("file_img") MultipartFile file_img,
	        @RequestParam("detail_img") MultipartFile detail_img,
	        @RequestParam(value = "banner_title", required=false) String banner_title,
	        @RequestParam(value = "product_name", required=false) String product_name,
	        @RequestParam(value = "product_amount", required=false) String product_amount,
	        @RequestParam(value = "delivery_fee", required=false) String delivery_fee,
	        @RequestParam(value = "company_name", required=false) String company_name,
	        @RequestParam(value = "company_phone", required=false) String company_phone,
	        @RequestParam(value = "company_yn", required=false) String company_yn,
//	        @RequestParam(value = "code", required=false) String code,
	        FashionVo fashionvo,
			@PathVariable String type,
			MultipartFile file) throws IOException, Exception {
		
		String returnUrl = null;
		
		MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
		
		fashionvo.setUser_id(membervo.getUser_id());
		
		if("list".equals(type)) {
			
			Map<String, Object> keyword = new HashMap<String, Object>();
	    	keyword.put("search", search);
	    	
	    	int totalCount = fashionservice.selectTotalCount(keyword);
	    	
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("pageNo", pageNo);
	    	map.put("totalCount", totalCount);
	    	map.put("listSize", listSize);
	    	map.put("naviSize", naviSize);
	    	map.put("search", search);
	    	
	    	PageNavigation pageNavigation = new PageNavigation(map);
	    	map.put("startRow", pageNavigation.getStartRow());
	    	map.put("endRow", pageNavigation.getEndRow());
	    	
	    	model.addAttribute("pageAttribute", map);
	        
	    	PageNavigation navigation = pagenavigigationservice.makePageNavigation(map);
	        
	    	model.addAttribute("navigation", navigation);
	        
	    	List<FashionVo> fashionList = fashionservice.selectFashionList(map);
	    	
	    	model.addAttribute("fashion", fashionList);
	    	
	    	returnUrl = "/fashionlist";
	    	
		} else if("enroll".equals(type)) {
			
			fashionvo.setUser_id(membervo.getUser_id());
			fashionvo.setBanner_title(banner_title);
			fashionvo.setProduct_name(product_name);
//			fashionvo.setFile_img(file_img);
			fashionvo.setProduct_amonut(product_amount);
			fashionvo.setDelivery_fee(delivery_fee);
			fashionvo.setCompany_name(company_name);
//			fashionvo.setDetail_img(detail_img);
			fashionvo.setCompany_phone(company_phone);
			fashionvo.setCompany_yn(company_yn);
//			fashionvo.setCode(code);
			
			String imgUploadPath = uploadPath + File.separator + "FashionImg";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = null;

			if(file != null) {
			 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
			} else {
			 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			}

			fashionvo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			fashionvo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
			fashionservice.insertfashion(fashionvo);
			
			returnUrl = "/fashioninsert";
		}
		return returnUrl;
	}

//	@RequestMapping("/fashionlist")
//	public String fashionlist() {
//		return "fashionlist";
//	}
	
//	@RequestMapping("/fashioninsert")
//	public String fashioninsert() {
//		return "fashioninsert";
//	}
//	
//	@RequestMapping("/fashiondetail")
//	public String fashiondetail() {
//		return "fashiondetail";
//	}
	
	@RequestMapping("/makeuplist")
	public String makeuplist() {
		return "makeuplist";
	}
	
	@RequestMapping("/makeupinsert")
	public String makeupinsert() {
		return "makeupinsert";
	}
	
	@RequestMapping("/makeupdetail")
	public String makeupdetail() {
		return "makeupdetail";
	}
	
	@RequestMapping("/accessorylist")
	public String accessorylist() {
		return "accessorylist";
	}
	
	@RequestMapping("/accessoryinsert")
	public String accessoryinsert() {
		return "accessoryinsert";
	}
	
	@RequestMapping("/accessorydetail")
	public String accessorydetail() {
		return "accessorydetail";
	}
}
