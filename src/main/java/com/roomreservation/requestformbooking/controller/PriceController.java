package com.roomreservation.requestformbooking.controller;

import com.roomreservation.requestformbooking.model.RoomPrice;
import com.roomreservation.requestformbooking.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class PriceController {
    @Autowired
    private PriceRepository priceRepository;

    @PostMapping("/price")
    RoomPrice newRoomPrice(@RequestBody RoomPrice newRoomPrice){
        return priceRepository.save(newRoomPrice);
    }

}
