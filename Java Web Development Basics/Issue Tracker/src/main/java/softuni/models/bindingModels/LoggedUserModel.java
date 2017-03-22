package softuni.models.bindingModels;

import softuni.enums.Role;
import softuni.models.viewModels.IssueEditViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Galin on 3.3.2017 г..
 */
public class LoggedUserModel {

    private String username;

    private Role role;

    List<IssueEditBindingModel> issues;

    public LoggedUserModel() {
        this.setIssues(new ArrayList<>());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<IssueEditBindingModel> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueEditBindingModel> issues) {
        this.issues = issues;
    }
}
