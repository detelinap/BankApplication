package interfaces;

import models.Account;
import models.Customer;

public interface AccountService {
    Account createAccount(Customer c);
    Account chooseAccount(Customer c);
    Double valueOfAccountTransactions(Account a);

}
