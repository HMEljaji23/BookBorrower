package alatoo.kg.springmid.repositories;

import alatoo.kg.springmid.moduels.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//JPA Repository is mainly used for managing the data in a Spring Boot Application
//CrudRepository is a Spring Data interface for generic CRUD operations on a repository of a specific type
//CrudRepository methods : count()/delete()/deleteById()/deleteAll()/deleteAllById()/existsById()/findAll()/findAllById()/findById()/save()/saveAll()
//CrudRepository<type = Book class in Book file,id value = Long>
//now runtime spring will provide implementation
@Repository
public interface BookRepository extends CrudRepository <Book, Long>{
}
