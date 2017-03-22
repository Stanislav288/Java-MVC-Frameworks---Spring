package app.controllers;

import app.contracts.BookService;
import app.models.bindingModels.AddBookModel;
import app.models.viewModels.ViewBookModel;
import app.services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/shelves/edit/*")
public class EditBookController extends HttpServlet {

    private BookService bookService;

    public EditBookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] tokens = (req.getRequestURL().toString()).split("/");
        String title = URLDecoder.decode(tokens[tokens.length-1], "UTF-8");
        ViewBookModel viewBookModel = this.bookService.findBookByTitle(title);
        if (viewBookModel != null) {
            req.setAttribute("book",viewBookModel);
            req.getRequestDispatcher("/templates/editbook.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String edit = req.getParameter("edit");
        if (edit != null) {
            String title=req.getParameter("title");
            String author=req.getParameter("author");
            int pages= Integer.parseInt(req.getParameter("pages"));
            AddBookModel addBookModel=new AddBookModel(title,author,pages);
            this.bookService.saveBook(addBookModel);

            resp.sendRedirect("/shelves");
        }
    }
}
