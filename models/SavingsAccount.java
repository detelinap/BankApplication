package bankpck.models;

import java.util.Date;

public class SavingsAccount extends Account{

	public SavingsAccount(String name, Customer customer, Double balance, Date date) {
		super(name, customer, balance, 0.01, date);
	}

}
