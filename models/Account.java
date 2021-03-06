package models;

import java.util.ArrayList;
import java.util.Date;

public class Account {
	private ArrayList<Transaction> transactions;
	private String name;
	private Customer customer;
	private Double balance;
	private Double interest;
	private Date date;
	
	private Account() {
	
	}
	

	protected Account(String name,Customer customer, Double balance, Double interest, Date date) {
		this.name = name;
		this.customer = customer;
		this.balance = balance;
		this.interest = interest;
		this.date = date;
		this.transactions = new ArrayList<>();
	}


	public ArrayList<Transaction> getTransactions (){
		return transactions;
	}
	public String getName() {
		return name;
	}


	public Customer getCustomer() {
		return customer;
	}


	public Double getBalance() {
		return balance;
	}


	public Double getInterest() {
		return interest;
	}


	public Date getDate() {
		return date;
	}
	
}
