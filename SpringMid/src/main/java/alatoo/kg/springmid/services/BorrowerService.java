package alatoo.kg.springmid.services;

import alatoo.kg.springmid.moduels.Borrower;
import java.util.List;
import java.util.UUID;

public interface BorrowerService {
    List<Borrower> findAll();

    Borrower saveBorrower(Borrower borrower);


    void updateBorrowerById(long borrowerId, Borrower borrower);

    Borrower findById(long borrowerId);

    void deleteById(long borrowerId);

    void patchBorrowerById(long borrowerId, Borrower borrower);
}
