package dev.trend;

import dev.trend.repository.NewsRepository;
import dev.trend.service.NewsService;
import dev.trend.controller.NewsController;

import java.util.Scanner;

import dev.trend.repository.PostRepository;
import dev.trend.service.postService.PostService;
import dev.trend.service.postService.PostServiceImpl;
import dev.trend.controller.PostController;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 서비스 및 컨트롤러 초기화
        NewsRepository newsRepository = new NewsRepository();
        NewsService newsService = new NewsService(newsRepository);
        NewsController newsController = new NewsController(newsService, scanner);

        PostRepository postRepository = new PostRepository();
        PostService postService = new PostServiceImpl(postRepository);
        PostController postController = new PostController(postService, postRepository, scanner);

        while (true) {
            System.out.println("\n📢 Trend Sync");
            System.out.println("1. 최신 IT 소식  2. 정보 공유  3. 종료");
            System.out.print("👉 번호 선택: ");
            int num = scanner.nextInt();
            scanner.nextLine();

            switch (num) {
                case 1:
                    newsController.showNewsMenu();
                    break;
                case 2:
                    postController.showPostMenu();
                    break;
                case 3:
                    System.out.println("🔚 프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("🚨 올바른 번호를 입력하세요!");
            }
        }
    }
}