package com.raxrot.springbootjdbcexample;

import com.raxrot.springbootjdbcexample.model.User;
import com.raxrot.springbootjdbcexample.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcExampleApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(SpringBootJdbcExampleApplication.class, args);

        UserService userService=context.getBean(UserService.class);

        //add user to DB
        //addUser(userService);

        //update user from DB
        //updateUser(userService);

        //delete user from DB
        //deleteUser(userService);

        //get all users
        //getAllUsers(userService);

        //getUserById
        //getUserById(userService);

    }

    public static void addUser(UserService userService){
        User user=new User();
        user.setUserId(2);
        user.setName("Daria");
        user.setAge(20);
        userService.addUser(user);
        System.out.println("a new user added "+ user);
    }

    public static void updateUser(UserService userService){
        User userToUpdate=new User();
        userToUpdate.setUserId(2);//Insert id what we need to update
        userToUpdate.setName("newDaria");
        userToUpdate.setAge(19);
        userService.updateUser(userToUpdate);
        System.out.println("a user was updated "+userToUpdate);
    }

    public static void deleteUser(UserService userService){
        int userIdToDelete=2;
        userService.deleteUser(userIdToDelete);
    }

    public static void getAllUsers(UserService userService){
        List<User> allUsers=userService.getUsers();
        System.out.println("All users:");
        for(User user:allUsers){
            System.out.println(user);
        }
    }

    public static void getUserById(UserService userService){
        int userIdToFind=1;
        User findedUser = userService.getUserById(userIdToFind);
        System.out.println(findedUser);
    }



}
