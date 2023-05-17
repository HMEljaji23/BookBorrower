package alatoo.kg.springmid.repositories;

import alatoo.kg.springmid.moduels.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    User save(User user);
    List<User> findAll();

}
