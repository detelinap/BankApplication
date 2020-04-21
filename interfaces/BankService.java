package bankpck.interfaces;

import bankpck.models.Bank;
import bankpck.models.Branch;
import bankpck.models.Customer;

public interface BankService {
	Bank addBank();
	Customer returnBankCustomer(String name, Bank b);
	void addBranch(Bank b);
	Branch returnBranch(String name, Bank b);

}
