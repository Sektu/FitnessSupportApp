package app.services;

import app.models.Training;
import app.models.TrainingPlan;
import app.repositories.TrainingPlanRepository;
import app.repositories.TrainingRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Siergus
 */
@Service
public class TrainingService {
    
    @Autowired
    private TrainingPlanRepository trainingPlanRepository;
    
    @Autowired
    private TrainingRepository trainingRepository;

    public String create(long trainingPlanId, Training training) {
        try {
            TrainingPlan trainingPlan = trainingPlanRepository.findById(trainingPlanId);
            training.setTrainingPlan(trainingPlan);
            trainingRepository.save(training);
        }
        catch (Exception ex) {
            return "Error in creating new training for trainingPlan";
        }
        return "Successfully created new training for trainingPlan";
    }

    public String delete(long id) {
        try {
            trainingRepository.delete(id);
        }
        catch (Exception ex) {
            return "Error in deleting training id: " + id;
        }
        return "Successfully deleted training id: " + id;
    }

    public String update(long id, Training training) {
        try {
            Training trainingTemp = trainingRepository.findById(id);
            trainingTemp.setName(training.getName());
            trainingRepository.save(trainingTemp);
        }
        catch (Exception ex) {
            return "Error in updating training id: " + id;
        }
        return "Successfully updating training id: " + id;
    }

    public Set<Training> getAllForTrainingPlan(long trainingPlanId) {
        Set<Training> result;
        try {
            result = trainingPlanRepository.findById(trainingPlanId).getTrainings();
        }
        catch (Exception ex) {
            return null;
        }
        return result;
    }

    public List<Training> getAll() {
        List<Training> result;
        try {
            result = trainingRepository.findAll();
        }
        catch (Exception ex) {
            return null;
        }
        return result;
    }
    
}
