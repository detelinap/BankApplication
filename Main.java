
import java.io.IOException;

import models.Bank;
import services.BankServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		BankServiceImpl bankService = new BankServiceImpl();
		bankService.programBegin();
		Bank newBank = bankService.addBank();
		try {
			bankService.choice(newBank);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
