package com.firebug.Frontend_Backend.service;

import com.firebug.Frontend_Backend.entity.UserEntity;
import com.firebug.Frontend_Backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepo.findById(id);
    }

    public void saveUser(UserEntity user) {
        userRepo.save(user);
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

//    public void updateUserById(Optional<UserEntity> entity) {
//        userRepo.
//    }
}
