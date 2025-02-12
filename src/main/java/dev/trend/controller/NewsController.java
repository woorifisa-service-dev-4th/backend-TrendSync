package dev.trend.controller;

import dev.trend.repository.NewsRepository;
import dev.trend.service.NewsService;

import java.util.Scanner;

public class NewsController {

    private final Scanner scanner;
    NewsRepository newsRepository = new NewsRepository();
    NewsService newsService = new NewsService(newsRepository);

    public NewsController( Scanner scanner) {
        this.scanner = scanner;
    }

    public void showNewsMenu() {
        System.out.println("\n📰 최신 IT 뉴스 목록:");
        System.out.println(newsService.getAllNews());

        while (true) {
            System.out.println("\n🔍 번호를 입력하면 해당 뉴스로 이동합니다. (0 입력 시 이전 화면으로)");
            System.out.print("👉 뉴스 ID 입력: ");
            Long id = scanner.nextLong();
            scanner.nextLine(); // 버퍼 클리어

            if (id == 0) {
                System.out.println("🔙 이전 화면으로 돌아갑니다.");
                break;
            }
            System.out.println(newsService.findNewsById(id));
        }
    }
}