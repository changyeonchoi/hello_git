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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.main.service.BannerService;
import com.main.service.PageNavigigationService;
import com.main.service.ProductService;
import com.main.vo.BannerVo;
import com.main.vo.MemberVo;
import com.main.vo.ProductVo;

@Controller
public class BannerController {

	@Autowired
	BannerService bannerservice;
	
	@Autowired
	ProductService productservice;
	
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
    		, @RequestParam(name = "naviSize", defaultValue = "10") int naviSize
    		, @RequestParam(value = "banner_img", required=false) MultipartFile banner_img
    		, @RequestParam(value = "banner_name", required=false) String banner_name
    		, @RequestParam(value = "banner_area2", required=false) String banner_area2
    		, @RequestParam(value = "banner_yn", required=false) String banner_yn
    		, @RequestParam(value = "user_id", required=false) String user_id
	        , @RequestParam(value = "seq_id", required=false) Integer seq_id

    		) throws IOException {
		
				MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
				
			    bannervo.setUser_id(membervo.getUser_id());
			    
			    code = "banner";
			    
			    Map<String, Object> keyword = new HashMap<String, Object>();
		    	keyword.put("search", search);
		    	keyword.put("code", code);
		    	
		    	int totalCount = bannerservice.selectTotalCount(keyword);
		    	
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
    		, @RequestParam(value = "banner_img") MultipartFile banner_img
    		, @RequestParam(value = "banner_name") String banner_name
    		, @RequestParam(value = "banner_area1") String banner_area1
    		, @RequestParam(value = "banner_area2") String banner_area2
    		, @RequestParam(value = "banner_yn") String banner_yn
    		, @RequestParam(value = "land_url") String land_url
    		, @RequestParam(value = "code") String code
    		, @RequestParam(value = "seq_id", required=false) String seq_id
    		, BannerVo bannervo
    		, HttpServletRequest request) throws IOException {
		
		MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
		
		bannervo.setUser_id(membervo.getUser_id());
		bannervo.setBanner_name(banner_name);
		bannervo.setBanner_img(banner_img, uploadPath, bannervo.getBanner_img());
		bannervo.setBanner_area1(banner_area1);
		bannervo.setBanner_area2(banner_area2);
		bannervo.setLand_url(land_url);
		bannervo.setBanner_yn(banner_yn);
		bannervo.setCode(code);
		
		bannerservice.insertbanner(bannervo);
		
		return "/bannerinsert";
	}
	
	@RequestMapping(value = "/bannerdetail", method = {RequestMethod.GET, RequestMethod.POST})
	public String bannerdetail (Model model, Integer seq_id) {
		
		BannerVo bannervo = bannerservice.selectbannerdetail(seq_id);
		
		model.addAttribute("banner" , bannervo);
		
		return "/bannerdetail";
	}
	
	@RequestMapping(value = "/bannerupdate", method = {RequestMethod.GET, RequestMethod.POST})
	public String bannerupdate (Model model
    		, @RequestParam(value = "banner_img", required=false) MultipartFile banner_img
    		, @RequestParam(value = "seq_id") Integer seq_id
    		, @RequestParam(value = "banner_name") String banner_name
    		, @RequestParam(value = "banner_area1") String banner_area1
    		, @RequestParam(value = "banner_area2") String banner_area2
    		, @RequestParam(value = "banner_yn") String banner_yn
    		, @RequestParam(value = "land_url") String land_url
    		, BannerVo bannervo
    		, HttpServletRequest request) throws IOException {
		
		MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
		
		bannervo.setUser_id(membervo.getUser_id());
		bannervo.setSeq_id(seq_id);
		bannervo.setBanner_name(banner_name);
		bannervo.setBanner_img(banner_img, uploadPath, bannervo.getBanner_img());
		bannervo.setBanner_area1(banner_area1);
		bannervo.setBanner_area2(banner_area2);
		bannervo.setLand_url(land_url);
		bannervo.setBanner_yn(banner_yn);
		
		bannerservice.bannerupdate(bannervo);
		
		return "/bannerlist";
	}
	
	@RequestMapping(value = "/bannerdelete", method = {RequestMethod.GET, RequestMethod.POST})
	public String bannerdelete (Model model, Integer seq_id) {
		
		bannerservice.bannerdelete(seq_id);
		
		System.out.println("banner삭제 :" + seq_id);
		
		return "/bannerlist";
	}
	
	@RequestMapping(value = "/couponlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String couponlist (Model model
			, @RequestParam(value="code", required=false) String code 
			, @RequestParam(value = "search", defaultValue = "") String search
			, BannerVo bannervo
			, HttpSession session
			, HttpServletRequest request
			, @RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo
			, @RequestParam(name = "listSize", defaultValue = "10") int listSize
    		, @RequestParam(name = "naviSize", defaultValue = "10") int naviSize
    		, @RequestParam(value = "banner_img", required=false) MultipartFile banner_img
    		, @RequestParam(value = "banner_name", required=false) String banner_name
    		, @RequestParam(value = "banner_area2", required=false) String banner_area2
    		, @RequestParam(value = "banner_yn", required=false) String banner_yn
    		, @RequestParam(value = "user_id", required=false) String user_id
	        , @RequestParam(value = "seq_id", required=false) String seq_id

    		) throws IOException {
		
		
		MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");

	    bannervo.setUser_id(membervo.getUser_id());
	    
	    code = "coupon";

	    Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	keyword.put("code", code);
    	
    	int totalCount = bannerservice.selectTotalCount(keyword);
    	
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
    	
    	List<BannerVo> couponList = bannerservice.selectbannerList(map);

		model.addAttribute("pageAttribute", map);
		model.addAttribute("coupon", couponList);
		model.addAttribute("navigation", navigation);
		
		return "/couponlist";

	}
	
	@RequestMapping(value = "/couponenroll", method = {RequestMethod.GET, RequestMethod.POST})
	public String couponinsert(Model model,
	      @RequestParam(value = "banner_img") MultipartFile banner_img,
	      @RequestParam(value = "banner_name") String banner_name,
	      @RequestParam(value = "banner_yn") String banner_yn,
	      @RequestParam(value = "code") String code,
	      @RequestParam(value = "sale") String sale,
	      @RequestParam(value = "seq_id", required = false) Integer seq_id,
	      @RequestParam(value = "product_seq_id", required = false) Integer product_seq_id,
	      BannerVo bannervo, ProductVo productvo,
	      HttpServletRequest request, HttpSession session) throws IOException {

	    MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");

	    bannervo.setUser_id(membervo.getUser_id());
	    bannervo.setProduct_seq_id(product_seq_id);
	    bannervo.setBanner_name(banner_name);
	    bannervo.setBanner_img(banner_img, uploadPath, bannervo.getBanner_img());
	    bannervo.setBanner_yn(banner_yn);
	    bannervo.setSale(sale);
	    bannervo.setCode(code);

	    bannerservice.insertbanner(bannervo);

	    return "/couponinsert";
	}
	
	@RequestMapping(value = "/couponproductlist", method = {RequestMethod.GET, RequestMethod.POST})
	public String couponproductlist(
			Model model,HttpSession session, HttpServletRequest request,
			@RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo,
			@RequestParam(name = "listSize", defaultValue = "7") int listSize,
    		@RequestParam(name = "naviSize", defaultValue = "10") int naviSize,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value="seq_id", required=false) Integer seq_id,
			@RequestParam(value = "code", required=false) String code,
	        @RequestParam(value = "product_code", required=false) String product_code,
	        @RequestParam(value = "sale_detail", required=false) String sale_detail,
	        @RequestParam(value = "banner_name", required=false) String banner_name,
	        @RequestParam(value = "product_seq_id", required=false ,defaultValue = "0") Integer product_seq_id,
	        ProductVo productvo, BannerVo bannervo) throws IOException {
		
		System.out.println(product_code);
		
	 	// 로그인 세션 가져오기
		MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
		
	    productvo.setUser_id(membervo.getUser_id());
	    
	    code = "coupon";
	    
	    Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	keyword.put("code", code);
    	keyword.put("product_code", product_code);
    	keyword.put("product_seq_id", product_seq_id);
		
    	int totalCount = productservice.selectTotalCount(keyword);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageNo", pageNo);
    	map.put("totalCount", totalCount);
    	map.put("listSize", listSize);
    	map.put("naviSize", naviSize);
    	map.put("search", search);
    	map.put("code", code);
    	map.put("product_code", product_code);
    	map.put("product_seq_id", product_seq_id);
		
    	PageNavigation pageNavigation = new PageNavigation(map);
    	map.put("startRow", pageNavigation.getStartRow());
    	map.put("endRow", pageNavigation.getEndRow());
    	
    	PageNavigation navigation = pagenavigigationservice.makePageNavigation(map);

    	List<BannerVo> CouponProductList = bannerservice.selectCouponList(map);

    	model.addAttribute("CouponProductList", CouponProductList);
    	model.addAttribute("pageAttribute", map);
    	model.addAttribute("navigation", navigation);
    	
		return "/couponproductlist";
	}
	
	@RequestMapping(value = "/coupondetail", method = {RequestMethod.GET, RequestMethod.POST})
	public String coupondetail (Model model, Integer seq_id) {
		
		BannerVo bannervo = bannerservice.selectbannerdetail(seq_id);
		
		model.addAttribute("coupon" , bannervo);
		
		return "/coupondetail";
	}
	
	@RequestMapping(value = "/couponupdate", method = {RequestMethod.GET, RequestMethod.POST})
	public String couponupdate(Model model
	        , @RequestParam(value = "banner_img", required=false) MultipartFile banner_img
	        , @RequestParam(value = "seq_id") Integer seq_id
	        , @RequestParam(value = "banner_name") String banner_name
	        , @RequestParam(value = "product_seq_id", required=false) Integer product_seq_id
	        , @RequestParam(value = "banner_yn") String banner_yn
	        , @RequestParam(value = "sale") String sale
	        , @RequestParam(value = "product_name") String product_name
	        , BannerVo bannervo , ProductVo productvo
	        , HttpServletRequest request) throws IOException {

	    MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");

	    bannervo.setUser_id(membervo.getUser_id());
	    bannervo.setSeq_id(seq_id);
	    bannervo.setProduct_seq_id(product_seq_id);
	    bannervo.setProduct_name(product_name);
	    bannervo.setBanner_img(banner_img, uploadPath, bannervo.getBanner_img());
	    bannervo.setSale(sale);
	    bannervo.setBanner_yn(banner_yn);

	    bannerservice.couponupdate(bannervo);

	    return "/couponlist";
	}
	
	@RequestMapping(value = "/coupondelete", method = {RequestMethod.GET, RequestMethod.POST})
	public String coupondelete (Model model, Integer seq_id) {
		
		bannerservice.coupondelete(seq_id);
		
		return "/couponlist";
	}
}

