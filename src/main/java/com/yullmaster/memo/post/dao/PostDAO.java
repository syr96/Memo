package com.yullmaster.memo.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yullmaster.memo.post.model.Post;

@Repository
public interface PostDAO {
	
	public List<Post> selectPostList(@Param("userId") int userId);
	
	public Post selectPost(@Param("postId") int postId);
	
	public int deletePost(@Param("postId") int postId);
}