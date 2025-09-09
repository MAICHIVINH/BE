package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Posts> getAllPost();
    
    Page<Posts> getPostPaging(Pageable pageable);

    Optional<Posts> getPostById(Integer postId);

//    List<Posts> getPostByUserId(Integer userId);

    Posts createPost(Posts post);

    Posts updatePost(Integer postId, Posts post);

    void deletePost(Integer postId);
}
