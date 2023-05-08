package alatoo.kg.springmid.controllers;

import alatoo.kg.springmid.moduels.Book;
import alatoo.kg.springmid.moduels.Borrower;
import alatoo.kg.springmid.repositories.BookRepository;
import alatoo.kg.springmid.repositories.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


//we should have controller/model/view
//Assign the class with @Controller to register the class as a Spring Bean and as a Controller in Spring MVC
@Controller
public class MainController {
    //we will call BookRepository and Generate a constructor for it
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;

    //Add @GetMapping(which is shortcut for @RequestMapping(method = RequestMethod.GET)) to map this method to http request paths
    @GetMapping({"/", "/books"})
    //so when we do an action with the books url,this method will give books by the Spring MVC
    public String showBookList(Model model) { //the model
        // runtime when spring get request to url(/books)
        model.addAttribute("books", bookRepository.findAll()); //for this model add attribute called (books) and bookRepository will give the list of books
        //findAll() is working because BookRepository extends CrudRepository which have the method (findAll)
        return "books";  //the view
        //and we should create new template (html file) called "books"
    }

    //CRUD
    //to create method add
    @GetMapping("/add")
    public String showBook (Book book, Model model) {
        model.addAttribute("books", book);
        return "add";
    }
    @PostMapping("/addBook")
    public String addBook (@Valid Book book, BindingResult result){
        if (result.hasErrors()){
            return "add";
        }
        bookRepository.save(book);
        return "redirect:/books";
    }


    //Edit and Update
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("books", book);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") Long id,@Valid Book book,
                             BindingResult result){
        if(result.hasErrors()){
            book.setId(id);
            return "update";
        }
        bookRepository.save(book);
        return "redirect:/books";
    }


    //Delete
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        if (book.getBorrower() != null) {
            borrowerRepository.deleteById(book.getId());
        }
        bookRepository.delete(book);
        System.out.println("Book has been deleted");
        return "redirect:/books";
    }






    //Borrower
    @GetMapping({ "/borrowers"})
    public String showBorrowersList(Model model) {
        model.addAttribute("borrowers", borrowerRepository.findAll());
        return "borrowers";
    }

    @GetMapping("/addBorr")
    public String showBorrower (Borrower borrower, Model model) {
        model.addAttribute("borrowers", borrower);
        return "addBorr";
    }
    @PostMapping("/addBorrower")
    public String addBorrower (@Valid Borrower borrower, BindingResult result){
        if (result.hasErrors()){
            return "addBorr";
        }
        borrowerRepository.save(borrower);
        return "redirect:/borrowers";
    }



    @GetMapping("/editBorr/{id}")
    public String showBorrUpdateForm(@PathVariable("id") Long id, Model model) {
        Borrower borrower = borrowerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid borrower Id:" + id));
        model.addAttribute("borrowers", borrower);
        return "updateBorr";
    }
    @PostMapping("/updateBorr/{id}")
    public String updateBorrower(@PathVariable("id") Long id,@Valid Borrower borrower,
                             BindingResult result){
        if(result.hasErrors()){
            borrower.setId(id);
            return "updateBorr";
        }
        borrowerRepository.save(borrower);
        return "redirect:/borrowers";
    }



    @GetMapping("/deleteBorr/{id}")
    public String deleteBorrower(@PathVariable("id") Long id) {
        Borrower borrower = borrowerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid borrower Id:" + id));
        borrowerRepository.delete(borrower);
        System.out.println("Borrower has been deleted");
        return "redirect:/borrowers";
    }
}