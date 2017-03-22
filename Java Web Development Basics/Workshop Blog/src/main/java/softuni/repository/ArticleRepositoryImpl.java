package softuni.repository;

import softuni.contracts.ArticleRepository;
import softuni.models.Article;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Galin on 28.2.2017 г..
 */
@Local(ArticleRepository.class)
@Stateless
public class ArticleRepositoryImpl implements ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Article article) {
        this.entityManager.persist(article);
    }

    @Override
    public List<Article> findAll() {
        Query findAllArticlesQuery=this.entityManager.createQuery("SELECT a FROM Article AS a");
        List<Article> articles=findAllArticlesQuery.getResultList();

        return articles;
    }

    @Override
    public Article findById(long id) {
        Article article=entityManager.find(Article.class,id);
        return article;
    }
}
