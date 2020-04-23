package interfaces;

import models.Branch;
import models.Customer;

public interface BranchService {
	Branch addBranch();
	void addCustomer(Branch b);
	void addMoreCustomers(Branch b);
	void addTransactionToCustomer(String name, Branch b);
	Customer returnCustomer(String name, Branch b);

}
