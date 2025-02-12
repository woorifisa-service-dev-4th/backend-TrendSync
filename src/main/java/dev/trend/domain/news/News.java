package dev.trend.domain.news;


import dev.trend.domain.member.Category;

public class News {


    /** 가져온 뉴스 id */
    private Long newsId;

    /** 뉴스 제목*/
    private String title;

    /**뉴스 내용*/
    private String content;

    /**뉴스 이미지 */
    private String imgUrl;

    /**뉴스 조회수 */
    private Long views;

    /**뉴스 카테고리*/
    private Category category;

}
