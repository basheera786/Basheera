package com.example.controller;

import java.util.List;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Orders;
import com.example.error.CustomException;
import com.example.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrdersResource {

	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/create")
	public ResponseEntity<List<Orders>> createOrders(@RequestBody Orders orders,@RequestParam("id") Integer id) throws CustomException {
		List<Orders> order = (List<Orders>) orderService.createOrder(orders,id);
		return new ResponseEntity<List<Orders>>(order, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Orders> update(@PathVariable int id, @RequestBody Orders orders) {
		Orders order = orderService.updateOrders(id, orders);
		// logger.info("orders update successfully wiht id: {}",order);
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}

	@GetMapping(value = "/getdata", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Orders>> getAll() {
		List<Orders> orders = orderService.getOrders();
		return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
	}
}
