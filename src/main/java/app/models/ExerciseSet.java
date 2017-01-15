package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EXERCISE_SET")
public class ExerciseSet {
    private long id;
    private int repsNumber;
    private int enduranceTime;
    private ExerciseStats exerciseStats;

    public ExerciseSet() {
    }

    public ExerciseSet(long id) {
        this.id = id;
    }

    public ExerciseSet(int repsNumber, int enduranceTime) {
        this.repsNumber = repsNumber;
        this.enduranceTime = enduranceTime;
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
    @Column(name = "reps_number")
    public int getRepsNumber() {
        return repsNumber;
    }

    public void setRepsNumber(int repsNumber) {
        this.repsNumber = repsNumber;
    }

    @Basic
    @Column(name = "endurance_time")
    public int getEnduranceTime() {
        return enduranceTime;
    }

    public void setEnduranceTime(int enduranceTime) {
        this.enduranceTime = enduranceTime;
    }

    @Basic
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "exercise_stats_fk")
    public ExerciseStats getExerciseStats() {
        return exerciseStats;
    }

    public void setExerciseStats(ExerciseStats exerciseStats) {
        this.exerciseStats = exerciseStats;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + this.repsNumber;
        hash = 53 * hash + Objects.hashCode(this.enduranceTime);
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
        final ExerciseSet other = (ExerciseSet) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.repsNumber != other.repsNumber) {
            return false;
        }
        if (!Objects.equals(this.enduranceTime, other.enduranceTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ExerciseSet{" + "id=" + id + ", repsNumber=" + repsNumber + ", enduranceTime=" + enduranceTime + '}';
    }
    
    
}
