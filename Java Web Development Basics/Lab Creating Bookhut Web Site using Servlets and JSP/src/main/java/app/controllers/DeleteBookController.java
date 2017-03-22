package app.controllers;

import app.contracts.BookService;
import app.models.viewModels.ViewBookModel;
import app.services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet("/shelves/delete/*")
public class DeleteBookController extends HttpServlet {

    private BookService bookService;

    public DeleteBookController() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] tokens = (req.getRequestURL().toString()).split("/");
        String title = URLDecoder.decode(tokens[tokens.length - 1], "UTF-8");
        this.bookService.deleteBookByTitle(title);
        resp.sendRedirect("/shelves");
    }
}
