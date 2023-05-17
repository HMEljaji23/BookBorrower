package alatoo.kg.springmid.moduels;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Borrower {
    @Id
    @GeneratedValue //(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String phone_number;
    //create a set then connect this set and file with the set in Book file
    @ManyToMany //the owner of the link (so no mappedby)
    //generate table and columns names
    @JoinTable(name = "book_borrower", //name of table
            joinColumns = @JoinColumn(name = "book id"),
            inverseJoinColumns = @JoinColumn(name = "borrower_id"))
    private Set<Book> books = new HashSet<>();

    //Generate empty Constructor, non-empty Constructor, Getters and Setters
    public Borrower() {
    }

    public Borrower(String name, String email, String phone_number) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Set<Book> getBook() {
        return books;
    }

    public void setBook(Set<Book> book) {
        this.books = book;
    }

    //Generate @Override equals() and hashCode() functions for id:Long field just and Template: IntelliJ Default
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrower borrower = (Borrower) o;
        return Objects.equals(id, borrower.id);
    }

//    @Override
//    public int hashCode() {
//        return id != null ? id.hashCode() : 0;
//    }

    ////Generate toString() method with overriding
    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", books=" + books +
                '}';
    }
}
