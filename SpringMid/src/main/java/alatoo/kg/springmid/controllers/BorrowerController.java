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
public class BorrowerController {
    //we will call BookRepository and Generate a constructor for it
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowerRepository borrowerRepository;
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