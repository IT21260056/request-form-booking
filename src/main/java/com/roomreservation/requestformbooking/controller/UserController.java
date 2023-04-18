package com.roomreservation.requestformbooking.controller;

import com.roomreservation.requestformbooking.exception.UserNotFoundException;
import com.roomreservation.requestformbooking.model.User;
import com.roomreservation.requestformbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){

        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getuserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setCheckInDate(newUser.getCheckInDate());
                    user.setCheckOutDate(newUser.getCheckOutDate());
                    user.setCheckOutDate(newUser.getCheckOutDate());
                    user.setType(newUser.getType());
                    user.setNoOfPerson(newUser.getNoOfPerson());
                    user.setNoOfRooms(newUser.getNoOfRooms());

                    return userRepository.save(user);

                }).orElseThrow(()->new UserNotFoundException(id));

    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+"has been deleted success";
    }

}




