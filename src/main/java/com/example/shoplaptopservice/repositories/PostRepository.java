package com.example.shoplaptopservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoplaptopservice.entities.Posts;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Integer> {
//    List<Posts> findByUserId(int userId);
}
