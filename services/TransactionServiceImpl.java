package services;

import interfaces.TransactionService;
import models.Account;
import models.Customer;
import models.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransactionServiceImpl implements TransactionService {
	
	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));
	
	public Transaction createTransaction(Customer c, Account a) {
		System.out.println("What's the name of this transaction?");
		String name = null;
		double ammount = 0;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("What's the ammount?");
		try {
			String doubleValStr = reader.readLine();
			ammount = Double.valueOf(doubleValStr).doubleValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Transaction(name, ammount);
	}

}
