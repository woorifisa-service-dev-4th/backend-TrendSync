package dev.trend.domain.post;

import java.util.Date;

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
    private Date publishDate;



    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}
