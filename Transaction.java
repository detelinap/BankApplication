package bankpck;

public class Transaction {
	private String name;
	private Double ammount;
	public Transaction () {
	}
	
	private String getName() {
		return name;
	}
	private Double getAmmount() {
		return ammount;
	}
	protected Transaction(String name, Double ammount) {
		super();
		this.name = name;
		this.ammount = ammount;
	}
	
	@Override
	public String toString() {
		return  "Name of transaction : "+getName()+" \nTransaction ammount : "+getAmmount();
	
	}
	

}
