package com.yullmaster.memo.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
// view 를 위한 Controller
public class UserController {
	
	@GetMapping("/signup_view")
	public String signupView() {
		return "user/signUp";
	}
	
	@GetMapping("/signin_view")
	public String signinView() {
		return "user/signIn";
	}
	
	@GetMapping("/sign_out")
	public String signOut(HttpServletRequest request) { // 로그아웃은 세션에 저장된 정보를 지우면 된다
		
		HttpSession session = request.getSession();
		
		// 세션에 회원 정보 제거
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		return "redirect:/user/signin_view";
	}
}