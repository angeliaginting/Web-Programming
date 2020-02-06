package com.example.ppw.repository;

import com.example.ppw.model.orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ordersRepo extends JpaRepository<orders, String> {
}
