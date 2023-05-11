package alatoo.kg.springmid.controllers;

import alatoo.kg.springmid.moduels.Book;
import alatoo.kg.springmid.moduels.Borrower;
import alatoo.kg.springmid.services.BookService;
import alatoo.kg.springmid.services.BorrowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class APIContr {
    private final BookService bookService;
    @PatchMapping("/api/v1/book/{bookId}")
    public ResponseEntity<?> updatePatchById(@PathVariable("bookId") long id, @RequestBody Book book) {
        bookService.patchBookById(id,book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/v1/book")
    public List<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/api/v1/book/{bookId}")
    public Book getBookById(@PathVariable("bookId") long id) {
        return bookService.findById(id);
    }

    @PostMapping("/api/v1/book")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Location","/api/v1/book/" + savedBook.getId());
        return new ResponseEntity<>(responseHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/book/{bookId}")
    public ResponseEntity<?> updateBook(@PathVariable("bookId") long id, @RequestBody Book book) {
        bookService.updateBookById(id,book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/api/v1/book/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable("bookId") long id) {
        bookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private final BorrowerService borrowerService;
    @PatchMapping("/api/v1/borrowrr/{borrId}")
    public ResponseEntity<?> updatePatchById(@PathVariable("borrId") long id, @RequestBody Borrower borrower) {
        borrowerService.patchBorrowerById(id,borrower);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/v1/borrower")
    public List<Borrower> allBorrowers() {
        return borrowerService.findAll();
    }

    @GetMapping("/api/v1/borrower/{borrowerId}")
    public Borrower getBorrowerById(@PathVariable("borrowerId") long id) {
        return borrowerService.findById(id);
    }

    @PostMapping("/api/v1/borrower")
    public ResponseEntity<?> createBorr(@RequestBody Borrower borrower) {
        Borrower savedBorrower = borrowerService.saveBorrower(borrower);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Location","/api/v1/borrower/" + savedBorrower.getId());
        return new ResponseEntity<>(responseHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/borrower/{borrowerId}")
    public ResponseEntity<?> updateBorrower(@PathVariable("borrowerId") long id, @RequestBody Borrower borrower) {
        borrowerService.updateBorrowerById(id,borrower);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/api/v1/borrower/{borrowerId}")
    public ResponseEntity<?> deleteBorrower(@PathVariable("borrowerId") long id) {
        borrowerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
