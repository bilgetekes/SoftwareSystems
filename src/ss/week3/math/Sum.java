package ss.week3.math;

public class Sum  implements Integrable{

	public Function function1;
	public Function function2;
	
	//constructor 
	public Sum(Function f1, Function f2) {
		this.function1 = f1;
		this.function2 = f2;
	}
	
	public Function derivative() {
		Sum a  = new Sum(this.function1.derivative(), this.function2.derivative());
		return a;
	}

	public double apply(double arguments) {
		return this.function1.apply(arguments) + this.function2.apply(arguments);
	}
	
	public String toString() {
		return "" + this.function1 +"+" +this.function2;
	}
	
	public Function integral() {
		if (this.function1 instanceof Integrable && this.function2 instanceof Integrable) {
		Integrable f1 = (Integrable) this.function1;
		Integrable f2 = (Integrable) this.function2;
		Sum result = new Sum(f1.integral(),f2.integral());
		return result;
		}
		else {
		return null;
		}
	}
}
