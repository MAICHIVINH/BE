package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "postcategories")
public class PostCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_category_id")
    private Integer postCategoryId;

    @Column(name = "post_category_name")
    private String postCategoryName;

    @Column(name = "post_category_slug")
    private String postCategorySlug;

    @Column(name = "post_category_status")
    private Boolean postCategoryStatus;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getPostCategoryId() {
        return postCategoryId;
    }

    public void setPostCategoryId(Integer postCategoryId) {
        this.postCategoryId = postCategoryId;
    }

    public String getPostCategoryName() {
        return postCategoryName;
    }

    public void setPostCategoryName(String postCategoryName) {
        this.postCategoryName = postCategoryName;
    }

    public String getPostCategorySlug() {
        return postCategorySlug;
    }

    public void setPostCategorySlug(String postCategorySlug) {
        this.postCategorySlug = postCategorySlug;
    }

    public Boolean getPostCategoryStatus() {
        return postCategoryStatus;
    }

    public void setPostCategoryStatus(Boolean postCategoryStatus) {
        this.postCategoryStatus = postCategoryStatus;
    }
}
