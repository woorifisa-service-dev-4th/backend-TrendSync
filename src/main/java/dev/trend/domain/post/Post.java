package dev.trend.domain.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
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

}
