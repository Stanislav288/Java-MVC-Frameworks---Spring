package softuni.filter;



import softuni.enums.Role;
import softuni.models.bindingModels.IssueEditBindingModel;
import softuni.models.bindingModels.LoggedUserModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/issues/edit/*", "/issues/delete/*"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession();
        LoggedUserModel loggedUserModel = (LoggedUserModel) session.getAttribute("user");
        if(loggedUserModel == null){
            ((HttpServletResponse)servletResponse).sendRedirect("/login");
            return;
        }

        if(loggedUserModel.getRole() != Role.ADMIN){
            String[] urlParams=((HttpServletRequest)servletRequest).getRequestURI().split("/");
            long issueId = Long.parseLong(urlParams[urlParams.length-1]);
            IssueEditBindingModel issueEditBindingModel = loggedUserModel.getIssues().stream().filter(i -> i.getId() == issueId).findFirst().orElse(null);
            if(issueEditBindingModel == null){
                ((HttpServletResponse)servletResponse).sendRedirect("/login");
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
