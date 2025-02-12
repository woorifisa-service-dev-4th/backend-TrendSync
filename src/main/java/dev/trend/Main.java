package dev.trend;

public class Main {
    public static void main(String[] args) {


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