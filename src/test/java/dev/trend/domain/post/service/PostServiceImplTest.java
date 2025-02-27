//package dev.trend.domain.post.service;
//
//import dev.trend.domain.post.entity.Post;
//import dev.trend.domain.post.repository.PostRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class PostServiceImplTest {
//
//    @InjectMocks
//    private PostServiceImpl postService;
//
//    @Mock
//    private PostRepository postRepositoryMock;
//
//    @Test
//    void should_CreatePost_When_ValidInput() {
//
//        // Given
//        String title = "Test Title";
//        String content = "Test Content";
//        Long memberId = 1L;
//        LocalDateTime publishDate = LocalDateTime.now();
//
//        given(postRepositoryMock.save(any(Post.class))).willAnswer(id -> {
//            Post savedPost = id.getArgument(0);
//            savedPost.setPostId(1L);
//            return savedPost;
//        });
//
//        // When
//        Long postId = postService.createPost(title,content,memberId,publishDate);
//
//        // Then
//        assertEquals(1L, postId);
//        verify(postRepositoryMock, times(1)).save(any(Post.class));
//    }
//
////    @Test
////    void should_UpdatePost_When_ValidInput() {
////        // Given (Mock 설정)
////        Long postId = 100L;
////        String updatedTitle = "Updated Title";
////        String updatedContent = "Updated Content";
////        LocalDateTime updatedPublishDate = LocalDateTime.now();
////
////        given(postRepositoryMock.updateById(postId, updatedTitle, updatedContent, updatedPublishDate))
////                .willReturn(postId); // update 성공 시 postId 반환
////
////        // When (테스트 실행)
////        Long updatedPostId = postService.updatePost(postId, updatedTitle, updatedContent, updatedPublishDate);
////
////        // Then (검증)
////        assertEquals(postId, updatedPostId);
////        verify(postRepositoryMock, times(1)).updateById(postId, updatedTitle, updatedContent, updatedPublishDate); // updateById()가 한 번 호출되었는지 검증
////
////
////
////    }
//
//    /** ✅ 게시글 삭제 테스트 */
//    @Test
//    void deletePost_ShouldDeletePostById() {
//        // Given
//        Long postId = 1L;
//        doNothing().when(postRepositoryMock).deleteById(postId);
//
//        // When
//        postService.deletePost(postId);
//
//        // Then
//        verify(postRepositoryMock, times(1)).deleteById(postId);
//    }
//
//
//    /** ✅ 게시글 ID로 조회 테스트 (게시글 없을 경우 예외) */
//    @Test
//    void getPostById_ShouldThrowException_WhenPostNotFound() {
//        // Given
//        Long postId = 2L;
//        when(postRepositoryMock.findById(postId)).thenReturn(Optional.empty());
//
//        // When & Then
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            postService.getPostById(postId);
//        });
//
//        assertEquals("게시글을 찾을 수 없습니다: ID = " + postId, exception.getMessage());
//        verify(postRepositoryMock, times(1)).findById(postId);
//    }
//
//
//}