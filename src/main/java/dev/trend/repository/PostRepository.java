package dev.trend.repository;

import dev.trend.domain.post.Post;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.*;

public class PostRepository {

    private static Logger logger = LogManager.getLogger(NewsRepository.class);
    private final Map<Long, Post> postStore = new HashMap<>(); // 게시글 저장소 (메모리 기반)
    private Long nextId = 1L; // 게시글 ID 자동 증가

    /**
     * 게시글 저장
     */
    public Post save(Post post) {
        if (post.getPostId() == null) {
            post.setPostId(nextId++); // 새로운 게시글 ID 생성
        }
        postStore.put(post.getPostId(), post);

        logger.info("게시글 저장 완료");
        return post;
    }

    /**
     * 게시글 ID로 조회
     */
    public Optional<Post> findById(Long postId) {
        logger.info("게시글 조회 완료");
        return Optional.ofNullable(postStore.get(postId));
    }

    /**
     * 모든 게시글 조회
     */
    public List<Post> findAll() {
        logger.info("모든 게시글 조회 완료");
        return new ArrayList<>(postStore.values());
    }

    /**
     * 게시글 삭제
     */
    public void deleteById(Long postId) {
        logger.info("게시글 삭제 완료");
        postStore.remove(postId);
    }

    /**
     * 게시글 수정
     */
    public Long updateById(Long postId, String title, String content, LocalDateTime publishDate){
        Post post = postStore.get(postId);
        logger.info("게시글 수정 완료");
        if (post == null) {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다: ID = " + postId);
        }

        post.setTitle(title);              // 제목 수정
        post.setContent(content);          // 내용 수정
        post.setPublishDate(publishDate);  // 게시일 수정
        save(post);                        // 수정된 게시글 저장
        return post.getPostId();
    }
}
