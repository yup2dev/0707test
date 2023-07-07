package com.ll.aaaa.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public void create(ArticleForm articleForm){
        Article article = new Article();
        article.setTitle(articleForm.getTitle());
        article.setContent(articleForm.getContent());
        articleRepository.save(article);
    }

    public List<Article> getList(){
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id){
        Optional<Article> article = articleRepository.findById(id);
        return article.get();
    }
}
