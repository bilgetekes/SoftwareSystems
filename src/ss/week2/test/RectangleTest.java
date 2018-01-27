package ss.week2.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.Rectangle;

public class RectangleTest {
	// creating test variables 
	private Rectangle denemebir;
	private Rectangle denemeiki;
	@Before
	public void setUp() {
		denemebir = new Rectangle(3,2);
		denemeiki = new Rectangle(5,4);
	}
	@Test
	public void testLength() {
		assertEquals (3 ,denemebir.length());
		assertEquals (5, denemeiki.length());
	}
	@Test
	public void testWidth() {
		assertEquals (2, denemebir.width());
		assertEquals(4,denemeiki.width() );
	}
	@Test
	public void testArea() {
		assertEquals (6, denemebir.area());
		assertEquals(20,denemeiki.area() );
	}
	@Test
	public void testPerimeter() {
		assertEquals (10, denemebir.perimeter());
		assertEquals(18,denemeiki.perimeter() );
	}
	

}
