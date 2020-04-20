package bankpck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		System.out.println("New Bank " + name + "added. Please add your first branch :");
		b.getBranches().add(BranchService.addBranch());
		return b;
	}
	
	private Branch returnBranch(String name, Bank b) {
		for (Branch branch : b.getBranches()) {
			if (branch.getBranchName() == name) {
				return branch;
			}
		}
		return null;
	}
	
	private Customer returnCustomer(String name, Bank b) {
		Branch branch = returnBranch(name, b);
		System.out.println("Customer found in branch "+branch.getBranchName()+" .");
		return BranchService.findCustomer(name, branch);
	}
}
