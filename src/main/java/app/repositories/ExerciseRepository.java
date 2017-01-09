package app.repositories;

import app.models.Exercise;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Siergus
 */
@Transactional
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    public Exercise findById(long id);
    public List<Exercise> findAll();
}