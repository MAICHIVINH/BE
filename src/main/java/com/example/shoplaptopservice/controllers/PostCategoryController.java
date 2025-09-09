package com.example.shoplaptopservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.shoplaptopservice.entities.PostCategories;
import com.example.shoplaptopservice.services.PostCategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postCategories")
public class PostCategoryController {
    @Autowired
    private PostCategoryService postCategoryService;

    @GetMapping("/all")
    public List<PostCategories> getAllPostCategory() {
        return postCategoryService.getAllPostCategory();
    }

    @GetMapping("/page")
    public Page<PostCategories> getPostCategoryPaging(@RequestParam int page, @RequestParam int size) {
        return postCategoryService.getPostCategoryPaging(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Optional<PostCategories> getPostCategoryById(@PathVariable Integer id) {
        return postCategoryService.getPostCategoryById(id);
    }

    @PostMapping("/add")
    public String createPostCategory(@RequestBody PostCategories postCategory) {
        postCategoryService.createPostCategory(postCategory);
        return "PostCategory created successfully!";
    }

    @PutMapping("/update/{id}")
    public String updatePostCategory(@PathVariable Integer id, @RequestBody PostCategories postCategory) {
        postCategoryService.updatePostCategory(id, postCategory);
        return "PostCategory updated successfully!";
    }

    @DeleteMapping("/delete/{id}")
    public String deletePostCategory(@PathVariable Integer id) {
        postCategoryService.deletePostCategory(id);
        return "PostCategory deleted successfully!";
    }
    
    @GetMapping("/search")
    public List<PostCategories> searchPostCategoryByPostCategoryName(@RequestParam String keyword) {
        return postCategoryService.searchPostCategoryByPostCategoryName(keyword);
    }

    @GetMapping("/active")
    public List<PostCategories> getActivePostCategory() {
        return postCategoryService.getPostCategoryByStatusTrue();
    }
}
