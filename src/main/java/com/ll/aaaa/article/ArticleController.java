package com.ll.aaaa.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    @GetMapping("/article/list")
    public String list(Model model){
        model.addAttribute("articleList", articleService.getList());
        return "article_list";
    }

    @GetMapping("/article/detail/{id}")
    public String aDetail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("article", articleService.getArticle(id));
        return "article_detail";
    }

    @PostMapping("/article/create")
    public String aCreate(ArticleForm articleForm){
        articleService.create(articleForm);
        return "redirect:/article/list";
    }

    @GetMapping("/article/create")
    public String aShCreate(ArticleForm articleForm){
        return "article_form";
    }
}
