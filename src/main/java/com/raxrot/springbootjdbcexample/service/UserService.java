package com.raxrot.springbootjdbcexample.service;

import com.raxrot.springbootjdbcexample.model.User;
import com.raxrot.springbootjdbcexample.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserRepo getUserRepo() {
        return userRepo;
    }

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user) {
        userRepo.adduser(user);
    }

    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

    public List<User> getUsers() {
       return userRepo.getAllUsers();
    }

    public void updateUser(User user) {
        userRepo.updateUser(user);
    }

    public void deleteUser(int userId) {
        userRepo.deleteUser(userId);
    }

}
