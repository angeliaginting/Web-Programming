package com.example.ppw.repository;

import com.example.ppw.model.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface testRepo extends JpaRepository<test,Integer> {

}
