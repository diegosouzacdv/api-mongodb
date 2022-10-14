package com.blog.example.service.impl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.example.models.Post;
import com.blog.example.models.User;
import com.blog.example.repository.PostRepository;
import com.blog.example.repository.UserRepository;
import com.blog.example.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Post> findAllPosts() {
		return this.postRepository.findAll();
	}

	@Override
	public Post postById(String id) {
		return this.postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post does not exist"));
	}

	@Override
	public Post create(Post post) {
		
		//User user = this.userRepository.findById(post.getId())
			//	.orElseThrow(() -> new IllegalArgumentException(String.format("There is no user with that id s%", post.getId())));
		//post.setUser(user);
		
		Date dateValue = Date.from(Instant.from(LocalDate.now().atStartOfDay(ZoneId.of("GMT"))));
		
		post.setDate(dateValue);
		 
		return this.postRepository.save(post);
	}

	@Override
	public List<Post> getPostByDate(OffsetDateTime firstDate, OffsetDateTime lastDate) {
		return postRepository.getPostByDate(firstDate, lastDate);
	}

}
