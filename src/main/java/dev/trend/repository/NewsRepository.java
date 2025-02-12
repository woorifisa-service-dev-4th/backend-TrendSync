package dev.trend.repository;
import dev.trend.domain.news.News;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NewsRepository {

    private static Logger logger = LogManager.getLogger(NewsRepository.class);
    private final List<News> news = new ArrayList<>();

    public NewsRepository() {

        news.add(new News(1L, "Java 21 출시", "Java 21이 출시되며 새로운 패턴 매칭과 성능 최적화 기능이 추가되었습니다.", "박지성"));
        news.add(new News(2L, "Spring Boot 3.2 발표", "Spring Boot 3.2가 발표되며 GraalVM 네이티브 이미지 지원이 개선되었습니다.", "손흥민"));
        news.add(new News(3L, "OpenAI GPT-4.5 공개 예정", "OpenAI가 곧 GPT-4.5 모델을 공개할 것으로 예상되며, 더욱 강력한 AI 모델이 될 것입니다.", "이강인"));
        news.add(new News(4L, "Google Bard 업데이트", "Google Bard AI가 새로운 기능을 추가하며 코드 생성과 번역 성능이 향상되었습니다.", "정우영"));
        news.add(new News(5L, "Apple M3 칩 발표", "Apple이 M3 칩을 공식 발표하며 MacBook과 iMac 성능이 대폭 향상되었습니다.", "김민재"));
        news.add(new News(6L, "Meta, AI 음성 합성 기술 공개", "Meta가 새로운 AI 음성 합성 모델을 발표하며, 자연스러운 목소리 생성이 가능해졌습니다.", "황희찬"));
        news.add(new News(7L, "Samsung, 갤럭시 S24 시리즈 공개", "삼성이 새로운 갤럭시 S24 시리즈를 공개하며 AI 카메라 기술을 도입했습니다.", "이동국"));
        news.add(new News(8L, "Microsoft, Copilot AI 정식 출시", "Microsoft가 Copilot AI를 Windows 및 Office 제품군에 공식 도입했습니다.", "박주영"));
        news.add(new News(9L, "NVIDIA, RTX 5090 개발 중", "NVIDIA가 차세대 그래픽 카드 RTX 5090을 개발 중이며, AI 연산 성능이 대폭 향상될 예정입니다.", "차범근"));
        news.add(new News(10L, "Tesla, 완전 자율주행 베타 테스트 확대", "Tesla가 완전 자율주행(FSD) 베타 프로그램을 글로벌 시장으로 확대할 계획입니다.", "안정환"));
    }

    // 모든 게시글 가져오기
    public List<News> getNews() {
        logger.info("모든 뉴스 조회 완료");
        return news;
    }

    // 특정 뉴스 ID로 조회
    public String getNewsById(Long newsId) {


        Optional<News> foundNews = news.stream()
                .filter(n -> n.getNewsId().equals(newsId))
                .findFirst();

        if (foundNews.isPresent()) {
            foundNews.get().increaseViews();
            logger.info("특정 뉴스 조회완료");
            return foundNews.get().showContent();
        }
        return "게시물이 존재하지 않습니다";
    }


}