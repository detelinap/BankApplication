package bankpck.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bankpck.interfaces.TransactionService;
import bankpck.models.Transaction;

public class TransactionServiceImpl implements TransactionService {
	
	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));
	
	public Transaction createTransaction() {
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
