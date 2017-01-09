package app.services;

import app.models.TrainingPlan;
import app.models.User;
import app.repositories.TrainingPlanRepository;
import app.repositories.UserRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Siergus
 */
@Service
public class TrainingPlanService {
    @Autowired
    private TrainingPlanRepository trainingPlanRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public String create(long userId, TrainingPlan trainingPlan) {
        try {
            User user = userRepository.findById(userId);
            trainingPlan.setUser(user);
            trainingPlanRepository.save(trainingPlan);
        }
        catch (Exception ex) {
            return "Error in creating new training plan for user id: " + userId;
        }
        return "Successfully created new training plan for user id: " + userId;
    }
    
    public Set<TrainingPlan> getAllForUser(long userId) {
        Set<TrainingPlan> result;
        try {
            result = userRepository.findById(userId).getTrainingPlans();
        }
        catch (Exception ex) {
            return null;
        }
        return result;
    }
    
    public List<TrainingPlan> getAll() {
        List<TrainingPlan> result;
        try {
            result = trainingPlanRepository.findAll();
        }
        catch (Exception ex) {
            return null;
        }
        return result;
    }
    
    public String update(long id, TrainingPlan trainingPlan) {
        try {
            TrainingPlan trainingPlanTemp = trainingPlanRepository.findById(id);
            trainingPlanTemp.setName(trainingPlan.getName());
            trainingPlanRepository.save(trainingPlanTemp);
        }
        catch (Exception ex) {
            return "Error in updating new training plan id: " + id;
        }
        return "Successfully updating new training plan id: " + id;
    }

    public String delete(long id) {
        try {
            trainingPlanRepository.delete(id);
        }
        catch (Exception ex) {
            return "Error in deleting new training plan id: " + id;
        }
        return "Successfully deleted new training plan id: " + id;
    }
      
}
