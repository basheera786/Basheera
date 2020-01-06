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

import com.example.domain.Accounts;
import com.example.error.CustomException;
import com.example.service.AccountsService;

@RestController
@RequestMapping("/api/account")
public class AccountsResource {
	@Autowired
	private AccountsService accountsService;

	/**
	 * 
	 * @param accounts
	 * @return
	 * @throws CustomException
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<Accounts> create(@RequestBody Accounts accounts) throws CustomException 	 {
		if (accounts == null) {
			throw new CustomException("should not be null");
		}
		Accounts account = accountsService.createNewAccount(accounts);
		return new ResponseEntity<Accounts>(account, HttpStatus.OK);

	}
	
	/**
	 * 
	 * @param id
	 * @param accounts
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Accounts> update(@PathVariable int id, @RequestBody Accounts accounts) {
		Accounts account = accountsService.updateAccounts(id, accounts);
		// logger.info("person update successfully wiht id: {}",person);
		return new ResponseEntity<Accounts>(account, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/get")
	public ResponseEntity<List<Accounts>> getAll() {

		List<Accounts> account = accountsService.getAllAccounts();
		return new ResponseEntity<List<Accounts>>(account, HttpStatus.OK);
	}
}
