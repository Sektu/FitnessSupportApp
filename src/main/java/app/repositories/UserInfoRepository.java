package app.repositories;

import app.models.UserInfo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Siergus
 */
@Transactional
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
    public UserInfo findById(long id);
    public UserInfo findByFirstNameAndLastName(String firstName, String lastName);
    public List<UserInfo> findByAge(int age);
    public List<UserInfo> findAll();
}
