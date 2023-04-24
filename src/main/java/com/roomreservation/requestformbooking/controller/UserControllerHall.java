package com.roomreservation.requestformbooking.controller;

import com.roomreservation.requestformbooking.exception.UserNotFoundException;
import com.roomreservation.requestformbooking.model.HallBooking;
//import com.roomreservation.requestformbooking.model.User;
import com.roomreservation.requestformbooking.model.User;
import com.roomreservation.requestformbooking.repository.UserRepositoryHall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserControllerHall {

    @Autowired
    private UserRepositoryHall userRepositoryHall;

    @PostMapping("/user1")
    HallBooking newHallBooking(@RequestBody HallBooking newHallBooking){
        return userRepositoryHall.save(newHallBooking);
    }

    @GetMapping("/users1")
    List<HallBooking> getAllUsers(){
        return userRepositoryHall.findAll();
    }

    @GetMapping("/user1/{id}")
    HallBooking getuserById(@PathVariable Long id){
        return userRepositoryHall.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

//    @PutMapping("/user/{id}")
//    User updateUser(@RequestBody User newUser, @PathVariable Long id){
//        return userRepository.findById(id)
//                .map(user -> {
//                    user.setName(newUser.getName());
//                    user.setCheckInDate(newUser.getCheckInDate());
//                    user.setCheckOutDate(newUser.getCheckOutDate());
//                    user.setCheckOutDate(newUser.getCheckOutDate());
//                    user.setType(newUser.getType());
//                    user.setNoOfPerson(newUser.getNoOfPerson());
//                    user.setNoOfRooms(newUser.getNoOfRooms());
//
//                    return userRepository.save(user);
//
//                }).orElseThrow(()->new UserNotFoundException(id));
//
//    }

    @DeleteMapping("/user1/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepositoryHall.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepositoryHall.deleteById(id);
        return "User with id "+id+"has been deleted success";
    }
}


