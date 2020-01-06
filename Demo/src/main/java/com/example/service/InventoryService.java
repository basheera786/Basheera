package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Inventory;
import com.example.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;

//Create the Inventory Details
	public Inventory createInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

//Get the Inventory Details
	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();
	}

//Update the Inventory Details
	public Inventory updateInventory(int id, Inventory inventory) {
		Inventory invent = null;
		Optional<Inventory> inventObj = inventoryRepository.findById(id);
		if (inventObj.isPresent()) {
			invent = inventObj.get();
		}
		return invent;
	}

}
