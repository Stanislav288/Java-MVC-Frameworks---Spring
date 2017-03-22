package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.models.Model;
import softuni.contracts.ArticleRepository;
import softuni.dto.ViewArticle;
import softuni.models.Article;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Controller
public class HomeController {

    @Inject
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String details(Model model,HttpSession session){
        model.addAttribute("title", "Softuni Blog");
        model.addAttribute("view", "home/index.jsp");

        List<ViewArticle> articles=new ArrayList<>();
        for (Article article:articleRepository.findAll()) {
            ViewArticle viewArticle=new ViewArticle();
            viewArticle.setId(article.getId());
            viewArticle.setArticleTitle(article.getTitle());
            viewArticle.setArticleContent(article.getContent());
            viewArticle.setAuthorFullName(article.getUser().getFullName());

            articles.add(viewArticle);
        }

        session.setAttribute("articles",articles);

        return "base-layout";
    }
}
