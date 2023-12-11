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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.main.service.ProductService;
import com.main.service.PageNavigigationService;
import com.main.vo.MemberVo;
import com.main.vo.ProductVo;

@Controller
public class ProductController {   
	
	@Autowired
	ProductService productservice;
	
	@Autowired
	PageNavigigationService pagenavigigationservice;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/{type}", method = {RequestMethod.GET, RequestMethod.POST})
	public String product(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo,
			@RequestParam(name = "listSize", defaultValue = "10") int listSize,
    		@RequestParam(name = "naviSize", defaultValue = "20") int naviSize,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "file_img", required=false) MultipartFile file_img,
	        @RequestParam(value = "detail_img", required=false) MultipartFile detail_img,
	        @RequestParam(value = "banner_title", required=false) String banner_title,
	        @RequestParam(value = "product_name", required=false) String product_name,
	        @RequestParam(value = "product_amount", required=false) String product_amount,
	        @RequestParam(value = "delivery_fee", required=false) String delivery_fee,
	        @RequestParam(value = "company_name", required=false) String company_name,
	        @RequestParam(value = "company_phone", required=false) String company_phone,
	        @RequestParam(value = "company_yn", required=false) String company_yn,
	        @RequestParam(value = "seq_id", required=false) String seq_id,
	        @RequestParam(value = "detail_url", required=false) String detail_url,
	        @RequestParam(value = "code", required=false) String code,
	        ProductVo productvo,
			@PathVariable String type
			) throws IOException {
		
		 	String returnUrl = null;
		 
		    if (type.startsWith("fashion")) {
		        code = "fashion";
		    } else if (type.startsWith("makeup")) {
		        code = "makeup";
		    } else if (type.startsWith("accessory")) {
		        code = "accessory";
		    }

			MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
			
		    productvo.setUser_id(membervo.getUser_id());
		    
		    Map<String, Object> keyword = new HashMap<String, Object>();
	    	keyword.put("search", search);
	    	keyword.put("code", code);
	    	
	    	int totalCount = productservice.selectTotalCount(keyword);
	    	
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
			
	    	List<ProductVo> productList = productservice.selectFashionList(map);
	    	
		if("fashion".equals(code)) {
			
			if("fashionlist".equals(type)) {
		    	
		    	model.addAttribute("pageAttribute", map);
		    	model.addAttribute("fashion", productList);
		    	model.addAttribute("navigation", navigation);
		    	
		    	returnUrl = "/fashionlist";
	
			} else if("fashionenroll".equals(type)) {
				
				productvo.setUser_id(membervo.getUser_id());
				productvo.setBanner_title(banner_title);
				productvo.setProduct_name(product_name);
				productvo.setProduct_amonut(product_amount);
				productvo.setDelivery_fee(delivery_fee);
				productvo.setCompany_name(company_name);
				productvo.setFile_img(file_img, uploadPath, productvo.getFile_img());
				productvo.setDetail_img(detail_img, uploadPath, productvo.getDetail_img());
				productvo.setCompany_phone(company_phone);
				productvo.setCompany_yn(company_yn);
				productvo.setCode("fashion");
				
				productservice.insertfashion(productvo);
				
				returnUrl = "/fashioninsert";
				
			} else if("fashiondetail".equals(type)) {
				
				productvo = productservice.selectfashiondetail(seq_id);
				
				model.addAttribute("fashionvo", productvo);
				
				returnUrl = "/fashiondetail";
				
			} else if("fashiondelete".equals(type)) {
				
				productservice.deletefashion(seq_id);
				
				returnUrl = "/fashionlist";
				
			} else if("fashionupdate".equals(type)) {
	
				productvo.setUser_id(membervo.getUser_id());
				productvo.setSeq_id(seq_id);
				productvo.setBanner_title(banner_title);
				productvo.setProduct_name(product_name);
				productvo.setProduct_amonut(product_amount);
				productvo.setDelivery_fee(delivery_fee);
				productvo.setCompany_name(company_name);
				productvo.setCompany_phone(company_phone);
				productvo.setCompany_yn(company_yn);
				productvo.setFile_img(file_img, uploadPath, productvo.getFile_img());
				productvo.setDetail_img(detail_img, uploadPath, productvo.getDetail_img());
	
				productservice.updatefashion(productvo);
				
				returnUrl = "/fashionlist";
			}
		} else if("makeup".equals(code)) {
			
			if("makeuplist".equals(type)) {
				    	
				model.addAttribute("pageAttribute", map);
				model.addAttribute("makeup", productList);
				model.addAttribute("navigation", navigation);
		    	
				returnUrl = "/makeuplist";
				
			} else if("makeupenroll".equals(type)) {
				
				productvo.setUser_id(membervo.getUser_id());
				productvo.setBanner_title(banner_title);
				productvo.setProduct_name(product_name);
				productvo.setFile_img(file_img, uploadPath, productvo.getFile_img());
				productvo.setDetail_url(detail_url);
				productvo.setCompany_name(company_name);
				productvo.setCompany_phone(company_phone);
				productvo.setCompany_yn(company_yn);
				productvo.setCode("makeup");
				
				productservice.insertfashion(productvo);
				
				returnUrl = "/makeupinsert";
				
			} else if("makeupdetail".equals(type)) {
				
				productvo = productservice.selectfashiondetail(seq_id);
				
				model.addAttribute("makeup", productvo);
				
				returnUrl = "/makeupdetail";
				
			} else if("makeupupdate".equals(type)) {
	
				productvo.setUser_id(membervo.getUser_id());
				productvo.setSeq_id(seq_id);
				productvo.setBanner_title(banner_title);
				productvo.setProduct_name(product_name);
				productvo.setCompany_name(company_name);
				productvo.setCompany_phone(company_phone);
				productvo.setCompany_yn(company_yn);
				productvo.setFile_img(file_img, uploadPath, productvo.getFile_img());
	
				productservice.updatemakeup(productvo);
				
				returnUrl = "/makeuplist";
			} 
		} else if("accessory".equals(code)) {
			
			if("accessorylist".equals(type)) {
		    	
		    	model.addAttribute("pageAttribute", map);
		    	model.addAttribute("accessory", productList);
		    	model.addAttribute("navigation", navigation);
		    	
		    	returnUrl = "/accessorylist";
	
			} else if("accessoryenroll".equals(type)) {
				
				productvo.setUser_id(membervo.getUser_id());
				productvo.setBanner_title(banner_title);
				productvo.setProduct_name(product_name);
				productvo.setFile_img(file_img, uploadPath, productvo.getFile_img());
				productvo.setProduct_amount(product_amount);
				productvo.setDelivery_fee(delivery_fee);
				productvo.setCompany_name(company_name);
				productvo.setDetail_img(detail_img, uploadPath, productvo.getDetail_img());
				productvo.setCompany_phone(company_phone);
				productvo.setCompany_yn(company_yn);
				productvo.setCode("accessory");
				
				productservice.insertfashion(productvo);
				
				returnUrl = "/accessoryinsert";
				
			} else if("accessorydetail".equals(type)) {
				
				productvo = productservice.selectfashiondetail(seq_id);
				
				model.addAttribute("accessory", productvo);
				
				returnUrl = "/accessorydetail";
				
			} else if("accessoryupdate".equals(type)) {
	
				productvo.setUser_id(membervo.getUser_id());
				productvo.setSeq_id(seq_id);
				productvo.setBanner_title(banner_title);
				productvo.setProduct_name(product_name);
				productvo.setProduct_amonut(product_amount);
				productvo.setDelivery_fee(delivery_fee);
				productvo.setCompany_name(company_name);
				productvo.setCompany_phone(company_phone);
				productvo.setCompany_yn(company_yn);
				productvo.setFile_img(file_img, uploadPath, productvo.getFile_img());
				productvo.setDetail_img(detail_img, uploadPath, productvo.getDetail_img());
	
				productservice.updatefashion(productvo);
				
				returnUrl = "/accessorylist";
			}
		}
		return returnUrl;
	}
}
