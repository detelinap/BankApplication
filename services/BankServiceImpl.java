package bankpck.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bankpck.interfaces.BankService;
import bankpck.interfaces.BranchService;
import bankpck.interfaces.CustomerService;
import bankpck.models.Bank;
import bankpck.models.Branch;
import bankpck.models.Customer;

public class BankServiceImpl implements BankService {

	BranchService branchService = new BranchServiceImpl();
	CustomerService customerService = new CustomerServiceImpl();

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public void programBegin() {
		System.out.println("Welcome to this simple bank application!\nYou "
				+ "are now the manager of this establishment, "
				+ "and you can create banks with "
				+ "customers and transactions."
				+ "\nThe first step is to create a bank.");
	}


	public Bank addBank() {
		System.out.println("What is the name of the Bank?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Bank b = new Bank(name);
		System.out.println("New Bank " + name + " added. Please add your first branch :");
		b.getBranches().add(branchService.addBranch());
		return b;
	}

	public Customer returnBankCustomer(String name, Bank b) {
		for (Branch branch : b.getBranches()) {
			Customer c = branchService.returnCustomer(name, branch);
			if (c != null) {
				return branchService.returnCustomer(name, branch);
			}
		}
		System.out.println("No such customer");
		return null;
	}

	public void addBranch(Bank b) {
		b.getBranches().add(branchService.addBranch());
	}

	public Branch returnBranch(String name, Bank b) {

		for (Branch branch : b.getBranches()) {
			if (branch.getName().equals(name)) {
				return branch;
			}
		}
		return null;
	}

	public void addCustomerTransaction(String name, Bank b) {
		Customer c = returnBankCustomer(name, b);
		customerService.addCustomerTransaction(c);
	}

	public void addCustomerToBank(Bank b) throws IOException {
		System.out.println("Which Branch would you like to add your customer to?\n Your options are:");
		boolean foundBranch = false;
		for (Branch branch : b.getBranches()) {
			System.out.println(branch.getName());
		}
		String choice = reader.readLine();
		for (Branch branch : b.getBranches()) {
			if (branch.getName().equals(choice)) {
				branchService.addCustomer(branch);
				foundBranch = true;
			}
		}
		if (foundBranch == false) {
			System.out.println("Sorry, we didn't find the branch you typed out. Please try again.");
		}
	}

	public void printOptions() {
		System.out.println("Please make your choice of the following:" + "\n Write 0 to leave this program"
				+ "\n Write 1 to make a new Bank" + "\n Write 2 to add a new Branch"
				+ "\n Write 3 to add a new Customer" + "\n Write 4 to find a Customer"
				+ "\n Write 5 to add a Customer Transaction"
				+ "\n Write 6 to print all the information about a customer.");
	}

	public void printCustomerInformation(String name, Bank b) {
		Customer c = returnBankCustomer(name, b);
		customerService.customerInformation(c);
		System.out.println("Total value of customer transactions :"+customerService.valueOfCustomerTransactions(c));
		
	}
	
	public void choice(Bank b) throws IOException {
		int n = 0;
		printOptions();
		try {
			System.out.println("Please make your choice");
			n = Integer.parseInt(reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (n != 0) {
			switch (n) {
			case 0:
				return;
			case 1:
				addBank();
				break;
			case 2:
				addBranch(b);
				break;
			case 3:
				addCustomerToBank(b);
				break;
			case 4:
				System.out.println("Please enter the customer's name");
				String name = reader.readLine();
				printCustomerInformation(name, b);
				break;
			case 5:
				System.out.println("Please enter the customer's name");
				String secondName = reader.readLine();
				addCustomerTransaction(secondName, b);
				break;
			case 6:
				System.out.println("Please enter the customer's name");
				String thirdName = reader.readLine();
				printCustomerInformation(thirdName,b);
				break;
			default:
				System.out.println("You have chosen an invalid option. Please see the list of options again and "
						+ "make a valid choice.");
				printOptions();

			}
			System.out.println("Would you like to see the menu again?");
			String menu = null;
			menu = reader.readLine();
			if (menu.equalsIgnoreCase("yes")) {
				printOptions();
			}
			try {
				System.out.println("Please make your choice. If you would like to exit, press 0");
				n = Integer.parseInt(reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
