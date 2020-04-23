package interfaces;

import models.Bank;
import models.Branch;
import models.Customer;

public interface BankService {
	Bank addBank();
	Customer returnBankCustomer(String name, Bank b);
	void addBranch(Bank b);
	Branch returnBranch(String name, Bank b);

}
