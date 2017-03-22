package softuni.contracts;

import softuni.models.Article;
import softuni.models.User;

import java.util.List;

/**
 * Created by Galin on 28.2.2017 г..
 */
public interface ArticleRepository {
    void create(Article article);

    List<Article> findAll();

    Article findById(long id);
}
