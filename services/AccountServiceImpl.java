package bankpck.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

import bankpck.interfaces.AccountService;
import bankpck.models.Account;
import bankpck.models.Branch;
import bankpck.models.CreditAccount;
import bankpck.models.Customer;
import bankpck.models.DebitAccount;
import bankpck.models.PensionAccount;
import bankpck.models.SavingsAccount;

public class AccountServiceImpl implements AccountService{

	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));
	
	Calendar calendar = Calendar.getInstance();
	
	public Double setBalance() {
		Double balance;
		String newBalance = null;
		try {
			newBalance = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		balance = Double.valueOf(newBalance);
		return balance;
	}
	
	public void printOptions() {
		System.out.println("Your options are:"
				+ "\n1: Savings account -> Interest is 1%"
				+ "\n2: Debit account -> Interest is 0.5%"
				+ "\n3: Credit account -> Interest is 2% "
				+ "\n4: Pension account -> Interest is 1.5%");
	}
	
	
	public Account setInterest(String name,Customer c, Double balance, Date date) {
		System.out.println("What type of account is this?");
		printOptions();
		String choice = null;
		try {
			choice = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int decision = Integer.valueOf(choice);
		
		switch(decision) {
		case 1:
			return new SavingsAccount(name, c, balance, date);
		case 2:
			return new DebitAccount(name, c, balance, date);
		case 3:
			return new CreditAccount(name, c, balance, date);
		case 4:
			return new PensionAccount(name, c, balance, date);
		default :
			System.out.println("It seems you have made an invalid choice.\n");
			printOptions();
			setInterest(name,c, balance, date);
			
		}
		return null;
	}
	
	public Account createAccount(Customer c) {
		System.out.println("You have created a new account for customer "+c.getName()+" .");
		System.out.println("What is the name of this account?");
		String name = null;
		try {
			name = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Double balance = setBalance();
		Date date = calendar.getTime();
		Account account = setInterest(name, c, balance, date);
		return account;
		
	}
	
}
