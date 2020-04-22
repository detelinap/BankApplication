package bankpck.models;

import java.util.Date;

public class PensionAccount extends Account{
	
	public PensionAccount(String name, Customer customer, Double balance, Date date) {
		super(name, customer, balance, 0.015, date);
	}
	

}
