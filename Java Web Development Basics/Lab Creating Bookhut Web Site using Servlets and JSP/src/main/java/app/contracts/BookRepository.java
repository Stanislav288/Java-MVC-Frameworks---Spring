package app.contracts;

import app.entities.Book;

import java.util.List;

/**
 * Created by Galin on 16.2.2017 г..
 */
public interface BookRepository {

    void saveBook(Book book);

    List<Book> getAllBooks();

    void deleteBookByTitle(String title);

    Book findBookByTitle(String title);
}
