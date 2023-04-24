package com.roomreservation.requestformbooking.repository;

import com.roomreservation.requestformbooking.model.HallBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryHall extends JpaRepository<HallBooking,Long> {
}
