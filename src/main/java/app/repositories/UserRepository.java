package app.repositories;

import app.models.User;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

  public User findByEmail(String email);
  public List<User> findAll();
}
