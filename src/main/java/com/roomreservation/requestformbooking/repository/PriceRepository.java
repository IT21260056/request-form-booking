package com.roomreservation.requestformbooking.repository;
import com.roomreservation.requestformbooking.model.RoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<RoomPrice,Long> {
}
