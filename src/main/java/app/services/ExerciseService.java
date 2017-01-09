/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.models.Exercise;
import app.models.Training;
import app.repositories.ExerciseRepository;
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
public class ExerciseService {

    @Autowired
    private TrainingRepository trainingRepository;
    
    @Autowired
    private ExerciseRepository exerciseRepository;

    public String create(long trainingId, Exercise exercise) {
        try {
            Training training = trainingRepository.findById(trainingId);
            exercise.setTraining(training);
            exerciseRepository.save(exercise);
        }
        catch (Exception ex) {
            return "Error in creating new exercise for training";
        }
        return "Successfully created new exercise for training";
    }

    public String delete(long id) {
        try {
            exerciseRepository.delete(id);
        }
        catch (Exception ex) {
            return "Error in deleting exercise id: " + id;
        }
        return "Successfully deleted exercise id: " + id;
    }

    public String update(long id, Exercise exercise) {
        try {
            Exercise exerciseTemp = exerciseRepository.findById(id);
            
            exerciseTemp.setName(exercise.getName());
            exerciseTemp.setSetsNumber(exercise.getSetsNumber());
            exerciseTemp.setRepsNumber(exercise.getRepsNumber());
            exerciseTemp.setEnduranceTime(exercise.getEnduranceTime());
            exerciseTemp.setBreakTime(exercise.getBreakTime());
            
            exerciseRepository.save(exerciseTemp);
        }
        catch (Exception ex) {
            return "Error in updating exercise id: " + id;
        }
        return "Successfully updating exercise id: " + id;
    }

    public Set<Exercise> getAllForTraining(long trainingId) {
        Set<Exercise> result;
        try {
            result = trainingRepository.findById(trainingId).getExercises();
        }
        catch (Exception ex) {
            return null;
        }
        return result;
    }

    public List<Exercise> getAll() {
        List<Exercise> result;
        try {
            result = exerciseRepository.findAll();
        }
        catch (Exception ex) {
            return null;
        }
        return result;
    }
    
}
