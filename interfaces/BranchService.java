package bankpck.interfaces;

import bankpck.models.Branch;
import bankpck.models.Customer;

public interface BranchService {
	Branch addBranch();
	void addCustomer(Branch b);
	void addMoreCustomers(Branch b);
	void addTransactionToCustomer(String name, Branch b);
	Customer returnCustomer(String name, Branch b);

}
