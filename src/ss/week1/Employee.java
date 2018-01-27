package ss.week1;

public class Employee {
	private int hours;
	private int rate;
	
	public int pay() {
		int maas = 0;
		if (hours <= 40) {
			maas = hours*rate;
		}
		else if (hours >40) {
			maas = (int) (40*rate + ((hours -40 )* (1.5*rate)));	
		}
		return maas;
	}
	
	public static void main(String[] args) {
		
	}
}
