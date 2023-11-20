package com.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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



@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	@Autowired
	PageNavigigationService pagenavigigationservice;
	private MemberVo membervo;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/save")
	public String save() {
		return "save";
	}
	
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
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public @ResponseBody String login(
//			@RequestParam("user_id") String user_id,
//			@RequestParam("user_pw") String user_pw,
//			HttpServletRequest request) {
//		
//		String login;
//		MemberVo membervo = new MemberVo();
//		
//	
//		membervo.setUser_id(user_id);
//		membervo.setUser_pw(user_pw);
//		
//		MemberVo result = memberservice.login(membervo);
//		
//		System.out.println("result" + result);
//				
//		request.getSession().setAttribute("memberVo", result);
//		login = "redirect:/index";
//		
//		return "";
//	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(
	        @RequestParam("user_id") String user_id,
	        @RequestParam("user_pw") String user_pw,
	        HttpServletRequest request) {

	    MemberVo membervo = new MemberVo();    
	    membervo.setUser_id(user_id);
	    membervo.setUser_pw(user_pw);
	    
	    MemberVo result = memberservice.login(membervo);
	                    
	    request.getSession().setAttribute("memberVo", result);

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
    		@RequestParam(name = "naviSize", defaultValue = "20") int naviSize,
    		@RequestParam(value = "search", defaultValue = "") String search
    		) {
    	Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	
    	int totalCount = memberservice.selectTotalCount(keyword);
    	
    	System.out.println("totalCount" +totalCount);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageNo", pageNo);
    	map.put("totalCount", totalCount);
    	map.put("listSize", listSize);
    	map.put("naviSize", naviSize);
    	map.put("search", search);
    	System.out.println("search" + search);
    	System.out.println("map" + map);

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
	
	// 관리자현황 검색
//    @RequestMapping(value = "/adminlist", method = RequestMethod.POST)
//    public ResponseEntity<List<MemberVo>> searchMembers(@RequestParam(value = "search", required = false) String search) {
//        
//    	Map<String, Object> map = new HashMap<String, Object>();
//    	map.put("search", search);
//    	
//    	
//    	List<MemberVo> memberList = memberservice.selectMemberList(map);
//    	System.out.println("memberList" + memberList);
//    	
//        return ResponseEntity.ok(memberList);
//    }
//	   @RequestMapping(value = "/adminlist", method = RequestMethod.POST)
//	    public ResponseEntity<Object> handleAdminRequest(
//	            @RequestParam(name = "page", defaultValue = "1") int page,
//	            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize,
//	            @RequestParam(value = "search", required = false) String search) {
//
//	        if (search != null) {
//	            // POST 요청에서 검색을 수행하고 JSON 응답 반환
//	            List<MemberVo> memberList = memberservice.selectMemberList(search);
//	            return ResponseEntity.ok(memberList);
//	        } else {
//	            // POST 요청에서 페이지 로딩 처리 후 JSON 응답 반환
//	            PagingVo pagingVo = memberservice.createPagingVo(page, pageSize);
//	            List<MemberVo> memberList = memberservice.getMemberListPaging(pagingVo.getStartIndex(), pagingVo.getPageSize());
//	            int totalMembers = memberservice.getTotalMembers();
//	            
//	            Map<String, Object> responseData = new HashMap<>();
//	            responseData.put("member", memberList);
//	            responseData.put("pagingVO", pagingVo);
//	            responseData.put("totalMembers", totalMembers);
//	            System.out.println("responseData" + responseData);
//	            return ResponseEntity.ok(responseData);
//	        }
//	    }
    
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
    
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String user() {
//    	return "user";
//    }
    
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public @ResponseBody ModelAndView user(Model model, HttpServletRequest request,
    		@RequestParam(value="pageNo"		, defaultValue="1" , required=true) int pageNo,
    		@RequestParam(name = "listSize", defaultValue = "10") int listSize,
    		@RequestParam(name = "naviSize", defaultValue = "20") int naviSize,
    		@RequestParam(value = "search", defaultValue = "") String search
    		) {
    	Map<String, Object> keyword = new HashMap<String, Object>();
    	keyword.put("search", search);
    	
    	int totalCount = memberservice.selectTotalCount(keyword);
    	
    	System.out.println("totalCount" +totalCount);
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("pageNo", pageNo);
    	map.put("totalCount", totalCount);
    	map.put("listSize", listSize);
    	map.put("naviSize", naviSize);
    	map.put("search", search);
    	System.out.println("search" + search);
    	System.out.println("map" + map);

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
}

