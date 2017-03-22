package softuni.repositoryImpl;

import softuni.repositories.IssueRepository;
import softuni.entities.Issue;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Galin on 1.3.2017 г..
 */

//@Local(IssueRepository.class)
@Stateless
public class IssueRepositoryImpl implements IssueRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Issue issue) {
        this.entityManager.persist(issue);
    }

    @Override
    public List<Issue> findAllIssues() {
        Query query=this.entityManager.createQuery("SELECT i FROM Issue AS i");
        List<Issue> issues=query.getResultList();
        return issues;
    }

    @Override
    public void update(Issue issue) {
        this.entityManager.merge(issue);
    }

    @Override
    public Issue findById(long id) {
        return this.entityManager.find(Issue.class,id);
    }

    @Override
    public void deleteById(long id) {
        Query query=this.entityManager.createQuery("DELETE FROM Issue AS i " +
                "WHERE i.id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
