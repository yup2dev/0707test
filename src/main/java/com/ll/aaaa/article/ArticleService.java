package com.ll.aaaa.article;

import com.ll.aaaa.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    public void create(ArticleForm articleForm, SiteUser siteUser){
        Article article = new Article();
        article.setTitle(articleForm.getTitle());
        article.setContent(articleForm.getContent());
        article.setUser(siteUser);
        articleRepository.save(article);
    }

    public void modifyA(Article article, String title, String content){
        article.setTitle(title);
        article.setContent(content);
        this.articleRepository.save(article);
    }

    public void deleteA(Article article){
        articleRepository.delete(article);
    }

    public List<Article> getList(){
        return articleRepository.findAll();
    }

    public Article getArticle(Integer id){
        Optional<Article> article = articleRepository.findById(id);
        return article.get();
    }

    public List<Article> findList(String keyword){
        if(keyword != null){
            return articleRepository.findByTitleContaining(keyword);
        } else {
            return articleRepository.findAll();
        }
    }
}
