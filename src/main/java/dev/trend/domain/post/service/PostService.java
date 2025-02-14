package dev.trend.domain.post.service;

import dev.trend.domain.post.entity.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostService {
    Long createPost(String title, String content, Long memberId, LocalDateTime publishDate);
    Long updatePost(Long postId, String title, String content, LocalDateTime publishDate);
    void deletePost(Long postId);
    Post getPostById(Long postId);
    List<Post> getAllPosts();
}
