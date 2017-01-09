package app.controllers;

import app.constants.Mappings;
import app.models.TrainingPlan;
import app.services.TrainingPlanService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Siergus
 */
@RestController
@RequestMapping(Mappings.API + Mappings.TRAINING_PLAN)
public class TrainingPlanController {
    
    @Autowired
    private TrainingPlanService trainingPlanService;
    
    @RequestMapping(method = RequestMethod.POST, value = Mappings.TRAINING_PLAN_CREATE)
    @ResponseBody
    public String create(@PathVariable("userId") long userId, @RequestBody TrainingPlan trainingPlan) {
        return trainingPlanService.create(userId, trainingPlan);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = Mappings.TRAINING_PLAN_DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") long id) {
        return trainingPlanService.delete(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Mappings.TRAINING_PLAN_UPDATE)
    @ResponseBody
    public String update(@PathVariable("id") long id, @RequestBody TrainingPlan trainingPlan) {
        return trainingPlanService.update(id, trainingPlan);
    }

    @RequestMapping(method = RequestMethod.GET, value = Mappings.TRAINING_PLAN_GET_ALL_BY_USERID)
    @ResponseBody
    public Set<TrainingPlan> getAllForUser(@PathVariable("userId") long userId) {
        return trainingPlanService.getAllForUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET, value = Mappings.TRAINING_PLAN_GET_ALL)
    @ResponseBody
    public List<TrainingPlan> getAll() {
        return trainingPlanService.getAll();
    }

}
