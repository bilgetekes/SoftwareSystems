package ss.week4.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week4.Polynomial;

class PolynomialTest {
	double array[];
	Polynomial trial;
	int constant;

	@BeforeEach
	void setUp() throws Exception {
		array= new double[]{0.0,1.0,2.0,3.0};
	    trial = new Polynomial(array);
	    
		
	}

	@Test
	void testapply() {
		assertEquals(0, trial.apply(0.0));
		assertEquals(34, trial.apply(2.0));
	}
	
	@Test
	void testderivative() {
		assertEquals(45, trial.derivative().apply(2.0));
	}
	
	@Test
	void testintegral() {
		System.out.println(trial.integral());
		assertEquals(19.333333333333332, trial.integral().apply(2.0));
	}
}
