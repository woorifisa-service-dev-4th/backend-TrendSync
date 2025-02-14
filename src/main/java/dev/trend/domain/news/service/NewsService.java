package dev.trend.domain.news.service;


import dev.trend.domain.news.repository.NewsRepository;

public class NewsService {


    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    public String getAllNews(){
        return newsRepository.findAllNews().toString();
    }


    public String findNewsById(Long id) {
        return newsRepository.getNewsById(id);
    }

}
