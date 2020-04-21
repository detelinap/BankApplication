package bankpck.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bankpck.interfaces.BranchService;
import bankpck.interfaces.CustomerService;
import bankpck.models.Branch;
import bankpck.models.Customer;

public class BranchServiceImpl implements BranchService {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private CustomerService customerService = new CustomerServiceImpl();
	
	public Branch addBranch() {
		System.out.println("What is the name of the Branch?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Branch b = new Branch(name);
		System.out.println("New Branch " + name + " added.");
		addCustomer(b);
		return b;
	}

	public void addCustomer(Branch b) {
		System.out.println("Please add your customer information.");
		b.getCustomers().add(customerService.addCustomerInformation());
	}

	public void addMoreCustomers(Branch b) {
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
				addCustomer(b);
			} else {
				addCustomers = false;
			}

		}

	}
	
	public void addTransactionToCustomer(String name, Branch b) {
		Customer customer = returnCustomer(name, b);
		if (customer != null) {
			customerService.addCustomerTransaction(customer);
		} else {
			System.out.println("Customer not found.");
		}
	}

	 public Customer returnCustomer(String name, Branch b) {

		for (Customer customer : b.getCustomers()) {
			if (customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;

	}

}
