package app.controllers;

import app.constants.Mappings;
import app.models.Training;
import app.services.TrainingService;
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
@RequestMapping(Mappings.API + Mappings.TRAINING)
public class TrainingController {    
    @Autowired
    private TrainingService trainingService;
    
    @RequestMapping(method = RequestMethod.POST, value = Mappings.TRAINING_CREATE)
    @ResponseBody
    public String create(@PathVariable("trainingPlanId") long trainingPlanId, @RequestBody Training training) {
        return trainingService.create(trainingPlanId, training);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = Mappings.TRAINING_DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") long id) {
        return trainingService.delete(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Mappings.TRAINING_UPDATE)
    @ResponseBody
    public String update(@PathVariable("id") long id, @RequestBody Training training) {
        return trainingService.update(id, training);
    }

    @RequestMapping(method = RequestMethod.GET, value = Mappings.TRAINING_FOR_TRAINING_PLAN)
    @ResponseBody
    public Set<Training> getAllForTrainingPlan(@PathVariable("trainingPlanId") long trainingPlanId) {
        return trainingService.getAllForTrainingPlan(trainingPlanId);
    }

    @RequestMapping(method = RequestMethod.GET, value = Mappings.TRAINING_GET_ALL)
    @ResponseBody
    public List<Training> getAll() {
        return trainingService.getAll();
    }
}
