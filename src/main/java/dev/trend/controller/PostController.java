package dev.trend.controller;

import dev.trend.repository.PostRepository;
import dev.trend.service.postService.PostService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import dev.trend.domain.post.Post;
import dev.trend.service.postService.PostServiceImpl;

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
        List<Post> posts = postRepository.findAll();
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
    }
}