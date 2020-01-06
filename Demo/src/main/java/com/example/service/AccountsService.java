package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Accounts;
import com.example.repository.AccountsRepository;

@Service
public class AccountsService {
	@Autowired
	private AccountsRepository accountsRepository;

// Save the account Details in repository
	public Accounts createNewAccount(Accounts accounts) {

		return accountsRepository.save(accounts);
	}

//Get the Account Details From Repository
	public List<Accounts> getAllAccounts() {

		return accountsRepository.findAll();
	}

//Update the Account Details By AccountId
	public Accounts updateAccounts(int id, Accounts accounts) {
		Accounts account = null;
		Optional<Accounts> accountsObj = accountsRepository.findById(id);
		if (accountsObj.isPresent()) {
			account = accountsObj.get();
		}
		return account;
	}

}
