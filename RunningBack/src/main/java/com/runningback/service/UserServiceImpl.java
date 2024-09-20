package com.runningback.service;

import com.runningback.entity.User;
import com.runningback.repository.IUserRepo;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(int id, User user) {
        return userRepo.findById(id).map(userUpdate -> {
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setHeight(user.getHeight());
            userUpdate.setWeight(user.getWeight());
            userUpdate.setBirthDate(user.getBirthDate());
            userUpdate.setCountry(user.getCountry());
            return userRepo.save(userUpdate);
        }).orElse(null);
    }

    @Override
    public int getAuthenticatedUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getId();
    }


}
