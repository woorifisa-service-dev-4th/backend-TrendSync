### Trend Sync



## 📂 프로젝트 폴더 구조

    dev.trend
    ├── controller          # 📌 사용자의 입력을 처리하는 컨트롤러
    │   ├── NewsController.java      # 뉴스 관련 기능을 담당
    │   ├── PostController.java      # 게시글 관련 기능을 담당
    │
    ├── domain              # 📌 엔티티 클래스 (데이터 모델)
    │   ├── member          # 회원 관련 도메인
    │   │   ├── Category.java
    │   │   ├── Member.java
    │   ├── news            # 뉴스 관련 도메인
    │   │   ├── News.java
    │   ├── post            # 게시글 관련 도메인
    │   │   ├── Post.java
    │
    ├── repository          # 📌 데이터 저장 및 조회 (DB 역할)
    │   ├── MemberRepository.java
    │   ├── NewsRepository.java
    │   ├── PostRepository.java
    │
    ├── service             # 📌 비즈니스 로직 (데이터 가공 및 연산)
    │   ├── postService     # 게시글 관련 서비스
    │   │   ├── PostService.java
    │   │   ├── PostServiceImpl.java
    │   ├── MemberService.java
    │   ├── NewsService.java
    │
    ├── Main.java           # 📌 애플리케이션 실행 진입점

