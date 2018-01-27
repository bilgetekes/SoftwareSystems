package ss.week3.bill;

public class StringPrinter implements Printer {
	
	public String result;

	@Override
	public void printLine(String text, double price) {
		result = result + format(text,price);
	}
	
	public String getResult() {
		return result;
	}

}
