package ss.week3.bill;

public class Bill {
	
	public Printer printerofchoice;
	public Bill specbill;
	public String billo;
	public double sumofbill;
	
	public Bill(Printer printer) {
		this.printerofchoice = printer;
	}
	
	public void addItem(Bill.Item item) {
		this.billo = this.billo + item.toString();	
		this.sumofbill = this.sumofbill + item.getAmount();
	}
	
	public void close() {
		this.printerofchoice.printLine(this.billo,this.getSum() );
	}
	
	public double getSum() {
		return this.sumofbill;
		
	}
	
	//interface
	public interface Item{
		
		

		
		
	  public double getAmount() ;
		
	}

}
