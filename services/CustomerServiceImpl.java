package bankpck.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bankpck.interfaces.CustomerService;
import bankpck.interfaces.TransactionService;
import bankpck.models.Account;
import bankpck.models.Customer;
import bankpck.models.Transaction;

public class CustomerServiceImpl  implements CustomerService{

	private TransactionService transactionService = new TransactionServiceImpl();
	
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
		System.out.println("New customer " + name + " added. Please add your first transaction :");
		addCustomerTransaction(c);
		return c;

	}
	

	public Customer addCustomerInformation(String name) {
		
		Customer c = new Customer (name);
		System.out.println("New customer " + name + "added. Please add your first transaction :");
		addCustomerTransaction(c);
		return c;

	}

	
	public void customerInformation(Customer c) {
		int i = 1;
		System.out.println("Name of customer : " + c.getName());
		System.out.println("Total number of customer transactions : " + c.getTransactions().size());
		for (Transaction newT : c.getTransactions()) {
			System.out.println("Transaction #"+i+" :");
			System.out.println(newT.toString());
			i++;
		}
		
	}
	
	public Double valueOfCustomerTransactions(Customer c) {
		Double sum = 0.0;
		for (Transaction t : c.getTransactions()) {
			sum+=t.getAmmount();
		}
		return sum;
	}
	
	public void addCustomerTransaction(Customer c) {
		System.out.println("Please choose an account for the transaction");
		String choice = null;
		for (Account account : c.getAccounts()) {
			System.out.println(account.getName());
		}
		System.out.println("Please enter the account you would like to use for the transaction");
		try {
			choice = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Account account : c.getAccounts()) {
			if (account.getName() == choice) {
				////// TODO Save account
			}
		}
		Transaction newT = transactionService.createTransaction();
		c.getTransactions().add(newT);
		newT.toString();
	}

}
