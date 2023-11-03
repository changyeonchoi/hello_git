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
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
	
	@RequestMapping(value = "/parent", method = RequestMethod.GET)
	public String parent() {
		return "parent";
	}
	@RequestMapping(value = "/chlid", method = RequestMethod.GET)
	public String chlid() {
		return "chlid";
	}
	@RequestMapping(value = "/left", method = RequestMethod.GET)
	public String left() {
		return "left";
	}
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "header";
	}
}
