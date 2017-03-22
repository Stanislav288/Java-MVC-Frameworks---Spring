package app.controllers;

import app.contracts.BookService;
import app.models.bindingModels.AddBookModel;
import app.services.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Galin on 18.2.2017 г..
 */

@WebServlet("/add")
public class AddBookController extends HttpServlet{

    private BookService bookService;

    public AddBookController(){
        this.bookService=new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/addbook.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddBookModel addBookModel=null;
        String add=req.getParameter("add");
        if(add!=null){
            String title=req.getParameter("title");
            String author =req.getParameter("author");
            int pages= Integer.parseInt(req.getParameter("pages"));

            addBookModel=new AddBookModel(title,author,pages);
            this.bookService.saveBook(addBookModel);

            resp.sendRedirect("/");
        }else {
            resp.sendRedirect("/add");
        }
    }
}
