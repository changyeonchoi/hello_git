package com.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.main.service.MemberService;
import com.main.service.PageNavigigationService;
import com.main.vo.MemberVo;
import com.main.vo.OrderVo;



@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	@Autowired
	PageNavigigationService pagenavigigationservice;

	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/signupCheck")
	public @ResponseBody boolean signup(
			@RequestParam("user_id") String user_id,
			@RequestParam("user_pw") String user_pw,
			@RequestParam("user_name") String user_name,
			@RequestParam("user_phone") String user_phone
			) {
		
		boolean checkResult = memberservice.signupCheck(user_id);
		
		boolean result;
		
		if(checkResult) {
			MemberVo membervo = new MemberVo();
			try { 
				membervo.setUser_id(user_id);
				membervo.setUser_pw(user_pw);
				membervo.setUser_name(user_name);
				membervo.setUser_phone(user_phone);
				membervo.setUser_auth("미사용");
			} catch(Exception e) {
				e.printStackTrace();
			}
			memberservice.signupSuccess(membervo);
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(
	        @RequestParam("user_id") String user_id,
	        @RequestParam("user_pw") String user_pw,
	        HttpServletRequest request) {

	    MemberVo membervo = new MemberVo();    
	    membervo.setUser_id(user_id);
	    membervo.setUser_pw(user_pw);
	    
	    MemberVo result = memberservice.login(membervo);
	    
	    System.out.println(result);
	    
	    // 세션에 "memberVo" 속성을 설정
	    request.getSession().setAttribute("membervo", result);

	    // 리다이렉트할 URL을 포함한 응답 데이터
	    Map<String, Object> response = new HashMap<>();
	    
	    // MemberVo에서 user_auth 값을 가져와서 응답 데이터에 추가
	    response.put("user_auth", result.getUser_auth());
	    
	    return response;
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
    public ResponseEntity<String> idCheck(@RequestParam String user_id) {
		
		MemberVo membervo = new MemberVo();
		membervo.setUser_id(user_id);
		
        boolean idExists = memberservice.idCheck(membervo);
        if (idExists) {
            return ResponseEntity.ok("exists");
        } else {
            return ResponseEntity.ok("not_exists");
        }
    }
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public @ResponseBody boolean loginCheck(
			@RequestParam("user_id") String user_id,
			@RequestParam("user_pw") String user_pw) {
		
		MemberVo membervo = new MemberVo();
		membervo.setUser_id(user_id);
		membervo.setUser_pw(user_pw);
		
		boolean check = memberservice.loginCheck(membervo);
	
		return check;
	}
	
	@RequestMapping(value = "/userstatus", method = RequestMethod.GET)
	public String userstatus() {
		return "userstatus";
	}
	
	@RequestMapping(value = "/userstatus", method = RequestMethod.POST)
	public @ResponseBody String loginuser(String user_id, Model model) {
		
		MemberVo membervo = memberservice.selectMemberdetail(user_id);
		
		model.addAttribute("membervo", membervo);
		
		return "userstatus";
	}
	
	@RequestMapping(value = "/newuserstatus", method = RequestMethod.GET)
		public String newuserstatus() {
			return "newuserstatus";
		}
	
    @RequestMapping(value = "/adminlist", method = RequestMethod.GET)
    public @ResponseBody ModelAndView admin(Model model, HttpServletRequest request,
    		@RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo,
    		@RequestParam(name = "listSize", defaultValue = "10") int listSize,
    		@RequestParam(name = "naviSize", defaultValue = "10") int naviSize,
    		@RequestParam(value = "search", defaultValue = "") String search
    		) {
    	Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	
    	int totalCount = memberservice.selectTotalCount(keyword);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageNo", pageNo);
    	map.put("totalCount", totalCount);
    	map.put("listSize", listSize);
    	map.put("naviSize", naviSize);
    	map.put("search", search);

    	// 계산된 startRow와 endRow를 Map에 추가
        PageNavigation pageNavigation = new PageNavigation(map);
        map.put("startRow", pageNavigation.getStartRow());
        map.put("endRow", pageNavigation.getEndRow());
    	
    	model.addAttribute("pageAttribute", map);
    	
    	PageNavigation navigation = pagenavigigationservice.makePageNavigation(map);
    	
    	model.addAttribute("navigation", navigation);
    	
    	List<MemberVo> memberList = memberservice.selectMemberList(map);
    	
    	model.addAttribute("member", memberList);
    	
    	ModelAndView mv = new ModelAndView("admin");
    	
    	return mv;
    }
	
    // 관리자현황 상세보기
    @RequestMapping(value = "/adminupdate", method = RequestMethod.GET)
    public String update(String user_id, String user_name,Model model) {
    	
    	MemberVo membervo = memberservice.selectMemberdetail(user_id);
    	
    	model.addAttribute("membervo", membervo);
    	
    	return "/adminupdate";
    }
    
    // 관리자삭제
    @RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
    public ResponseEntity<String> deleteUser(@RequestParam("user_id") String user_id) {
        // 사용자 삭제를 수행하는 서비스 메서드 호출
        int deletedRows = memberservice.deleteMemberId(user_id);
        
        if (deletedRows > 0) {
            // 삭제 성공 시 응답
            return ResponseEntity.ok("사용자가 삭제되었습니다.");
        } else {
            // 삭제 실패 시 응답
            return ResponseEntity.status(500).body("사용자 삭제에 실패하였습니다.");
        }
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<Object> updateUser(@RequestBody MemberVo membervo) {

        try {
             memberservice.updateUser(membervo); // 실제로는 업데이트 로직을 수행해야 합니다.
            // 성공적으로 수정되었을 경우
            return ResponseEntity.ok().body("{\"status\":\"success\"}");
        } catch (Exception e) {
            // 수정에 실패한 경우
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"error\",\"message\":\"" + e.getMessage() + "\"}");
        }
    }
    
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public @ResponseBody ModelAndView user(Model model, HttpServletRequest request,
    		@RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo,
    		@RequestParam(name = "listSize", defaultValue = "10") int listSize,
    		@RequestParam(name = "naviSize", defaultValue = "10") int naviSize,
    		@RequestParam(value = "search", defaultValue = "") String search
    		) {
    	Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	
    	int totalCount = memberservice.selectTotalCountUser(keyword);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageNo", pageNo);
    	map.put("totalCount", totalCount);
    	map.put("listSize", listSize);
    	map.put("naviSize", naviSize);
    	map.put("search", search);

    	// 계산된 startRow와 endRow를 Map에 추가
        PageNavigation pageNavigation = new PageNavigation(map);
        map.put("startRow", pageNavigation.getStartRow());
        map.put("endRow", pageNavigation.getEndRow());
    	
    	model.addAttribute("pageAttribute", map);
    	
    	PageNavigation navigation = pagenavigigationservice.makePageNavigation(map);
    	
    	model.addAttribute("navigation", navigation);
    	
    	List<MemberVo> memberList = memberservice.selectUserList(map);
    	
    	model.addAttribute("member", memberList);
    	
    	ModelAndView mv = new ModelAndView("user");
    	
    	return mv;
    }
    
    // 사용자현황 상세보기
    @RequestMapping(value = "/userupdate", method = RequestMethod.GET)
    public String userupdate(String user_id, String user_name,Model model) {
    	
    	MemberVo membervo = memberservice.selectUserdetail(user_id);
    	
    	model.addAttribute("membervo", membervo);
    	
    	return "/userupdate";
    }
    
    // 사용자삭제
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ResponseEntity<String> userdelete(@RequestParam("user_id") String user_id) {
        // 사용자 삭제를 수행하는 서비스 메서드 호출
        int deletedRows = memberservice.deleteUserId(user_id);
        
        if (deletedRows > 0) {
            // 삭제 성공 시 응답
            return ResponseEntity.ok("사용자가 삭제되었습니다.");
        } else {
            // 삭제 실패 시 응답
            return ResponseEntity.status(500).body("사용자 삭제에 실패하였습니다.");
        }
    }
    
    @RequestMapping(value = "/userorderlist", method = RequestMethod.GET)
    public @ResponseBody ModelAndView userorderlist(Model model, HttpServletRequest request,
    		@RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo,
    		@RequestParam(name = "listSize", defaultValue = "10") int listSize,
    		@RequestParam(name = "naviSize", defaultValue = "10") int naviSize,
    		@RequestParam(value = "search", defaultValue = "") String search
    		) {
    	Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	
    	int totalCount = memberservice.ordercount(keyword);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageNo", pageNo);
    	map.put("totalCount", totalCount);
    	map.put("listSize", listSize);
    	map.put("naviSize", naviSize);
    	map.put("search", search);

    	// 계산된 startRow와 endRow를 Map에 추가
        PageNavigation pageNavigation = new PageNavigation(map);
        map.put("startRow", pageNavigation.getStartRow());
        map.put("endRow", pageNavigation.getEndRow());
    	
    	model.addAttribute("pageAttribute", map);
    	
    	PageNavigation navigation = pagenavigigationservice.makePageNavigation(map);
    	
    	model.addAttribute("navigation", navigation);
    	
    	List<MemberVo> userOrderList = memberservice.selectUserOrderList(map);
    	
    	model.addAttribute("member", userOrderList);
    	
    	ModelAndView mv = new ModelAndView("userorderlist");
    	
    	return mv;
    }
    
	@RequestMapping(value = "userorderdetail", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView mypageproduct(Model model, HttpSession session, HttpServletRequest request
			, @RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo
			, @RequestParam(name = "listSize", defaultValue = "4") int listSize
    		, @RequestParam(name = "naviSize", defaultValue = "4") int naviSize
    		, @RequestParam("user_id") String user_id
			, @RequestParam(value = "search", defaultValue = "") String search) {
		
		MemberVo membervo = (MemberVo) request.getSession().getAttribute("membervo");
		
		Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	keyword.put("user_id", membervo.getUser_id());
    	
    	// 총 갯수
    	int totalCount = memberservice.ordercount(keyword);
    	
    	model.addAttribute("totalCount", totalCount);

    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageNo", pageNo);
    	map.put("totalCount", totalCount);
    	map.put("listSize", listSize);
    	map.put("naviSize", naviSize);
    	map.put("search", search);
    	map.put("user_id", user_id);
    	
    	// 해당 pageNavigation에서 html code생성
    	PageNavigation pageNavigation = new PageNavigation(map);
    	map.put("startRow", pageNavigation.getStartRow());
    	map.put("endRow", pageNavigation.getEndRow());
    	
    	// 페이지 네비게이션 객체 생성
    	PageNavigation navigation = pagenavigigationservice.makePageNavigation(map);
    	
    	List<OrderVo> orderList = memberservice.OrderList(map);
    	
       	model.addAttribute("pageAttribute", map);
    	model.addAttribute("navigation", navigation);
    	model.addAttribute("OrderList", orderList);
    	
    	System.out.println("orderList" + orderList);
    	
    	ModelAndView mv = new ModelAndView("userorderdetail");
    	
    	return mv;
	}
}

