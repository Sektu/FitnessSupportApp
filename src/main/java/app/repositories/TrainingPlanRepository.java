package app.repositories;

import app.models.TrainingPlan;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Siergus
 */
@Transactional
public interface TrainingPlanRepository extends JpaRepository<TrainingPlan, Long>{
    public TrainingPlan findById(long id);
    public List<TrainingPlan> findAll();
}
