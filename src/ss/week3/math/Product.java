package ss.week3.math;

public class Product implements Function{
	
	public Function function1;
	public Function function2;

    //constructor 
	public Product(Function f1 , Function f2) {
		this.function1 = f1;
		this.function2 = f2;
	}
	
	//methods
	
	public double apply(double zargument) {
		return this.function1.apply(zargument) * this.function2.apply(zargument);
	
	}

	
	public Function derivative() {
	 Function part1 = new Product(this.function1.derivative() , this.function2);
	 Function part2 = new Product (this.function2.derivative(), this.function1);
	 Function combined = new Sum (part1 , part2);
	 return combined;
	}
	
	public String toString() {
		return this.function1 + "*" + this.function2 ;
	}

}
