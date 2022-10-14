package com.blog.example.controller;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.example.models.Post;
import com.blog.example.service.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin("http://localhost:4200")
public class PostController {
	
	@Autowired
	private PostService postService;

	@GetMapping()
	public List<Post>  findAllPosts() {
		return this.postService.findAllPosts();
	}
	
	@GetMapping("/{id}")
	public Post postById(@PathVariable String id) {
		return this.postService.postById(id);
	}
	
	@PostMapping
	public Post create(@RequestBody Post post) {
		return this.postService.create(post);
	}
	
	@GetMapping("/range")
	public List<Post> getPostByDate(@RequestParam("firstDate") OffsetDateTime firstDate, @RequestParam("lastDate") OffsetDateTime lastDate) {
		return this.postService.getPostByDate(firstDate, lastDate);
	}
}
