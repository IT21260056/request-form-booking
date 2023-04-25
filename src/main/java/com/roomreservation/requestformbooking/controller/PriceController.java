package com.roomreservation.requestformbooking.controller;

import com.roomreservation.requestformbooking.exception.UserNotFoundException;
import com.roomreservation.requestformbooking.model.RoomPrice;
import com.roomreservation.requestformbooking.model.User;
import com.roomreservation.requestformbooking.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class PriceController {
    @Autowired
    private PriceRepository priceRepository;

    @PostMapping("/price")
    RoomPrice newRoomPrice(@RequestBody RoomPrice newRoomPrice){
        return priceRepository.save(newRoomPrice);
    }

    @GetMapping("/price/{id}")
    RoomPrice getuserById(@PathVariable Long id){
        return priceRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/price/{id}")
    RoomPrice updateUser(@RequestBody RoomPrice newRoomPrice,@PathVariable Long id){
        return priceRepository.findById(id)
                .map(price -> {
                    price.setRoomType(newRoomPrice.getRoomType());
                    price.setPrice(newRoomPrice.getPrice());

                    return priceRepository.save(price);

                }).orElseThrow(()->new UserNotFoundException(id));

    }

}