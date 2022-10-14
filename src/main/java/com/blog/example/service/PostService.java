package com.blog.example.service;

import java.time.OffsetDateTime;
import java.util.List;

import com.blog.example.models.Post;

public interface PostService {
	
	public List<Post> findAllPosts();
	
	public Post postById(String id);
	
	public Post create(Post post);
	
	public List<Post> getPostByDate(OffsetDateTime firstDate, OffsetDateTime lastDate);
	

}
