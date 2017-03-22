package app.contracts;

import app.models.bindingModels.AddBookModel;
import app.models.viewModels.ViewBookModel;

import java.util.List;

public interface BookService {

    void saveBook(AddBookModel addBookModel);

    List<ViewBookModel> getAllBooks();

    ViewBookModel findBookByTitle(String title);

    void deleteBookByTitle(String title);
}
