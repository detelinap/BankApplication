package bankpck;

import bankpck.models.Bank;
import bankpck.services.BankService;

public class Main {

	public static void main(String[] args) {
		
		Bank newBank = BankService.addBank();
		
		BankService.returnBankCustomer("John", newBank);
		
	}

}
