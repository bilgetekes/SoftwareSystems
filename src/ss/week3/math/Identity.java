package ss.week3.math;

public class Identity implements Integrable{
	
	
	//constructor
	public Identity() {			
	}
	//Methods
	
	public double apply(double argument) {
		return argument;		
	}

	public Function derivative() {
		Function x = new Constant(1.0);
		return x;
	}
	
	public String toString() {
		return "x";
	}
	
	public Function integral() {
		Exponent ustuiki = new Exponent ( 2);
		Constant birboluiki = new Constant( 0.5);
		Function result = new Product(birboluiki,ustuiki );
		return result;
	}

}
