package dev.trend.service.postService;

import dev.trend.domain.post.Post;

import java.util.List;

public class PostServiceImpl implements PostService{
    @Override
    public Post createPost(String title, String content, Long memberId) {
        return null;
    }

    @Override
    public Post updatePost(Long postId, String title, String content) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return List.of();
    }
}
