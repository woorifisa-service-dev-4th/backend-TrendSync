package dev.trend.service.postService;

import dev.trend.domain.post.Post;

import java.util.List;

public interface PostService {
    Post createPost(String title, String content, Long memberId);
    Post updatePost(Long postId, String title, String content);
    void deletePost(Long postId);
    Post getPostById(Long postId);
    List<Post> getAllPosts();
}
