package dev.trend.domain.post.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter                     // Getter 자동 생성 어노테이션
@Setter                     // Setter 자동 생성 어노테이션
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    /**게시글 Id*/
    private Long postId;

    /** 게시글 제목 */
    private String title;

    /**게시글 내용*/
    private String content;

    /**멤버 아이디*/
    private Long memberId;

    /**게시글 조회수*/
    private Long views;

    /** 게시글 생성 날짜*/
    private LocalDateTime publishDate;

    public Post(Long postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }


}
