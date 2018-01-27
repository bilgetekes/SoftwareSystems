package ss.week3.bill;



public interface Printer {

	// returns a formatted line listing the item and price 
	default public String format(String text, double price) {
		return String.format("%-50s %9.2f", text,price);
	}
	
	//uses method format to send combination of text and price to the printer
	public void printLine(String text, double price);
	
	
	
}
