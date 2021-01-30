package watchMovie.dao;

import org.springframework.data.repository.CrudRepository;
import watchMovie.entity.User;

public interface UserRepo extends CrudRepository<User,Integer>{
    User findByName(String name);
}
