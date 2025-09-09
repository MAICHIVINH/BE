package com.example.shoplaptopservice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "postLikes")
public class PostLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Integer postLikeId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Posts posts;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customers;

    @Column(name = "like_date", nullable = false, updatable = false)
    private LocalDateTime postLikeDate = LocalDateTime.now();

    public Integer getPostLikeId() {
        return postLikeId;
    }

    public void setPostLikeId(Integer postLikeId) {
        this.postLikeId = postLikeId;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public LocalDateTime getPostLikeDate() {
        return postLikeDate;
    }

    public void setPostLikeDate(LocalDateTime postLikeDate) {
        this.postLikeDate = postLikeDate;
    }
}
