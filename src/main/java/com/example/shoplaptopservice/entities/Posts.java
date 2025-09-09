package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_title", nullable = false)
    private String postTitle;

    @Column(name = "post_slug", nullable = false, unique = true)
    private String postSlug;

    @Column(name = "post_content", nullable = false, columnDefinition = "text")
    private String postContent;

    @Column(name = "post_thumbnail")
    private String postThumbnail;

    @ManyToOne
    @JoinColumn(name = "post_category_id", nullable = false)
    private PostCategories postCategories;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Authors authors;

    @Column(name = "post_create_date", nullable = false, updatable = false)
    private LocalDateTime postCreateDate = LocalDateTime.now();

    @Column(name = "post_update_date")
    private LocalDateTime postUpdateDate;

    @Column(name = "post_status")
    private Boolean postStatus;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public void setPostSlug(String postSlug) {
        this.postSlug = postSlug;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostThumbnail() {
        return postThumbnail;
    }

    public void setPostThumbnail(String postThumbnail) {
        this.postThumbnail = postThumbnail;
    }

    public PostCategories getPostCategories() {
        return postCategories;
    }

    public void setPostCategories(PostCategories postCategories) {
        this.postCategories = postCategories;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public LocalDateTime getPostCreateDate() {
        return postCreateDate;
    }

    public void setPostCreateDate(LocalDateTime postCreateDate) {
        this.postCreateDate = postCreateDate;
    }

    public LocalDateTime getPostUpdateDate() {
        return postUpdateDate;
    }

    public void setPostUpdateDate(LocalDateTime postUpdateDate) {
        this.postUpdateDate = postUpdateDate;
    }

    public Boolean getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(Boolean postStatus) {
        this.postStatus = postStatus;
    }
}
