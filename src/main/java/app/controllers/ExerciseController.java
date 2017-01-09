package app.controllers;

import app.constants.Mappings;
import app.models.Exercise;
import app.models.Training;
import app.services.ExerciseService;
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
@RequestMapping(Mappings.API + Mappings.EXERCISE)
public class ExerciseController {
    
    @Autowired
    private ExerciseService exerciseService;
    
    @RequestMapping(method = RequestMethod.POST, value = Mappings.EXERCISE_CREATE)
    @ResponseBody
    public String create(@PathVariable("trainingId") long trainingId, @RequestBody Exercise exercise) {
        return exerciseService.create(trainingId, exercise);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = Mappings.EXERCISE_DELETE)
    @ResponseBody
    public String delete(@PathVariable("id") long id) {
        return exerciseService.delete(id);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Mappings.EXERCISE_UPDATE)
    @ResponseBody
    public String update(@PathVariable("id") long id, @RequestBody Exercise exercise) {
        return exerciseService.update(id, exercise);
    }

    @RequestMapping(method = RequestMethod.GET, value = Mappings.EXERCISE_FOR_TRAINING)
    @ResponseBody
    public Set<Exercise> getAllForTraining(@PathVariable("trainingId") long trainingId) {
        return exerciseService.getAllForTraining(trainingId);
    }

    @RequestMapping(method = RequestMethod.GET, value = Mappings.EXERCISE_GET_ALL)
    @ResponseBody
    public List<Exercise> getAll() {
        return exerciseService.getAll();
    }
    
}
