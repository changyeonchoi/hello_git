package com.main.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.main.service.MemberService;
import com.main.vo.MemberVo;



@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	private MemberVo membervo;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(
			@RequestParam("user_id") String user_id,
			@RequestParam("user_pw") String user_pw,
			HttpServletRequest request) {
		
		String login;
		MemberVo membervo = new MemberVo();
		
	
		membervo.setUser_id(user_id);
		membervo.setUser_pw(user_pw);

		MemberVo result = memberservice.login(membervo);
		
		request.getSession().setAttribute("memberVo", result);
		login = "redirect:/index";
		
		return "";
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
	
//	@RequestMapping(value = "/userstatus", method = RequestMethod.POST)
//	public @ResponseBody String userstatus() {
//		return ;
//	}
	// 관리자현황 리스트
	@RequestMapping(value = "/adminlist", method = RequestMethod.GET)
	public @ResponseBody ModelAndView admin(@RequestParam(value = "search", required = false) String search, Model model) {
		
		List<MemberVo> memberList = memberservice.selectMemberList();
	
		model.addAttribute("member", memberList);
	
		ModelAndView mv = new ModelAndView("admin");
		return mv;
	}
	
	// 관리자현황 검색
    @RequestMapping(value = "/adminlist", method = RequestMethod.POST)
    public ResponseEntity<List<MemberVo>> searchMembers(@RequestParam(value = "search", required = false) String search) {
        List<MemberVo> memberList = memberservice.selectMemberList(search);
        return ResponseEntity.ok(memberList);
    }
    
    // 관리자현황 상세보기
    @RequestMapping(value = "/adminupdate", method = RequestMethod.GET)
    public String update(String user_id, Model model) {
    	
    	MemberVo membervo = memberservice.selectMemberdetail(user_id);
    	
    	model.addAttribute("membervo", membervo);
    	
    	System.out.println(membervo);
    	
    	return "/adminupdate";
    }
    
    // 관리자삭제
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ResponseEntity<String> deleteUser(@RequestParam("user_id") String user_id) {
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
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<Object> updateUser(@RequestBody MemberVo membervo) {
        // 받아온 사용자 정보를 가지고 업데이트 로직을 수행합니다.
        // 여기에서는 간단한 예시로 출력만 하겠습니다.
        System.out.println("Received user information: " +
                membervo.getUser_name() +
                ", " + membervo.getUser_phone() +
                ", " + membervo.getUser_pw() +
                ", " + membervo.getUser_id() +
                ", " + membervo.getUser_auth());

        try {
             memberservice.updateUser(membervo); // 실제로는 업데이트 로직을 수행해야 합니다.
            // 성공적으로 수정되었을 경우
            return ResponseEntity.ok().body("{\"status\":\"success\"}");
        } catch (Exception e) {
            // 수정에 실패한 경우
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\":\"error\",\"message\":\"" + e.getMessage() + "\"}");
        }
    }
}

