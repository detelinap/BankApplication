package bankpck;

public class Main {

	public static void main(String[] args) {
		
		Transaction t = TransactionService.createTransaction();
			System.out.println(t.toString());
	}

}
