package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.ModelAttribute;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import softuni.models.bindingModels.LoggedUserModel;
import softuni.models.bindingModels.LoginUserModel;
import softuni.models.bindingModels.RegisterUserModel;
import softuni.services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Stateless
@Controller
public class UserController {

    @Inject
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "/templates/register";
    }

    @PostMapping("/register")
    public String signUp(
            @ModelAttribute RegisterUserModel registerUserModel,
            Model model) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<RegisterUserModel>> constraintViolations = validator.validate(registerUserModel);
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<RegisterUserModel> constraint : constraintViolations) {
            errors.add(constraint.getMessage());
        }

        if (!registerUserModel.getPassword().equals(registerUserModel.getConfirmPassword())) {
            errors.add("Password Mismatch");
        }

        RegisterUserModel foundUser = this.userService.findByUsername(registerUserModel.getUsername());
        if (foundUser != null) {
            errors.add("The user already exists");
        }

        if (errors.size() != 0) {
            model.addAttribute("errors", errors);
            return "/templates/register";
        }

        this.userService.registerUser(registerUserModel);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "/templates/login";
    }

    @PostMapping("/login")
    public String userAuthorization(
            @ModelAttribute LoginUserModel loginUserModel,
            HttpSession session,
            Model model) {
        LoggedUserModel foundUser = this.userService.findByUsernameAndPassword(loginUserModel.getUsername(), loginUserModel.getPassword());
        if (foundUser == null) {
            List<String> errors = new ArrayList<>();
            errors.add("Invalid Login Details");
            model.addAttribute("errors", errors);
            return "/templates/login";
        }

        session.setAttribute("user", foundUser);

        return "redirect:/register";
    }

    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
