package interfaces;

import models.Account;
import models.Customer;

public interface CustomerService {
	Customer addCustomerInformation();
	Customer addCustomerInformation(String name);
	void customerInformation(Customer c);
	void addCustomerTransaction(Customer c, Account a);
	Double valueOfCustomerTransaction(Customer c);
}
