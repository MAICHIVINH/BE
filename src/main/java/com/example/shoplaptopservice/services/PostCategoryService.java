package com.example.shoplaptopservice.services;

import com.example.shoplaptopservice.entities.PostCategories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostCategoryService {

    List<PostCategories> getAllPostCategory();

    Page<PostCategories> getPostCategoryPaging(Pageable pageable);

    Optional<PostCategories> getPostCategoryById(Integer id);

    PostCategories createPostCategory(PostCategories postCategory);

    PostCategories updatePostCategory(Integer id, PostCategories postCategory);

    void deletePostCategory(Integer id);

    List<PostCategories> searchPostCategoryByPostCategoryName(String keyword);

    List<PostCategories> getPostCategoryByStatusTrue();
}


