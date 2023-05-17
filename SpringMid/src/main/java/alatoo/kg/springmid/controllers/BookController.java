package alatoo.kg.springmid.controllers;

import alatoo.kg.springmid.moduels.Book;
import alatoo.kg.springmid.repositories.BookRepository;
import alatoo.kg.springmid.repositories.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


//we should have controller/model/view
//Assign the class with @Controller to register the class as a Spring Bean and as a Controller in Spring MVC
@Controller
public class BookController {
    //we will call BookRepository and Generate a constructor for it
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/img";
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

    @GetMapping("/upload/{id}")
    public String displayUploadForm(@PathVariable("id") long id) {
        bookRepository.findBookById(id);
        return "/imageUpload";
    }

    @PostMapping("/upload/{id}") public String uploadImage(@Valid Book book,@PathVariable("id") long id, @RequestParam("image") MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
        fileNames.append(file.getOriginalFilename());
        Files.write(fileNameAndPath, file.getBytes());
        book.setImg(fileNames.toString());
        bookRepository.save(book);
        return "redirect:/books";
    }

    //Edit and Update
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("books", book);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id,@Valid Book book,
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
    public String deleteBook(@PathVariable("id") long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        if (book.getBorrower() != null) {
            borrowerRepository.deleteById(book.getId());
        }
        bookRepository.delete(book);
        System.out.println("Book has been deleted");
        return "redirect:/books";
    }

}