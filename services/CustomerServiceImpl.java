package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

import interfaces.AccountService;
import interfaces.CustomerService;
import interfaces.TransactionService;
import models.Account;
import models.Customer;
import models.Transaction;
import services.TransactionServiceImpl;

public class CustomerServiceImpl  implements CustomerService{

	private TransactionService transactionService = new TransactionServiceImpl();
	private AccountService accountService = new AccountServiceImpl();
	
	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));
	

	public Customer addCustomerInformation() {
		System.out.println("What is the name of the customer?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Customer c = new Customer (name);
		System.out.println("New customer " + name + " added. Please add your first account :");
		Account a = accountService.createAccount(c);
		c.getAccounts().add(a);
		addCustomerTransaction(c, a);
		return c;

	}

	public void createNewCustomerAccount(Customer c){
		System.out.println("New account for "+c.getName()+" is being created");
		accountService.createAccount(c);
	}
	

	public Customer addCustomerInformation(String name) {
		
		Customer c = new Customer (name);
		System.out.println("New customer " + name + "added. Please add your account :");
		Account a = accountService.createAccount(c);
		c.getAccounts().add(a);
		addCustomerTransaction(c, a);
		return c;

	}

	public int calculateTransactions(Customer c){
		int size = 0;
		for (Account account : c.getAccounts()){
			size += account.getTransactions().size();
		}
		return size;
	}

	public void printTransactions(Account a, Customer c){
		int i = 1;
		for (Account account : c.getAccounts()){
			for (Transaction transaction : account.getTransactions()){
				System.out.println("Transaction "+i+" :");
				System.out.println(transaction.toString());
				i++;
			}
		}
	}
	
	public void customerInformation(Customer c) {
		int i = 1;
		System.out.println("Name of customer : " + c.getName());
		System.out.println("Total number of customer transactions : " + calculateTransactions(c));
		for(Account account : c.getAccounts()) {
			printTransactions(account, c);
		}
	}
	

	public void addCustomerTransaction(Customer c, Account a) {
		Transaction newT = transactionService.createTransaction(c, a);
		a.getTransactions().add(newT);
		newT.toString();
	}

	public Double valueOfCustomerTransaction(Customer c){
		Double sum = 0.0;
		for (Account a : c.getAccounts()){
		sum += accountService.valueOfAccountTransactions(a);
		}
		return sum;
	}
}
