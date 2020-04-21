package bankpck.interfaces;

import bankpck.models.Customer;

public interface CustomerService {
	Customer addCustomerInformation();
	Customer addCustomerInformation(String name);
	void customerInformation(Customer c);
	void addCustomerTransaction(Customer c);
	Double valueOfCustomerTransactions(Customer c);
}
