package models;

public class Transaction {
	private String name;
	private Double ammount;
	public Transaction () {
	}
	
	private String getName() {
		return name;
	}
	public Double getAmmount() {
		return ammount;
	}
	public Transaction(String name, Double ammount) {
		super();
		this.name = name;
		this.ammount = ammount;
	}
	
	@Override
	public String toString() {
		return  "Name of transaction : "+getName()+" \nTransaction ammount : "+getAmmount();
	
	}
	

}
