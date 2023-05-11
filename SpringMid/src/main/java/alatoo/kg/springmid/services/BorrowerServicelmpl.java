package alatoo.kg.springmid.services;

import alatoo.kg.springmid.moduels.Book;
import alatoo.kg.springmid.moduels.Borrower;
import alatoo.kg.springmid.repositories.BookRepository;
import alatoo.kg.springmid.repositories.BorrowerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class BorrowerServicelmpl implements BorrowerService{
    private final Map<Long, Book> borrowerData = new HashMap<>();
    private BorrowerRepository borrowerRepository;
    public BorrowerServicelmpl(BorrowerRepository borrowerRepository) {
//        Borrower borrower1 = Borrower.builder()
//                .id(UUID.randomUUID())
//                .name("Ahmed")
//                .email("Ahmed@gmail.com")
//                .phone_number("0505039827")
//                .build();
//        Borrower borrower2 = Borrower.builder()
//                .id(UUID.randomUUID())
//                .name("Mohammad")
//                .email("Mohammad@gmail.com")
//                .phone_number("0507262625")
//                .build();
//
//        borrowerData.put(borrower1.getId(), borrower1);
//        borrowerData.put(borrower2.getId(), borrower2);
        Borrower borr1 = new Borrower("Ahmed","Ahmed@gmail.com","0505039827");
        borrowerRepository.save(borr1);
        this.borrowerRepository=borrowerRepository;
    }

    @Override
    public List<Borrower> findAll() {
        return (List<Borrower>) borrowerRepository.findAll();
    }

    @Override
    public Borrower saveBorrower(Borrower borrower) {

        return borrowerRepository.save(borrower);
    }

    @Override
    public void updateBorrowerById(long borrowerId, Borrower borrower) {
        Borrower existed = borrowerRepository.findBorrowerById(borrowerId);
        existed.setName(borrower.getName());
        existed.setEmail(borrower.getEmail());
        existed.setPhone_number(borrower.getPhone_number());
        borrowerRepository.save(existed);
    }

    @Override
    public Borrower findById(long borrowerId) {
        {
            return borrowerRepository.findBorrowerById(borrowerId);
        }
    }

    @Override
    public void deleteById(long borrowerId) {
        {
            borrowerRepository.deleteById(borrowerId);
        }
    }

    @Override
    public void patchBorrowerById(long borrowerId, Borrower borrower) {
        Borrower existed = borrowerRepository.findBorrowerById(borrowerId);
        if (StringUtils.hasText(borrower.getName())) {
            existed.setName(borrower.getName());
        }
        if (StringUtils.hasText(borrower.getEmail())) {
            existed.setEmail(borrower.getEmail());
        }
        if (StringUtils.hasText(borrower.getPhone_number())) {
            existed.setPhone_number(borrower.getPhone_number());
        }
        borrowerRepository.save(existed);
    }
}
