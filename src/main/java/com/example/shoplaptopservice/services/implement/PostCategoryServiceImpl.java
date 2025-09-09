package com.example.shoplaptopservice.services.implement;

import com.example.shoplaptopservice.entities.PostCategories;
import com.example.shoplaptopservice.repositories.PostCategoryRepository;
import com.example.shoplaptopservice.services.PostCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostCategoryServiceImpl implements PostCategoryService {
    @Autowired
    private PostCategoryRepository postCategoryRepository;

    @Override
    public List<PostCategories> getAllPostCategory() {
        return postCategoryRepository.findAll();
    }

    @Override
    public Page<PostCategories> getPostCategoryPaging(Pageable pageable) {
        return postCategoryRepository.findAll(pageable);
    }

    @Override
    public Optional<PostCategories> getPostCategoryById(Integer id) {
        return postCategoryRepository.findById(id);
    }

    @Override
    public PostCategories createPostCategory(PostCategories postCategory) {
        return postCategoryRepository.save(postCategory);
    }

    @Override
    public PostCategories updatePostCategory(Integer id, PostCategories postCategory) {
        PostCategories existing = postCategoryRepository.findById(id).orElseThrow();
        // cập nhật từng field
        existing.setPostCategoryName(postCategory.getPostCategoryName());
        existing.setPostCategorySlug(postCategory.getPostCategorySlug());
        existing.setPostCategoryStatus(postCategory.getPostCategoryStatus());
        existing.setDeleted(postCategory.getDeleted());
        return postCategoryRepository.save(existing);
    }

    @Override
    public void deletePostCategory(Integer id) {
        postCategoryRepository.deleteById(id);
    }

    @Override
    public List<PostCategories> searchPostCategoryByPostCategoryName(String keyword) {
        return postCategoryRepository.findByPostCategoryNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<PostCategories> getPostCategoryByStatusTrue() {
        return postCategoryRepository.findByPostCategoryStatusTrue();
    }
}
