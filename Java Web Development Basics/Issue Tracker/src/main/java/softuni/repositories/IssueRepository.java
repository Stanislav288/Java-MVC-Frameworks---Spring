package softuni.repositories;

import softuni.entities.Issue;

import java.util.List;

/**
 * Created by Galin on 1.3.2017 г..
 */
public interface IssueRepository {

    void create(Issue issue);

    List<Issue> findAllIssues();

    void update(Issue issue);

    Issue findById(long id);

    void deleteById(long id);
}
