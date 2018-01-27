package ss.week3.math;

public class Exponent implements Integrable{
	public int exponent;

	
	//constructor
	public Exponent(int givenexponent) {
		this.exponent = givenexponent;
	}

	
	public double apply(double argument) {
		return Math.pow(argument,this.exponent);
	}


	public Function derivative() {
		int newexponent = this.exponent -1;
	    Function otherpart = new Exponent(newexponent);
	    Constant inttoconstant = new Constant(this.exponent);
		Function combined = new LinearProduct(inttoconstant , otherpart);
		return combined;
	}
	
	public String toString() {
			return "x ^ " + this.exponent	;
	}
	
	public Function integral() {
        Constant newexponent = new Constant(1.0/(this.exponent+1)); 	
		Function firstpart = new Exponent (this.exponent+1);
		LinearProduct result = new LinearProduct( newexponent , firstpart);
		return result;
	}
}
