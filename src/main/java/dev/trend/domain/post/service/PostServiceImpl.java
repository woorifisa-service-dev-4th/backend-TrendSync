package dev.trend.domain.post.service;

import dev.trend.domain.post.entity.Post;
import dev.trend.domain.post.repository.PostRepository;

import java.time.LocalDateTime;
import java.util.List;

public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }



    @Override
    public Long createPost(String title, String content, Long memberId, LocalDateTime publishDate) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setMemberId(memberId);
        post.setPublishDate(publishDate);
        postRepository.save(post);
        return post.getPostId();

    }

    @Override
    public Long updatePost(Long postId, String title, String content, LocalDateTime publishDate) {
        Long updatePostId = postRepository.updateById(postId, title, content);

        return updatePostId;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public Post getPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다: ID = " + postId));
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }
}
