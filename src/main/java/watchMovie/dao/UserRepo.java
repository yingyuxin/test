package watchMovie.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import watchMovie.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User,Integer>{
    User findByName(String name);
}
