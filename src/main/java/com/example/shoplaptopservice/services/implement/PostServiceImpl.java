package com.example.shoplaptopservice.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.shoplaptopservice.entities.Posts;
import com.example.shoplaptopservice.repositories.PostRepository;
import com.example.shoplaptopservice.services.PostService;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Posts> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Page<Posts> getPostPaging(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Posts> getPostById(Integer postId) {
        return postRepository.findById(postId);
    }

    @Override
    public Posts createPost(Posts post) {
        return postRepository.save(post);
    }

    @Override
    public Posts updatePost(Integer postId, Posts post) {
        Posts existing = postRepository.findById(postId).orElseThrow();
        // cập nhật từng field
        existing.setPostTitle(post.getPostTitle());
        existing.setPostContent(post.getPostContent());
        existing.setPostStatus(post.getPostStatus());
        return postRepository.save(existing);
    }

    @Override
    public void deletePost(Integer postId) {
        postRepository.deleteById(postId);
    }
}
