### Trend Sync

최신 IT 소식을 크롤링하여 보여주는 웹서비스 입니다.

## 📂 프로젝트 폴더 구조

    dev.trend
    ├── controller          # 📌 사용자의 입력을 처리하는 컨트롤러
    │   ├── NewsController.java    
    │   ├── PostController.java     
    │
    ├── domain              # 📌 도메인
    │   ├── member         
    │   │   ├── Category.java
    │   │   ├── Member.java
    │   ├── news            
    │   │   ├── News.java
    │   ├── post            
    │   │   ├── Post.java
    │
    ├── repository          # 📌 데이터 저장 및 조회 (DB 역할)
    │   ├── MemberRepository.java
    │   ├── NewsRepository.java
    │   ├── PostRepository.java
    │
    ├── service             # 📌 비즈니스 로직 (데이터 가공 및 연산)
    │   ├── postService     
    │   │   ├── PostService.java
    │   │   ├── PostServiceImpl.java
    │   ├── MemberService.java
    │   ├── NewsService.java
    │
    ├── Main.java         

