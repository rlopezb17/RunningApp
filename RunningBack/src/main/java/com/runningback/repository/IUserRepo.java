package com.runningback.repository;

import com.runningback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepo extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
