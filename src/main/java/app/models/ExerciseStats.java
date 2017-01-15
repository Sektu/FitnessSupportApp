package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EXERCISE_STATS")
public class ExerciseStats {
    private long id;
    private Date exerciseDate;
    private Exercise exercise;
    private Set<ExerciseSet> exerciseSets;

    public ExerciseStats() {
    }

    public ExerciseStats(long id) {
        this.id = id;
    }

    public ExerciseStats(Date exerciseDate) {
        this.exerciseDate = exerciseDate;
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
    @Column(name = "exercise_date")
    public Date getExerciseDate() {
        return exerciseDate;
    }

    public void setExerciseDate(Date exerciseDate) {
        this.exerciseDate = exerciseDate;
    }

    @Basic
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "exercise_fk")
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    
    @Basic
    @JsonIgnore
    @OneToMany(mappedBy = "exerciseStats")   
    public Set<ExerciseSet> getExerciseSets() {
        return exerciseSets;
    }

    public void setExerciseSets(Set<ExerciseSet> exerciseSets) {
        this.exerciseSets = exerciseSets;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.exerciseDate);
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
        final ExerciseStats other = (ExerciseStats) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.exerciseDate, other.exerciseDate)) {
            return false;
        }
        return true;
    }
 
}
