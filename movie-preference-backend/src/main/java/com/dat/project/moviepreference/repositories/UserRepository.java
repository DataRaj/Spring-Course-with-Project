package com.dat.project.moviepreference.repositories;

import com.dat.project.moviepreference.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String Email);
}
