# Trend Sync

최신 IT 소식을 모아 보여주는 웹서비스 입니다.

## ✅ 주요기능

 1. 최신 it소식 크롤링하여 사용자에게 보여줌
 2. 정보를 공유할 수 있는 커뮤니티 기능

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

