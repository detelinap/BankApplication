package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Date;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import interfaces.AccountService;
import models.*;

import javax.swing.*;

public class AccountServiceImpl implements AccountService{

	static BufferedReader reader = 
			  new BufferedReader(new InputStreamReader(System.in));
	
	Calendar calendar = Calendar.getInstance();
	
	public Double setBalance() {
		Double balance;
		System.out.println("Please set account balance");
		String newBalance = null;
		try {
			newBalance = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		balance = Double.valueOf(newBalance);
		return balance;
	}
	
	public void printAccountOptions() {
		System.out.println("Your options are:"
				+ "\n1: Savings account -> Interest is 1%"
				+ "\n2: Debit account -> Interest is 0.5%"
				+ "\n3: Credit account -> Interest is 2% "
				+ "\n4: Pension account -> Interest is 1.5%");
	}
	
	
	public Account setInterest(String name,Customer c, Double balance, Date date) {
		System.out.println("What type of account is this?");
		printAccountOptions();
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
			printAccountOptions();
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

	public double calculateInterest(Account a) {
		double p, r, t, sinterest;
		System.out.println("Starting sum : ");
		p = a.getBalance();
		System.out.println(p);
		System.out.println("Rate of interest : ");
		r =  a.getInterest();
		System.out.println((r*100)+"%");
		System.out.println("Enter the Time period : ");
		String time = null;
		try {
			time = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		t = Double.valueOf(time);
		sinterest = p*(r*t)+p;
		System.out.println("Simple Interest is: " +sinterest);
		return sinterest;
	}

	public Account chooseAccount(Customer c) {
		System.out.println("These are all the accounts for "+c.getName()+" .\nPlease choose one.");
		String choice = null;
		for (Account account : c.getAccounts()){
			System.out.println(account.getName());
		}
		try {
			 choice = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Account account : c.getAccounts()){
			if (account.getName().equalsIgnoreCase(choice)){
				return account;
			}
		}
		System.out.println("It seems you have not chosen a correct account. Please try again");
		Account a = chooseAccount(c);
		return a;
	}

	public Double valueOfAccountTransactions(Account a) {
		Double sum = 0.0;
		for (Transaction t : a.getTransactions()) {
			sum+=t.getAmmount();
		}
		return sum;
	}


}
