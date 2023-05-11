//package alatoo.kg.springmid.bootstrap;
//
//import alatoo.kg.springmid.moduels.Book;
//import alatoo.kg.springmid.moduels.Borrower;
//import alatoo.kg.springmid.repositories.BookRepository;
//import alatoo.kg.springmid.repositories.BorrowerRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
////CommandLineRunner is a functional interface that used to indicate that a bean should run when it is contained
////@Component (Spring manage component) is an annotation that allows Spring to automatically detect our custom beans.
////Spring will Scan our application for classes annotated with @Component.Instantiate them and inject any specified dependencies into them.
//@Component
//public class bootstrapData implements CommandLineRunner {
//    //Call the Repositories
//    private final BookRepository bookRepository;
//    private final BorrowerRepository borrowerRepository;
//
//    //Generate non-empty constructor
//    public bootstrapData(BookRepository bookRepository, BorrowerRepository borrowerRepository) {
//        this.bookRepository = bookRepository;
//        this.borrowerRepository = borrowerRepository;
//    }
//
//
//    //generate implement run method with override to make the function work
//    @Override
//    public void run(String... args) throws Exception {
//        //add book in Book set and borrower in Borrower srt with the fields and information
//        Book book1 = new Book("Freedom at Midnight","Dominique Lapierre","a","123456789");
//        Borrower borr1 = new Borrower("Ahmed","Ahmed@gmail.com","0505039827");
//
//        //connect between the sets
//        book1.getBorrower().add(borr1);
//        borr1.getBook().add(book1);
//
//        //save changes in repository (H2 Database) which we called in the beginning of this class
//        bookRepository.save(book1);
//        borrowerRepository.save(borr1);
//
//        //do again and again
//        Book book2 = new Book("Old Man and the Sea","Ernest Hemingway","b","111111111");
//        Borrower borr2 = new Borrower("Mohammad","Mohammad@gmail.com","0507262625");
//        book2.getBorrower().add(borr2);
//        borr2.getBook().add(book2);
//        bookRepository.save(book2);
//        borrowerRepository.save(borr2);
//
//        Book book3 = new Book("For Whom the Bells Tolls","Ernest Hemingway","b","111111112");
//        Borrower borr3 = new Borrower("Fatima","Fatima@gmail,com","0508625678");
//        book3.getBorrower().add(borr3);
//        borr3.getBook().add(book3);
//        bookRepository.save(book3);
//        borrowerRepository.save(borr3);
//
//    }
//}
