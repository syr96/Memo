package com.yullmaster.memo.user;

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
}