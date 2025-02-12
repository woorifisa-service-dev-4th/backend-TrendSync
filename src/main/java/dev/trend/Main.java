package dev.trend;

import dev.trend.domain.post.Post;
import dev.trend.repository.PostRepository;
import dev.trend.service.postService.PostService;
import dev.trend.service.postService.PostServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * 필요 객체 생성
         */
        PostRepository postRepository = new PostRepository();
        PostService postService = new PostServiceImpl(postRepository);
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("1. 게시글 등록");
            System.out.println("2. 게시글 목록 확인");
            System.out.println("3. 종료");
            System.out.print("입력 : ");
            int select = sc.nextInt();

            switch (select){
                case 1:
                    System.out.println("게시글 등록하기를 선택하셨습니다.");
                    sc.nextLine();
                    System.out.print("게시글 제목 : ");
                    String title = sc.nextLine();
                    System.out.println("게시글 내용");
                    System.out.print("입력 : ");
                    String content = sc.nextLine();
                    LocalDateTime publishDate = LocalDateTime.now();
                    Long newPostId = postService.createPost(title, content, 1L, publishDate);
                    System.out.println("게시글 등록이 완료되었습니다. 게시글 번호는 " + newPostId + "번 입니다.");
                    break;
                case 2:
                    List<Post> posts = postRepository.findAll();

                    for (Post post : posts){
                        System.out.println("PostID : " + post.getPostId());
                        System.out.println("Title : " + post.getTitle());
                        System.out.println("Content : " + post.getContent());
                        System.out.println("=============================================================");
                    }

                    System.out.println("1. 수정");
                    System.out.println("2. 삭제");
                    System.out.println("3. 뒤로가기");
                    System.out.print("입력 : ");
                    int input = sc.nextInt();
                    if (input == 1){
                        System.out.println("게시글 수정하기를 선택하셨습니다.");
                        System.out.print("수정할 게시글 아이디를 입력하세요 : ");
                        Long updatePostID = sc.nextLong();
                        sc.nextLine();

                        Optional<Post> findTargetPost = postRepository.findById(updatePostID);

                        if (findTargetPost.isPresent()) {
                            // 게시글 가져오기
                            Post post = findTargetPost.get();

                            // 기존 값 출력
                            System.out.println("기존 게시글 제목: " + post.getTitle());
                            System.out.println("기존 게시글 내용: " + post.getContent());

                            // 수정할 데이터 입력
                            System.out.print("게시글 제목 (수정하지 않으려면 Enter): ");
                            String updateTitle = sc.nextLine();
                            if (updateTitle.isEmpty()) {
                                updateTitle = post.getTitle(); // 기존 값 유지
                            }

                            System.out.print("게시글 내용 (수정하지 않으려면 Enter): ");
                            String updateContent = sc.nextLine();
                            if (updateContent.isEmpty()) {
                                updateContent = post.getContent(); // 기존 값 유지
                            }

                            // 수정 시간 갱신
                            LocalDateTime updatePublishDate = LocalDateTime.now();

                            // 저장소 업데이트
                            postRepository.updateById(updatePostID, updateTitle, updateContent, updatePublishDate);
                            System.out.println("게시글이 성공적으로 수정되었습니다.");
                        } else {
                            // 게시글을 찾지 못한 경우
                            System.out.println("해당 게시글을 찾을 수 없습니다.");
                        }

                    }
                    else if (input == 2){
                        System.out.print("삭제할 게시글 아이디를 입력하세요 : ");
                        Long deletePostID = sc.nextLong();
                        postRepository.deleteById(deletePostID);
                        System.out.println("삭제 되었습니다.");
                    }
                    else if (input == 3){
                        break;
                    }
                    break;
                case 3:
                    System.out.println("시스템이 종료되었습니다.");
                    running = false;
                    break;
            }
        }


    }
}