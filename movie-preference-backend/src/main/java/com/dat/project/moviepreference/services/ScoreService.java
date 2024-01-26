package com.dat.project.moviepreference.services;

import com.dat.project.moviepreference.dto.MovieDTO;
import com.dat.project.moviepreference.dto.ScoreDTO;
import com.dat.project.moviepreference.entities.Movie;
import com.dat.project.moviepreference.entities.Score;
import com.dat.project.moviepreference.entities.User;
import com.dat.project.moviepreference.repositories.MovieRepository;
import com.dat.project.moviepreference.repositories.ScoreRepository;
import com.dat.project.moviepreference.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveSCore(ScoreDTO dto) {

        User user = userRepository.findByEmail(dto.getEmail());
        if (user ==null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);

        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum = sum + s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }

}