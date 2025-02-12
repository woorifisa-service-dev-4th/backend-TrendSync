package dev.trend;

import dev.trend.repository.NewsRepository;
import dev.trend.service.NewsService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NewsRepository newsRepository = new NewsRepository();
        NewsService newsService = new NewsService(newsRepository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📢 Trend Sync");
            System.out.println("1. 최신 IT 소식  2. 정보 공유  3. 종료");
            System.out.print("👉 번호 선택: ");
            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    System.out.println("\n📰 최신 IT 뉴스 목록:");
                    System.out.println(newsService.getAllNews());

                    while (true) {
                        System.out.println("\n🔍 번호를 입력하면 해당 뉴스로 이동합니다. (0 입력 시 이전 화면으로)");
                        System.out.print("👉 뉴스 ID 입력: ");
                        Long id = scanner.nextLong();

                        if (id == 0) {
                            System.out.println("🔙 이전 화면으로 돌아갑니다.");
                            break; // 🔙 이전 메뉴로 돌아감
                        }

                        System.out.println(newsService.findNewsById(id));
                    }
                    break;

                case 2:
                    System.out.println("📢 정보 공유 섹션입니다.");
                    break;

                case 3:
                    System.out.println("🔚 프로그램을 종료합니다.");
                    scanner.close();
                    return; // 프로그램 완전 종료

                default:
                    System.out.println("🚨 올바른 번호를 입력하세요!");
            }
        }
    }
}