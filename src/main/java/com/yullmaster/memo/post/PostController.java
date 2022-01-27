package com.yullmaster.memo.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@GetMapping("/list_view")
	public String listView() {
		return "post/listView";
	}
	
	@GetMapping("/create_view")
	public String createView() {
		return "post/createView";
	}
}
