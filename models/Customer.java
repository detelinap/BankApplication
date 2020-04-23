package models;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Account> accounts;

	public Customer() {
		
	}

	public Customer(String name) {
		this.name = name;
		this.accounts = new ArrayList<>();
		
	}

	public String getName() {
		return name;
	}


	public ArrayList<Account> getAccounts() {
		return accounts;
	}


	
}
