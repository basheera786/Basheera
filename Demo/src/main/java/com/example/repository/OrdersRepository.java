package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Orders;



@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
}
