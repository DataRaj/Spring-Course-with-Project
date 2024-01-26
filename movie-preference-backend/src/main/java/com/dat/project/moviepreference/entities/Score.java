package com.dat.project.moviepreference.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dat_score")
public class Score {
    @EmbeddedId
    private ScorePK id = new ScorePK();
    private Double value;

    public Score() {
    }

    public ScorePK getId() {
        return id;
    }
    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public void setId(ScorePK id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Score(ScorePK id, Double value) {
        this.id = id;
        this.value = value;
    }
}
