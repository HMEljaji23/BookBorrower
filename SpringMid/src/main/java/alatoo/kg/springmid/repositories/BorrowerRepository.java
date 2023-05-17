package alatoo.kg.springmid.repositories;

import alatoo.kg.springmid.moduels.Borrower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower, Long> {
    void deleteById(Long id);

    Borrower findBorrowerById(long borrowerId);
}
