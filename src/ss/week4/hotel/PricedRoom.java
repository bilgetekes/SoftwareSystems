package ss.week4.hotel;

public class PricedRoom extends ss.week2.hotel.Room implements ss.week3.bill.Bill.Item{
	
	public int numberOfRoom;
	public double priceOfRoom;
	public double priceOfSafe;
	public PricedSafe safe;
	
	
	/* constructor that receives a room number a room price and the
	 * cost of the safe. Also creates PricedSafe 
	 */
	public PricedRoom (int roomnumber, double roomprice , double costsafe) {
		super (roomnumber, new PricedSafe(costsafe));
		this.priceOfRoom = roomprice;
		
	}

	
	public String toString() {
		return "This room has price" + this.getAmount();
	}
	@Override
	public double getAmount() {
		return this.priceOfRoom;
	}

}
