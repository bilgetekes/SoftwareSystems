package ss.week4;


import ss.week3.math.Constant;
import ss.week3.math.Exponent;
import ss.week3.math.Function;
import ss.week3.math.Integrable;
import ss.week3.math.LinearProduct;
import ss.week3.math.Sum;

public class Polynomial implements Integrable {
	
	public LinearProduct[] result ;

	public static void main(String[] args) {
		double arrayss[]= {0.0,1.0,2.0,3.0};
	    Polynomial trial = new Polynomial(arrayss);
		System.out.println( trial.integral());
	}
	//constructor
	public Polynomial(double[] array) {
		result = new LinearProduct[array.length];
		for(int i = 0 ; i < array.length ; i++) {
		Function a = new Exponent(i);
		Constant b  = new Constant(array[i]);
		this.result[i]= new LinearProduct(b,a);
		}
		
		
	}

	@Override
	public double apply(double argument) {
		double result = 0;
		for (int i =0; i< this.result.length ; i++) {
			result = result +this.result[i].apply(argument);
		}
		return result;
	}

	@Override
	public Function derivative() {
		Function result = this.result[0].derivative();
		for (int i =1; i< this.result.length ; i++) {
			result =  new Sum(result, this.result[i].derivative());
			}
		return result;
	}

	@Override
	public Function integral() {
		Function result = this.result[0].integral();
		for (int i =1
				; i< this.result.length ; i++) {
			result =  new Sum(result, this.result[i].integral());
			System.out.println(this.result[i].toString());
			System.out.println(this.result[i].integral().toString());
			}
		return result;
	}

}
