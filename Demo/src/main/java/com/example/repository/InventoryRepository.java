package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository <Inventory,Integer>{

}
