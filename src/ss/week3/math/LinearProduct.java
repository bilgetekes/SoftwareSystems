package ss.week3.math;

public class LinearProduct extends Product implements Integrable {
	
	public LinearProduct(Constant c, Function f) {
		    super(c,f);

		
	}
	
	public Function derivative() {
		Function example = function2.derivative();
		Constant f1 = (Constant) this.function1;
		Function result = new LinearProduct(f1,example);
		return result;
		
	}
	

	public Function integral() {
		if(this.function2 instanceof Integrable) {
		Integrable secondpart = (Integrable) this.function2;
		Function f2 = secondpart.integral();
		Constant f1 = (Constant) this.function1;
		Function result = new LinearProduct (f1, f2);
		return result;
		}
		else {
			return null;
		}
	}

}
