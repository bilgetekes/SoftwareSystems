package ss.week3.bill;

public class SysoutPrinter implements Printer{
	
	

	@Override
	public  void printLine(String text, double price) {
		System.out.println(format(text,price));
		
	}

	public static void main(String[] args) {
	SysoutPrinter SysoutPrinter1=	new SysoutPrinter();
	  SysoutPrinter1.printLine("Test", 0.1); 
		
	}
	
	
}
