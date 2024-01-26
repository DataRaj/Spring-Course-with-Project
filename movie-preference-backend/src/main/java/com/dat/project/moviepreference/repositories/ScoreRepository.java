package com.dat.project.moviepreference.repositories;

import com.dat.project.moviepreference.entities.Score;
import com.dat.project.moviepreference.entities.ScorePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
