package com.runningback.service;

import com.runningback.entity.User;
import com.runningback.repository.IUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(IUserRepo userRepo, PasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = encoder;
    }


    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

}
