package app.services;

import app.contracts.BookRepository;
import app.contracts.BookService;
import app.entities.Book;
import app.models.bindingModels.AddBookModel;
import app.models.viewModels.ViewBookModel;
import app.repository.BookRepositoryImpl;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    public BookServiceImpl() {
        this.bookRepository = BookRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void saveBook(AddBookModel addBookModel) {
        Book book = modelMapper.map(addBookModel, Book.class);

        bookRepository.saveBook(book);
    }

    @Override
    public List<ViewBookModel> getAllBooks() {
        List<ViewBookModel> viewBookModels = new ArrayList<>();
        List<Book> books = this.bookRepository.getAllBooks();
        for (Book book : books) {
            ViewBookModel viewBookModel = this.modelMapper.map(book, ViewBookModel.class);
            viewBookModels.add(viewBookModel);
        }

        return viewBookModels;
    }

    @Override
    public ViewBookModel findBookByTitle(String title) {
        Book book = this.bookRepository.findBookByTitle(title);
        ViewBookModel viewBookModel = this.modelMapper.map(book, ViewBookModel.class);

        return viewBookModel;
    }

    @Override
    public void deleteBookByTitle(String title) {
        this.bookRepository.deleteBookByTitle(title);
    }
}
