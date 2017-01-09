package app.repositories;

import app.models.Training;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Siergus
 */
@Transactional
public interface TrainingRepository extends JpaRepository<Training, Long> {
    public Training findById(long id);
    public List<Training> findAll();
}