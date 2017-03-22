package app.repository;

import app.contracts.BookRepository;
import app.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Galin on 16.2.2017 г..
 */
public class BookRepositoryImpl implements BookRepository {

    private static long currentId;

    private static BookRepositoryImpl bookRepository;

    private List<Book> books;

    private BookRepositoryImpl() {
        this.books = new ArrayList<>();
        currentId = 1;
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            bookRepository = new BookRepositoryImpl();
        }

        return bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        Book currentBook=findBookByTitle(book.getTitle());
        if(currentBook!=null){
            currentBook.setAuthor(book.getAuthor());
            currentBook.setPages(book.getPages());
            return;
        }

        book.setId(currentId);
        currentId++;
        this.books.add(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void deleteBookByTitle(String title) {
        Book book=this.findBookByTitle(title);

        this.books.remove(book);
    }

    @Override
    public Book findBookByTitle(String title) {
        Book book = books.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);

        return book;
    }
}
