package ss.week4.hotel;

public class PricedSafe extends ss.week2.hotel.Safe implements ss.week3.bill.Bill.Item{

	
	public double priceOfSafe;
	
	
	
	
	
	/*constructor with parameter as double that becomes
	 * the price of the safe created
	 */
	public PricedSafe(double givenprice) {
		this.priceOfSafe = givenprice;
	}
	
	/*
	 * method that includes price of safe
	 */
	public String toString() {
		return "This safe has a price of" + this.getAmount();		
	}
	
	
	public double getAmount() {
		return this.priceOfSafe;
	}

}
