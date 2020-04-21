package bankpck.models;
import java.util.ArrayList;

public class Branch {
	private ArrayList <Customer> customers = new ArrayList<>();
	private String name;

	public Branch(String branchName) {
		this.name = branchName;
		this.customers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	

}
