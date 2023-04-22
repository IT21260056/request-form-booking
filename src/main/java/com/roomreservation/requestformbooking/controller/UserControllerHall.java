package com.roomreservation.requestformbooking.controller;

import com.roomreservation.requestformbooking.model.HallBooking;
import com.roomreservation.requestformbooking.model.User;
import com.roomreservation.requestformbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("http://localhost:3000")
public class UserControllerHall {

    @Autowired
    private UserRepository userRepositoryHall;

//    @PostMapping("/userHall")
//    HallBooking newHallBooking(@RequestBody HallBooking newHallBooking){
//        return userRepositoryHall.save(newHallBooking);
//    }
}
