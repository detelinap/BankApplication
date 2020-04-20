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

	public String getName() {
		return name;
	}

}
