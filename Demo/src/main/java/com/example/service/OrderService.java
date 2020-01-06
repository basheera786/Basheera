package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Accounts;
import com.example.domain.Inventory;
import com.example.domain.Orders;
import com.example.error.CustomException;
import com.example.repository.AccountsRepository;
import com.example.repository.OrdersRepository;

@Service
public class OrderService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private AccountsRepository accountsRepository;

//create the order in repository
	public Orders createOrder(@Valid Orders orders, Integer id) throws CustomException {
		Orders order = null;
		Integer items = 0, totalPrice = 0;
		// Get the accnt details by accntId
		Optional<Accounts> accnt = accountsRepository.findById(id);
		Accounts accnts = null;
		if (accnt.isPresent()) {
			accnts = accnt.get();
			// get the inventory details from orders table
			List<Inventory> list = orders.getInventor();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getQuantity() != null) {
					items = list.get(i).getQuantity();
				}
			}
			// calculate the total price
			totalPrice = orders.getOrderPrice() * items;
			// checking the account balance is available or not for ordering the items
			// If account balance is sufficient then it is save to repository
			if (accnts.getAccntBal() > totalPrice) {
				order = ordersRepository.save(orders);
				accnts.setAccntBal(accnts.getAccntBal() - totalPrice);
				accountsRepository.save(accnts);
			} else {
				throw new CustomException("Insufficient Balance");
			}
		}
		return order;
	}

//Get the order details 
	public List<Orders> getOrders() {

		return ordersRepository.findAll();
	}

//Update the Order details by Order Id
	public Orders updateOrders(int id, Orders orders) {
		Orders order = null;
		Optional<Orders> orderObj = ordersRepository.findById(id);
		if (orderObj.isPresent()) {
			order = orderObj.get();
		}
		return order;
	}

}
