package bankpck.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bankpck.models.Bank;
import bankpck.models.Branch;
import bankpck.models.Customer;

public class BankService {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static Bank addBank() {
		System.out.println("What is the name of the Bank?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Bank b = new Bank(name);
		System.out.println("New Bank " + name + " added. Please add your first branch :");
		b.getBranches().add(BranchService.addBranch());
		return b;
	}

	public static Customer returnBankCustomer(String name, Bank b) {
		for (Branch branch : b.getBranches()) {
			Customer c = BranchService.returnCustomer(name, branch);
			if (c != null) {
				CustomerService.customerInformation(c);;
				return BranchService.returnCustomer(name, branch);
			} 
		}System.out.println("No such customer");
		return null;
	}
	
	public static void addBranch(Bank b) {
		b.getBranches().add(BranchService.addBranch());
	}
	
	
	static Branch returnBranch(String name, Bank b) {

		for (Branch branch : b.getBranches()) {
			if (branch.getName().equals(name)) {
				return branch;
			}
		}
		return null;

	}	
	
}
