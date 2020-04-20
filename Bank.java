package bankpck;

import java.util.ArrayList;

public class Bank {
	ArrayList<Branch> branches;
	String name;
	
	
	public Bank( String name) {
		super();
		this.branches = new ArrayList<>();
		this.name = name;
	}
	
	public ArrayList<Branch> getBranches() {
		return branches;
	}
	public void setBranches(ArrayList<Branch> branches) {
		this.branches = branches;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
