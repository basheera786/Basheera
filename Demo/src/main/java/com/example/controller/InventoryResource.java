package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Inventory;
import com.example.service.InventoryService;

@RestController
@RequestMapping(value = "/api/inventory")
public class InventoryResource {
	@Autowired
	private InventoryService inventoryService;

	@PostMapping(value = "/create")
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		Inventory inventor = inventoryService.createInventory(inventory);
		return new ResponseEntity<Inventory>(inventor, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Inventory> update(@PathVariable int id, @RequestBody Inventory inventory) {
		Inventory invent = inventoryService.updateInventory(id, inventory);
		// logger.info("person update successfully wiht id: {}",person);
		return new ResponseEntity<Inventory>(invent, HttpStatus.CREATED);
	}

	@GetMapping("/get-all")
	public ResponseEntity<List<Inventory>> getAll() {
		List<Inventory> inventory = inventoryService.getAllInventory();
		return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.CREATED);
	}

}
