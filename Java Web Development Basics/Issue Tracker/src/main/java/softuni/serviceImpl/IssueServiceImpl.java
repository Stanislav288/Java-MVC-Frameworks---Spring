package softuni.serviceImpl;

import softuni.entities.Issue;
import softuni.entities.User;
import softuni.enums.Priority;
import softuni.enums.Status;
import softuni.models.bindingModels.IssueBindingModel;
import softuni.models.bindingModels.IssueEditBindingModel;
import softuni.models.viewModels.IssueEditViewModel;
import softuni.models.viewModels.IssueViewModel;
import softuni.repositories.IssueRepository;
import softuni.repositories.UserRepository;
import softuni.services.IssueService;
import softuni.utils.parser.interfaces.ModelParser;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Galin on 3.3.2017 г..
 */

//@Local(IssueService.class)
@Stateless
public class IssueServiceImpl implements IssueService{

    @Inject
    private IssueRepository issueRepository;

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelParser modelParser;

    @Override
    public List<IssueViewModel> findAllIssues() {
        List<Issue> issues=this.issueRepository.findAllIssues();
        List<IssueViewModel> issueViewModels=new ArrayList<>();
        for (Issue issue:issues){
            IssueViewModel issueViewModel=this.modelParser.convert(issue,IssueViewModel.class);
            issueViewModel.setPriority(issue.getPriority().toString());
            issueViewModel.setStatus(issue.getStatus().toString());
            issueViewModels.add(issueViewModel);
        }

        return issueViewModels;
    }

    @Override
    public void create(IssueBindingModel issueBindingModel, String username) {
        Issue issue=this.modelParser.convert(issueBindingModel,Issue.class);
        issue.setPriority(Priority.valueOf(issueBindingModel.getPriority().toUpperCase()));
        issue.setStatus(Status.valueOf(issueBindingModel.getStatus().toUpperCase()));
        issue.setCreationDate(new Date());
        User user=this.userRepository.findByUsername(username);
        issue.setAuthor(user);
        this.issueRepository.create(issue);
    }

    @Override
    public void update(IssueEditBindingModel issueEditBindingModel) {
        Issue issue=this.modelParser.convert(issueEditBindingModel,Issue.class);
        issue.setPriority(Priority.valueOf(issueEditBindingModel.getPriority().toUpperCase()));
        issue.setStatus(Status.valueOf(issueEditBindingModel.getStatus().toUpperCase()));
        this.issueRepository.update(issue);
    }

    @Override
    public IssueEditViewModel getIssueById(long id) {
        Issue issue=this.issueRepository.findById(id);
        IssueEditViewModel issueEditViewModel=this.modelParser.convert(issue,IssueEditViewModel.class);
        issueEditViewModel.setPriority(issue.getPriority().toString());
        issueEditViewModel.setStatus(issue.getStatus().toString());
        return issueEditViewModel;
    }
}
