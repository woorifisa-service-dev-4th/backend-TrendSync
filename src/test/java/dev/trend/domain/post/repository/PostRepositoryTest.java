package dev.trend.domain.post.repository;

import dev.trend.domain.post.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

    private PostRepository postRepository;
    private Post post;

    @BeforeEach
    void setUp() {
        postRepository = new PostRepository();

        // 테스트용 기본 Post 생성
        post = new Post();
        post.setTitle("Test Title");
        post.setContent("Test Content");
        post.setPublishDate(LocalDateTime.now());
    }

    @Test
    @DisplayName("게시글 저장 테스트")
    void testSave() {
        // when
        Post savedPost = postRepository.save(post);

        // then
        assertNotNull(savedPost.getPostId(), "저장된 게시글의 ID는 null이 아니어야 한다.");
        Optional<Post> retrievedPost = postRepository.findById(savedPost.getPostId());
        assertTrue(retrievedPost.isPresent(), "저장된 게시글은 조회할 수 있어야 한다.");
        assertEquals(savedPost.getTitle(), retrievedPost.get().getTitle(), "제목이 동일해야 한다.");
        assertEquals(savedPost.getContent(), retrievedPost.get().getContent(), "내용이 동일해야 한다.");
    }

    @Test
    @DisplayName("게시글 조회 테스트")
    void testFindByIdExists() {
        // given
        Post savedPost = postRepository.save(post);

        // when
        Optional<Post> retrievedPost = postRepository.findById(savedPost.getPostId());

        // then
        assertTrue(retrievedPost.isPresent(), "게시글이 존재해야 한다.");
        assertEquals(savedPost.getPostId(), retrievedPost.get().getPostId(), "게시글 ID가 동일해야 한다.");
        assertEquals(savedPost.getTitle(), retrievedPost.get().getTitle(), "게시글 제목이 동일해야 한다.");
        assertEquals(savedPost.getContent(), retrievedPost.get().getContent(), "게시글 내용이 동일해야 한다.");
    }

    @Test
    @DisplayName("모든 게시글 조회 테스트")
    void testFindAll() {
        // given
        Post post1 = new Post();
        post1.setTitle("Title 1");
        post1.setContent("Content 1");
        post1.setPublishDate(LocalDateTime.now());

        Post post2 = new Post();
        post2.setTitle("Title 2");
        post2.setContent("Content 2");
        post2.setPublishDate(LocalDateTime.now());

        postRepository.save(post1);
        postRepository.save(post2);

        // when
        List<Post> allPosts = postRepository.findAll();

        // then
        assertEquals(2, allPosts.size(), "전체 게시글의 수는 2개여야 한다.");
        assertTrue(allPosts.stream().anyMatch(p -> "Title 1".equals(p.getTitle())), "Title 1 게시글이 있어야 한다.");
        assertTrue(allPosts.stream().anyMatch(p -> "Title 2".equals(p.getTitle())), "Title 2 게시글이 있어야 한다.");
    }

    @Test
    @DisplayName("게시글 삭제 테스트")
    void testDeleteById() {
        // given
        Post savedPost = postRepository.save(post);
        Long id = savedPost.getPostId();

        // when
        postRepository.deleteById(id);

        // then
        Optional<Post> retrievedPost = postRepository.findById(id);
        assertFalse(retrievedPost.isPresent(), "삭제된 게시글은 조회되지 않아야 한다.");
    }

    @Test
    @DisplayName("게시글 수정 테스트")
    void testUpdateById() {

        // given
        Post savedPost = postRepository.save(post);
        Long id = savedPost.getPostId();
        String newTitle = "Updated Title";
        String newContent = "Updated Content";
        LocalDateTime newPublishDate = LocalDateTime.now().plusDays(1);

        // when
        Long updatedPostId = postRepository.updateById(id, newTitle, newContent, newPublishDate);

        // then
        assertEquals(id, updatedPostId, "업데이트된 게시글의 ID는 기존의 ID와 동일해야 한다.");
        Optional<Post> updatedPost = postRepository.findById(id);
        assertTrue(updatedPost.isPresent(), "업데이트된 게시글은 조회되어야 한다.");
        assertEquals(newTitle, updatedPost.get().getTitle(), "게시글 제목이 업데이트되어야 한다.");
        assertEquals(newContent, updatedPost.get().getContent(), "게시글 내용이 업데이트되어야 한다.");
    }


}