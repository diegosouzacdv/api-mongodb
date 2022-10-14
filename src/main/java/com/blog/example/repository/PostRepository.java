package com.blog.example.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.blog.example.models.Post;

public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{"
			+ "$and: [ { 'date': { $gte: ?0 } }, { 'date': { $lte: ?1 } }  ]"
			+ "}")
	public List<Post> getPostByDate(OffsetDateTime firstDate, OffsetDateTime lastDate);

}
