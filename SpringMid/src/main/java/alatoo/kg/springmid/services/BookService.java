package alatoo.kg.springmid.services;

import alatoo.kg.springmid.moduels.Book;
import java.util.List;

public interface BookService {
     List<Book> findAll();

     Book saveBook(Book book);

     void updateBookById(long id, Book book);

     Book findById(long id);

     void deleteById(long id);

     void patchBookById(long id, Book book);
}
