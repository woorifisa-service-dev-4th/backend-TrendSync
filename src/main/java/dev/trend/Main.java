package dev.trend;
import dev.trend.domain.news.controller.NewsController;
import java.util.Scanner;
import dev.trend.domain.post.controller.PostController;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        NewsController newsController = new NewsController( scanner);
        PostController postController = new PostController( scanner);

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