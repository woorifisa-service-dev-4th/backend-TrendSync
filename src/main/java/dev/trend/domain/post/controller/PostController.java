package dev.trend.domain.post.controller;

import dev.trend.domain.post.entity.Post;
import dev.trend.domain.post.repository.PostRepository;
import dev.trend.domain.post.service.PostService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dev.trend.domain.post.service.PostServiceImpl;

public class PostController {

    private final Scanner scanner;

    PostRepository postRepository = new PostRepository();
    PostService postService = new PostServiceImpl(postRepository);

    public PostController( Scanner scanner) {
        this.scanner = scanner;
    }

    public void showPostMenu() {
        while (true) {
            System.out.println("\n📢 정보 공유 섹션입니다.");
            System.out.println("1. 게시글 등록");
            System.out.println("2. 게시글 목록 확인");
            System.out.println("3. 뒤로 가기");
            System.out.print("입력: ");
            int select = scanner.nextInt();
            scanner.nextLine();

            switch (select) {
                case 1:
                    createPost();
                    break;
                case 2:
                    showPostList();
                    break;
                case 3:
                    System.out.println("🔙 이전 화면으로 돌아갑니다.");
                    return;
                default:
                    System.out.println("🚨 올바른 번호를 입력하세요!");
            }
        }
    }

    private void createPost() {
        System.out.println("\n📌 게시글 등록하기");
        System.out.print("게시글 제목: ");
        String title = scanner.nextLine();
        System.out.print("게시글 내용: ");
        String content = scanner.nextLine();
        LocalDateTime publishDate = LocalDateTime.now();

        Long newPostId = postService.createPost(title, content, 1L, publishDate);
        System.out.println("✅ 게시글 등록이 완료되었습니다. 게시글 번호: " + newPostId);
    }

    private void showPostList() {
        List<Post> posts = postService.getAllPosts();
        if (posts.isEmpty()) {
            System.out.println("📭 게시글이 없습니다.");
            return;
        }

        for (Post post : posts) {
            System.out.println("------------------------------------------------");
            System.out.println("🆔 PostID: " + post.getPostId());
            System.out.println("📌 Title: " + post.getTitle());
            System.out.println("📝 Content: " + post.getContent());
        }
        System.out.println("\n1. 수정  2. 삭제  3. 뒤로가기");
        System.out.print("입력: ");
        int input = scanner.nextInt();
        scanner.nextLine(); // 버퍼 클리어
        switch (input) {
            case 1:
                updatePost(postService, scanner);
                break;
            case 2:
                deletePost(postService, scanner);
                break;
            case 3:
                System.out.println("🔙 이전 화면으로 돌아갑니다.");
                return;
            default:
                System.out.println("🚨 올바른 번호를 입력하세요!");
        }
    }

    // ✅ 게시글 수정 기능 (메서드 분리)
    private static void updatePost(PostService postService, Scanner scanner) {
        System.out.print("\n✏ 수정할 게시글 ID 입력: ");
        Long updatePostID = scanner.nextLong();
        scanner.nextLine(); // 버퍼 클리어

        Post findTargetPost = postService.getPostById(updatePostID);
        if (findTargetPost==null) {
            System.out.println("🚨 해당 게시글을 찾을 수 없습니다.");
            return;
        }

        Post post = findTargetPost;
        System.out.println("\n🔄 기존 제목: " + post.getTitle());
        System.out.println("🔄 기존 내용: " + post.getContent());

        System.out.print("📌 새 제목 (수정하지 않으려면 Enter): ");
        String updateTitle = scanner.nextLine();
        if (updateTitle.isEmpty()) updateTitle = post.getTitle();

        System.out.print("📝 새 내용 (수정하지 않으려면 Enter): ");
        String updateContent = scanner.nextLine();
        if (updateContent.isEmpty()) updateContent = post.getContent();

        LocalDateTime updatePublishDate = LocalDateTime.now();
        postService.updatePost(updatePostID, updateTitle, updateContent, updatePublishDate);

        System.out.println("✅ 게시글이 성공적으로 수정되었습니다.");
    }

    // ✅ 게시글 삭제 기능 (메서드 분리)
    private static void deletePost(PostService postService, Scanner scanner) {
        System.out.print("\n🗑 삭제할 게시글 ID 입력: ");
        Long deletePostID = scanner.nextLong();
        scanner.nextLine(); // 버퍼 클리어
        postService.deletePost(deletePostID);
        System.out.println("✅ 게시글이 삭제되었습니다.");
    }
}