package bankpck.models;

import java.util.ArrayList;

public class Customer {
	private ArrayList<Transaction> transactions;
	private String name;
	private ArrayList<Account> accounts;

	public Customer() {
		
	}
	

	public Customer(String name) {
		this.transactions = new ArrayList<>();
		this.name = name;
		
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public String getName() {
		return name;
	}


	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	
}
