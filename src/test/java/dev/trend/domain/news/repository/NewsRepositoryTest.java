package dev.trend.domain.news.repository;

import dev.trend.domain.news.entity.News;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NewsRepositoryTest {


    private final Map<Long, News> news = new LinkedHashMap<>();

    @BeforeEach
    void setup() {
        news.put(1L, new News(1L, "Java 21 출시", "Java 21이 출시되며 새로운 패턴 매칭과 성능 최적화 기능이 추가되었습니다.", "박지성"));
        news.put(2L, new News(2L, "Spring Boot 3.2 발표", "Spring Boot 3.2가 발표되며 GraalVM 네이티브 이미지 지원이 개선되었습니다.", "손흥민"));
        news.put(3L, new News(3L, "OpenAI GPT-4.5 공개 예정", "OpenAI가 곧 GPT-4.5 모델을 공개할 것으로 예상되며, 더욱 강력한 AI 모델이 될 것입니다.", "이강인"));
        news.put(4L, new News(4L, "Google Bard 업데이트", "Google Bard AI가 새로운 기능을 추가하며 코드 생성과 번역 성능이 향상되었습니다.", "정우영"));
        news.put(5L, new News(5L, "Apple M3 칩 발표", "Apple이 M3 칩을 공식 발표하며 MacBook과 iMac 성능이 대폭 향상되었습니다.", "김민재"));
        news.put(6L, new News(6L, "Meta, AI 음성 합성 기술 공개", "Meta가 새로운 AI 음성 합성 모델을 발표하며, 자연스러운 목소리 생성이 가능해졌습니다.", "황희찬"));
        news.put(7L, new News(7L, "Samsung, 갤럭시 S24 시리즈 공개", "삼성이 새로운 갤럭시 S24 시리즈를 공개하며 AI 카메라 기술을 도입했습니다.", "이동국"));
        news.put(8L, new News(8L, "Microsoft, Copilot AI 정식 출시", "Microsoft가 Copilot AI를 Windows 및 Office 제품군에 공식 도입했습니다.", "박주영"));
        news.put(9L, new News(9L, "NVIDIA, RTX 5090 개발 중", "NVIDIA가 차세대 그래픽 카드 RTX 5090을 개발 중이며, AI 연산 성능이 대폭 향상될 예정입니다.", "차범근"));
        news.put(10L, new News(10L, "Tesla, 완전 자율주행 베타 테스트 확대", "Tesla가 완전 자율주행(FSD) 베타 프로그램을 글로벌 시장으로 확대할 계획입니다.", "안정환"));;

    }

    @Test
    @DisplayName("전체 뉴스가 조회 된다")
    void findAllNews() {
        NewsRepository repository = new NewsRepository();
        List<News> allNews = repository.findAllNews();

        assertNotNull(allNews, "뉴스 맵은 null이어서는 안 됩니다.");
        assertEquals(10, allNews.size(), "뉴스의 총 개수는 10이어야 합니다.");
        assertTrue(allNews.containsKey(1L), "1번 뉴스가 포함되어 있어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(longs = {1L,2L,3L,4L,5L,6L,7L,8L,9L,10L})
    @DisplayName("유효한 id로 뉴스 조회 시, 뉴스 내용이 반환된다")
    void getNewsById_ValidId(Long newsId) {
        NewsRepository repository = new NewsRepository();
        String content = repository.getNewsById(newsId);

        // 반환된 뉴스 내용에 예상하는 제목이 포함되어 있는지 검증
        assertNotNull(content, "뉴스 내용은 null이어서는 안 됩니다.");
        assertTrue(content.contains("Java 21 출시"), "뉴스 내용에 'Java 21 출시'가 포함되어야 합니다.");
    }
}