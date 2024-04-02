package ma.p13activit.p22activite.entities.repositories;

import ma.p13activit.p22activite.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, String> {
    User findByUsername(String userName);


}
