package com.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.service.MemberService;
import com.main.vo.MemberVo;



@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
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
			@RequestParam("user_phone") String user_phone,
			@RequestParam("user_ip") String user_ip) {
		
		boolean checkResult = memberservice.signupCheck(user_id);
		
		boolean result;
		
		if(checkResult) {
			MemberVo membervo = new MemberVo();
			try { 
				membervo.setUser_Id(user_id);
				membervo.setUser_Pw(user_pw);
				membervo.setUser_Phone(user_phone);
				membervo.setUser_Ip(user_ip);
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
	
	@RequestMapping("/login")
	public @ResponseBody String login(
			@RequestParam("user_id") String user_id,
			@RequestParam("user_pw") String user_pw,
			@RequestParam("user_phone") String user_phone,
			@RequestParam("user_ip") String user_ip,
			HttpServletRequest request) {
		
		String login;
		MemberVo membervo = new MemberVo();
		
		membervo.setUser_Id(user_id);
		membervo.setUser_Pw(user_pw);
		membervo.setUser_Phone(user_phone);
		membervo.setUser_Ip(user_ip);

		MemberVo result = memberservice.login(membervo);
		
		request.getSession().setAttribute("memberVo", result);
		login = "redirect:/index";
		
		return "";
	}
	
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public @ResponseBody boolean loginCheck(
			@RequestParam("userid") String userid,
			@RequestParam("userpw") String userpw) {
		
		MemberVo membervo = new MemberVo();
		membervo.setUser_Id(userid);
		membervo.setUser_Pw(userpw);
		
		boolean check = memberservice.loginCheck(membervo);
		
		return check;
	}
}
