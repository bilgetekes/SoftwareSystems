package ss.week2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week1.Password;
import ss.week2.hotel.Safe;

class SafeTest {
	
	private Safe safebir;

	@BeforeEach
	void setUp()  {
		safebir = new Safe();
				
	}
	
	@Test
	void activatetestrightpass() {
		safebir.activate("123");
		assertEquals (true , safebir.isActive());
	}
	
	@Test
	void activatetestwrongpass() {
		safebir.activate("124");
		assertEquals (false , safebir.isActive());
	}
	
	@Test
	void deactivatetest() {
		safebir.deactivate();
		assertEquals (false , safebir.isActive());
	}
	
	@Test
	void opentestrightpass() {
		safebir.active = true;
		safebir.open("123");
		assertTrue(safebir.isOpen());
	}
	
	@Test
	void opentestwrongpass() {
		safebir.active = true;
		safebir.open("124");
		assertEquals (false , safebir.isOpen());
	}
	@Test
	void closetest() {
		safebir.close();
		assertEquals (false , safebir.isOpen());
	}
	
	@Test
	void isActivetestfalse() {
		safebir.active =false;
		assertEquals (false , safebir.isActive());
	}
	@Test
	void isActivetesttrue() {
		safebir.active =true;
		assertEquals (true , safebir.isActive());
	}
	@Test
	void isOpentestfalse() {
		safebir.open =false;
		assertEquals (false , safebir.isOpen());
	}
	@Test
	void isOpentesttrue() {
		safebir.open = true;
		assertEquals (true , safebir.isOpen());
	}
	
	
	

}
