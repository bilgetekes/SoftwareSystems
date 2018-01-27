package ss.week3.math;

public class Constant implements Integrable {
	
	public final double CONSTANT;
	
	//constructor
	public Constant(double givenconstant) {
		this.CONSTANT = givenconstant ;
	}
	//main method
	public static void main(String[] args) {
		Print.print(new Constant(2.0));		
	}
	
	//methods
	
	// returns the constant
	public double apply(double arg) {
		return CONSTANT;
	}
	// gives the derivative of a constant which is 0
	public Function derivative() {
		Function x = new Constant(0.0);
		return x;		
	}
	// gives verbal description of 
	public String toString() {
		return "" + CONSTANT;
	} 
	
	public Function integral() {
		Function result = new Product( this , new Identity());
		return result;
	}
	
	

}
