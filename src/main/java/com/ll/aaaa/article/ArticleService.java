package com.ll.aaaa.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    ArticleRepository articleRepository;
    public void create(){

    }

    public List<Article> getList(){
        return articleRepository.findAll();
    }
}
