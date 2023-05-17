package alatoo.kg.springmid.moduels;

import jakarta.persistence.*;
import org.springframework.web.ErrorResponse;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

//class Book with requirement fields
@Entity
public class Book {
    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    private long id;
    private  String title;
    private String author;
    private String publisher;
    private String ISBN;
    //create a set then connect this set and file with the set in Borrower file (many-to-many relation)
    @ManyToMany(mappedBy = "books")
    //initialize the set using Hashset to connect between the values in Book set and Borrower set
    private Set<Borrower> borrowers = new HashSet<>();

    private String img;

    //Generate empty Constructor (because jpa require that)
    public Book() {
    }

    //Generate Constructor with initialize all fields
    public Book(String title, String author, String publisher, String ISBN) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
    }


    //Generate Getters and Setters for all fields
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Set<Borrower> getBorrower() {
        return borrowers;
    }
    public void setBorrower(Set<Borrower> borrower) {
        this.borrowers = borrower;
    }

    //Generate @Override equals() and hashCode() functions for id:Long field just and Template: IntelliJ Default
    //note: equals method instead of the == operator.
    //equals() use: The String class overrides the equals method it inherited from the Object class and implemented logic to compare the two String objects character by character.
    //override use: default function (without override) means two objects will be considered equal only if they have the same memory address which will be true only if you are comparing an object with itself.
    //But you might want to consider two objects the same if they have the same value for one or more of their properties
    //When you override any method you must match the method name, return type, and parameter types exactly
    // it must be Object or you will have overloaded equals instead of overriding it

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

//    //When using a hash table, these collections calculate the hash value for a given key using the hashCode() method.Then they use this value internally to store the data so that access operations are much more efficient.
//    //if in our class we override equals() we should override hashcode() method also
//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }

    //Generate toString() method
    //it is used to get the string representation of a Java object.
    //By overriding the default behavior of the toString() method, we can make the output of the method call more meaningful.
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", borrower= " + borrowers + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public void setImg(String img) {
        this.img = img;
    }
}


