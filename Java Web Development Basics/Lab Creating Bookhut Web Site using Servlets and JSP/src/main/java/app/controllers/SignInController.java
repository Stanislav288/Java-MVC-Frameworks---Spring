package app.controllers;

import app.contracts.UserService;
import app.models.bindingModels.LoginModel;
import app.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signin")
public class SignInController extends HttpServlet {

    private UserService userService;

    public SignInController() {
        this.userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/templates/signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginModel loginModel = null;
        String signInText = req.getParameter("signin");
        if (signInText != null) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            loginModel = new LoginModel(username, password);
        }

        if (loginModel != null) {
            HttpSession session = req.getSession();
            session.setAttribute("LOGIN_MODEL", loginModel);
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/signin");
        }
    }
}
