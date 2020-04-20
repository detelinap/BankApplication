package bankpck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerService {

	
	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));
	

	public static Customer addCustomerInformation() {
		System.out.println("What is the name of the customer?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Customer c = new Customer (name);
		System.out.println("New customer " + name + "added. Please add your first transaction :");
		addCustomerTransaction(c);
		return c;

	}

	public static Customer addCustomerInformation(String name) {
		
		Customer c = new Customer (name);
		System.out.println("New customer " + name + "added. Please add your first transaction :");
		addCustomerTransaction(c);
		return c;

	}

	
	public static void customerInformation(Customer c) {
		int i = 1;
		System.out.println("Name of customer :" + c.getName());
		System.out.println("Total number of customer transactions :" + c.getTransactions().size());
		for (Transaction newT : c.getTransactions()) {
			System.out.println("Transaction #"+i+" :");
			c.getTransactions().get(c.getTransactions().indexOf(newT)).toString();
		}
		
	}
	
	public static void addCustomerTransaction(Customer c) {
		Transaction newT = TransactionService.createTransaction();
		c.getTransactions().add(newT);
		newT.toString();
	}

}
