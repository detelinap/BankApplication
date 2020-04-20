package bankpck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BranchService {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static Branch addBranch() {
		System.out.println("What is the name of the Branch?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Branch b = new Branch(name);
		System.out.println("New Branch " + name + " added. Please add your first customer :");
		addCustomer(b);
		addMoreCustomers(b);
		return b;
	}

	public static void addCustomer(Branch b) {
		System.out.println("Please add your customer information.");
		b.getCustomers().add(CustomerService.addCustomerInformation());
	}

	public static void addMoreCustomers(Branch b) {
		boolean addCustomers = true;
		String decision = null;
		while (addCustomers == true) {
			System.out.println("Would you like to add more customers to your branch " + b.getName() + " ?");
			try {
				decision = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (decision.equalsIgnoreCase("yes")) {
				addCustomers = true;
				BranchService.addCustomer(b);
			} else {
				addCustomers = false;
			}

		}

	}
	
	public static void addTransactionToCustomer(String name, Branch b) {
		Customer customer = returnCustomer(name, b);
		if (customer != null) {
			CustomerService.addCustomerTransaction(customer);
		} else {
			System.out.println("Customer not found.");
		}
	}

	static Customer returnCustomer(String name, Branch b) {

		for (Customer customer : b.getCustomers()) {
			if (customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;

	}

}
