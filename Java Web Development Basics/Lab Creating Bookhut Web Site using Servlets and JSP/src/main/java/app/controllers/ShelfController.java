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
import java.util.List;

/**
 * Created by Galin on 18.2.2017 г..
 */
@WebServlet("/shelves")
public class ShelfController extends HttpServlet {

    private BookService bookService;

    public ShelfController() {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViewBookModel> viewBookModels = this.bookService.getAllBooks();
        req.getSession().setAttribute("books", viewBookModels);
        req.getRequestDispatcher("templates/shelves.jsp").forward(req, resp);
    }
}
