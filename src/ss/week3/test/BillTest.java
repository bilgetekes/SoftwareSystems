package ss.week3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;
import ss.week3.bill.SysoutPrinter;


class BillTest {
	
	StringPrinter y ;
	Bill withstring;
	Item peynir;
	Item sut;
	class Item implements Bill.Item {
		public String nameofitem;
		public double priceofitem;
		
		
		
		public Item(String name, double price) {
			this.nameofitem= name;
			this.priceofitem = price;
		}
		
		public String toString() {
			return "This item is named" + this.nameofitem + "and costs" +
		this.priceofitem ;
		}
		
		public double getAmount() {
			return this.priceofitem;
		}
		
	}

	@BeforeEach
	void setUp() throws Exception {
		
		 y = new StringPrinter();
		 withstring = new Bill (y);
		 peynir = new Item("cheese", 2.00);
		 sut = new Item ("milk", 5.00);
		
	}

	@Test
	void testAddItem() {
		withstring.addItem(peynir);
		assertEquals(2.00 , withstring.getSum());
		withstring.addItem(sut);
		assertEquals(7.00, withstring.getSum());
	}
	
	@Test
	void testClose() {
	withstring.addItem(peynir);
	withstring.close();
	}
	@Test
	void testGetSum() {
		withstring.addItem(sut);
		withstring.addItem(peynir);
		assertEquals(withstring.sumofbill, withstring.getSum());
	}
	
	
}
