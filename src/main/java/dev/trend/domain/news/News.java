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
    private Long views=0L;

    /**뉴스 카테고리*/
    private Category category;


    public News(Long newsId, String title, String content, String imgUrl, Long views, Category category) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.views = views;
        this.category = category;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
