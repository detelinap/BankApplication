package bankpck;

import java.util.ArrayList;

public class Customer {
	private ArrayList<Transaction> transactions = new ArrayList<>();
	private String name;
	
	public Customer() {
		
	}

	protected Customer(String name) {
		this.transactions = new ArrayList<>();
		this.name = name;
		
	}

	ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public String getName() {
		return name;
	}


	
}
