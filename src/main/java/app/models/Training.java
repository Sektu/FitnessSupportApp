package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINING")
public class Training {
    private long id;
    private String name;
    private TrainingPlan trainingPlan;
    private Set<Exercise> exercises;
    private Set<TrainingStats> trainingStats;

    public Training() {
    }

    public Training(long id) {
        this.id = id;
    }

    public Training(String name, TrainingPlan trainingPlan) {
        this.name = name;
        this.trainingPlan = trainingPlan;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "training_plan_fk")
    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    @Basic
    @JsonIgnore
    @OneToMany(mappedBy = "training")
    public Set<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Basic
    @JsonIgnore
    @OneToMany(mappedBy = "training")
    public Set<TrainingStats> getTrainingStats() {
        return trainingStats;
    }

    public void setTrainingStats(Set<TrainingStats> trainingStats) {
        this.trainingStats = trainingStats;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Training other = (Training) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }   

    @Override
    public String toString() {
        return "Training{" + "id=" + id + ", name=" + name + '}';
    }
}
