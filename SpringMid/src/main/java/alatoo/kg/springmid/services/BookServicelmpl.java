package alatoo.kg.springmid.services;

import alatoo.kg.springmid.moduels.Book;
import alatoo.kg.springmid.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.*;

@Service
public class BookServicelmpl implements BookService{
    private final Map<Long, Book> bookData = new HashMap<>();
    private  BookRepository bookRepository;

    @Autowired
    public BookServicelmpl(BookRepository bookRepository) {
//        Book book1 = Book.builder()
//                .title("Freedom at Midnight")
//                .author("Dominique Lapierre")
//                .publisher("a")
//                .ISBN("123456789")
//                .build();
//        Book book2 = Book.builder()
//                .title("Old Man and the Sea")
//                .author("Ernest Hemingway")
//                .publisher("b")
//                .ISBN("111111111")
//                .build();
//
//        bookRepository.put(book1.getId(), book1);
//        bookRepository.put(book2.getId(), book2);
        Book book1 = new Book("Freedom at Midnight","Dominique Lapierre","a","123456789");
        bookRepository.save(book1);
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
        }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void updateBookById(long id, Book book) {
        Book existed = bookRepository.findBookById(id);
        existed.setTitle(book.getTitle());
        existed.setAuthor(book.getAuthor());
        existed.setPublisher(book.getPublisher());
        existed.setISBN(book.getISBN());
        bookRepository.save(existed);
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);

    }


    @Override
    public void patchBookById(long id, Book book) {
        Book existed = bookRepository.findBookById(id);
        if (StringUtils.hasText(book.getTitle())) {
            existed.setTitle(book.getTitle());
        }
        if (StringUtils.hasText(book.getAuthor())) {
            existed.setAuthor(book.getAuthor());
        }
        if (StringUtils.hasText(book.getPublisher())) {
            existed.setPublisher(book.getPublisher());
        }
        if (StringUtils.hasText(book.getISBN())) {
            existed.setISBN(book.getISBN());
        }
        bookRepository.save(existed);
    }
}
