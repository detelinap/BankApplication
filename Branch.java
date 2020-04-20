package bankpck;
import java.util.ArrayList;

public class Branch {
	private ArrayList <Customer> customers = new ArrayList<>();
	private String branchName;

	public Branch(String branchName) {
		this.branchName = branchName;
		this.customers = new ArrayList<>();
	}

	public String getBranchName() {
		return branchName;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	

}
