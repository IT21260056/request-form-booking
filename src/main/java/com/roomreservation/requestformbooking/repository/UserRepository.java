package com.roomreservation.requestformbooking.repository;

import com.roomreservation.requestformbooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
