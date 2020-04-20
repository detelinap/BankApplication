package bankpck;

public class Main {

	public static void main(String[] args) {
		
		Bank newBank = BankService.addBank();
		
		BankService.returnBankCustomer("John", newBank);
		
	}

}
