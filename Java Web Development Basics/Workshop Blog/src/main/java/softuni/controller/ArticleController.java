package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import softuni.contracts.ArticleRepository;
import softuni.contracts.UserRepository;
import softuni.dto.ViewArticle;
import softuni.models.Article;
import softuni.models.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 * Created by Galin on 28.2.2017 г..
 */
@Controller
@Stateless
public class ArticleController {

    @Inject
    private ArticleRepository articleRepository;

    @Inject
    private UserRepository userRepository;

    @GetMapping("/article/create")
    public String createArticleGet(Model model) {
        model.addAttribute("title", "Create Article");
        model.addAttribute("view", "article/create-article.jsp");
        return "base-layout";
    }

    @PostMapping("/article/create")
    public String createArticlePost(
            @RequestParam("articleTitle") String articleTitle,
            @RequestParam("content") String content,
            HttpSession session) {
        User user=userRepository.findById((Long) session.getAttribute("userId"));
        Article article = new Article();
        article.setTitle(articleTitle);
        article.setContent(content);
        article.setUser(user);

        this.articleRepository.create(article);

        return "redirect:/";
    }

    @GetMapping("/article/{id}")
    public String getArticleDetails(Model model,@PathVariable("id")String id) {
        long articleId= Long.parseLong(id);
        Article article=this.articleRepository.findById(articleId);
        ViewArticle viewArticle=new ViewArticle();
        viewArticle.setId(articleId);
        viewArticle.setArticleTitle(article.getTitle());
        viewArticle.setArticleContent(article.getContent());
        viewArticle.setAuthorFullName(article.getUser().getFullName());

        model.addAttribute("title", "Article Details");
        model.addAttribute("view", "article/details.jsp");
        model.addAttribute("article",viewArticle);

        return "base-layout";
    }
}
