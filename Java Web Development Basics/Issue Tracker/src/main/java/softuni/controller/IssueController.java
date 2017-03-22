package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.parameters.PathVariable;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import softuni.models.bindingModels.IssueBindingModel;
import softuni.models.bindingModels.IssueEditBindingModel;
import softuni.models.bindingModels.LoggedUserModel;
import softuni.models.viewModels.IssueEditViewModel;
import softuni.models.viewModels.IssueViewModel;
import softuni.services.IssueService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Galin on 3.3.2017 г..
 */

@Stateless
@Controller
public class IssueController {

    @Inject
    private IssueService issueService;

    @GetMapping("/issues")
    public String getIssuePage(Model model){
        List<IssueViewModel> issueViewModels=this.issueService.findAllIssues();
        model.addAttribute("issueViewModels",issueViewModels);

        return "/templates/issues";
    }

    @GetMapping("/issues/add")
    public String getAddIssuePage(){
        return "/templates/add-issue";
    }

    @PostMapping("/issues/add")
    public String addIssue(@ModelAttribute IssueBindingModel issueBindingModel, HttpSession session){
        LoggedUserModel loggedUserModel=(LoggedUserModel)session.getAttribute("user");
        String username=loggedUserModel.getUsername();
        this.issueService.create(issueBindingModel,username);
        return "redirect:/issues";
    }


    @GetMapping("/issues/edit/{id}")
    public String getEditIssuePage(@PathVariable("id") long id,Model model){
        IssueEditViewModel issueEditViewModel=this.issueService.getIssueById(id);
        model.addAttribute("issue",issueEditViewModel);
        return "/templates/edit-issue";
    }

    @PostMapping("/issues/edit/{id}")
    public String editIssue(@PathVariable("id") long id, @ModelAttribute IssueEditBindingModel issueEditBindingModel){
        issueEditBindingModel.setId(id);
        this.issueService.update(issueEditBindingModel);
        return "redirect:/issues";
    }
}
