package models;

import java.util.Date;

public class CreditAccount extends Account {

	public CreditAccount(String name,Customer customer, Double balance, Date date) {
		super(name, customer, balance, 0.02, date);
	}

}
