package softuni.services;

import softuni.models.bindingModels.IssueBindingModel;
import softuni.models.bindingModels.IssueEditBindingModel;
import softuni.models.viewModels.IssueEditViewModel;
import softuni.models.viewModels.IssueViewModel;

import java.util.List;

/**
 * Created by Galin on 3.3.2017 г..
 */
public interface IssueService {

    List<IssueViewModel> findAllIssues();

    void create(IssueBindingModel issueBindingModel,String username);

    void update(IssueEditBindingModel issueEditBindingModel);

    IssueEditViewModel getIssueById(long id);
}
