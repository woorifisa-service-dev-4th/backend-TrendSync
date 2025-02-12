package dev.trend.domain.news;


import dev.trend.domain.member.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class News {


    /** 가져온 뉴스 id */
    private Long newsId;

    /** 뉴스 제목*/
    private String title;

    /**뉴스 내용*/
    private String content;

    /**게시글 작성자**/
    private String author;

    /**뉴스 이미지 */
    private String imgUrl;

    /**뉴스 조회수 */
    private Long views=0L;

    /**뉴스 카테고리*/
    private Category category;

    public News(Long newsId, String title, String content, String author) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.author = author;
    }


    // ✅ 조회수 증가 메서드
    public void increaseViews() {
        this.views++;
    }


    @Override
    public String toString() {
        return "\n"+newsId+"번째 소식 "+ "\n제목 : " +title + "\n조회수 : "+views;
    }


    public String showContent(){
        return "\n"+newsId+"번째 소식 "+ "\n제목 : " +title+ "\n조회수 : "+views+"\n내용 : "+content;
    }
}
