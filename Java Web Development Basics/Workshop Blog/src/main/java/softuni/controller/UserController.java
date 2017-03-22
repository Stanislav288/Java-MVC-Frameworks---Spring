package softuni.controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.parameters.RequestParam;
import com.mvcFramework.annotations.request.GetMapping;
import com.mvcFramework.annotations.request.PostMapping;
import com.mvcFramework.models.Model;
import softuni.contracts.UserRepository;
import softuni.models.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Galin on 24.2.2017 г..
 */

@Stateless
@Controller
public class UserController {

    @Inject
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("view", "user/register.jsp");

        return "base-layout";

//        return "register";
    }

    @PostMapping("/register")
    public String signUp(
            @RequestParam("email") String email,
            @RequestParam("full-name") String fullName,
            @RequestParam("password") String password,
            @RequestParam("confirm-password") String confirmPassword,
            Model model) {
        Set<String> errors = new HashSet<>();
        if (!password.equals(confirmPassword)) {
            errors.add("Passwords do not match");
        }

        Matcher fullNameMatcher = Pattern.compile("^[A-Za-z]{5,50}$").matcher(fullName);
        if (!fullNameMatcher.find()) {
            errors.add("Full name contains invalid characters");
        }

        if (fullName.length() < 5 || fullName.length() > 50) {
            errors.add("Full name must be between 5 and 50 characters long");
        }

        if (!email.contains("@") || !email.contains(".")) {
            errors.add("Invalid email address");
        }

        if (errors.size() == 0) {
            User user = new User(fullName, email, password);
            userRepository.create(user);

            return "redirect:/login";
        }

        model.addAttribute("title", "Register");
        model.addAttribute("view", "user/register.jsp");
        model.addAttribute("errors", errors);

        return "base-layout";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute("view", "user/login.jsp");
        return "base-layout";
    }

    @PostMapping("/login")
    public String userAuthorization(
            @RequestParam("full-name") String fullName,
            @RequestParam("password") String password,
            HttpSession session) {

        User user=this.userRepository.findUserByUsernameAndPassword(fullName,password);
        if(user!=null){
            session.setAttribute("userId",user.getId());
            return "redirect:/login";
        }

        Set<String> errors = new HashSet<>();
        errors.add("User with the given fullName and password does not exist");

        return "redirect:/register";
    }

    @GetMapping("/logout")
    public String login(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String showUserProfile(Model model,HttpSession session){
        model.addAttribute("title", "profile");
        model.addAttribute("view", "user/profile.jsp");

        User user=this.userRepository.findById((Long) session.getAttribute("userId"));
        model.addAttribute("email",user.getEmail());
        model.addAttribute("fullName",user.getFullName());

        return "base-layout";
    }
}
