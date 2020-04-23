package models;

import java.util.Date;

public class DebitAccount extends Account{

	public DebitAccount(String name,Customer customer, Double balance, Date date) {
		super(name, customer, balance, 0.005, date);
	}

}
