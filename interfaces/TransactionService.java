package interfaces;

import models.Account;
import models.Customer;
import models.Transaction;

import java.util.ArrayList;

public interface TransactionService {
	
	Transaction createTransaction(Customer c, Account a);

}
