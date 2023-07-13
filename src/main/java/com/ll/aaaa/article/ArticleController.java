package com.ll.aaaa.article;

import com.ll.aaaa.user.SiteUser;
import com.ll.aaaa.user.SiteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;
    private final SiteUserService siteUserService;
    @RequestMapping("/article/list")
    public String list(Model model, @RequestParam(value = "keyword", required = false) String keyword){
        model.addAttribute("articleList", articleService.findList(keyword));
        return "article_list";
    }

    @GetMapping("/article/detail/{id}")
    public String aDetail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("article", articleService.getArticle(id));
        return "article_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/article/create")
    public String aCreate(ArticleForm articleForm, Principal principal){
        articleService.create(articleForm, siteUserService.getUser(principal.getName()));
        return "redirect:/article/list";
    }

    @GetMapping("/article/create")
    public String aShCreate(ArticleForm articleForm){
        return "article_form";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("article/modify/{id}")
    public String articleM(ArticleForm articleForm, @PathVariable("id") Integer id, Principal principal) {
        Article article = this.articleService.getArticle(id);
        if(!article.getUser().getUserName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());
        return "article_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("article/modify/{id}")
    public String articleCM(ArticleForm articleForm, @PathVariable("id") Integer id, Principal principal){
        Article article = this.articleService.getArticle(id);
        if (!article.getUser().getUserName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.articleService.modifyA(article, articleForm.getTitle(), articleForm.getContent());
        return String.format("redirect:/article/detail/%s", id);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("article/delete/{id}")
    public String articleD(@PathVariable("id") Integer id, Principal principal){
        Article article = articleService.getArticle(id);
        if (!article.getUser().getUserName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.articleService.deleteA(article);
        return "redirect:/";
    }
}
