package com.yullmaster.memo.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yullmaster.memo.post.bo.PostBO;
import com.yullmaster.memo.post.model.Post;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostBO postBO;
	
	@GetMapping("/list_view")
	public String listView(HttpServletRequest request, Model model) {
		
		// 로그인한 사용자의 글만 가져온다.
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> postlist = postBO.getPostList(userId);
		model.addAttribute("postList", postlist);
		
		return "post/listView";
	}
	
	@GetMapping("/create_view")
	public String createView() {
		return "post/createView";
	}
	
	@GetMapping("/detail_view")
	public String detailView(@RequestParam("postId") int postId
			, Model model) {
		// id 로 셀렉트
		Post post = postBO.getPost(postId);
		model.addAttribute("post", post);
		
		return "post/detailView";
	}
}
