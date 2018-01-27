package ss.week1;

public class DollarsAndCentsCounter {
	public int mydollars;
	public int mycents;
	
	public int dollars() {
		return mydollars;
		}
	public int cents() {
		return mycents;
	}
	public void add( int dollar , int cent) {
		int temp = mycents; 
		mycents = (cent + mycents) % 100 ;
		mydollars = dollar + mydollars + (temp + cent) /100;
	}
	public void reset() {
		mydollars = 0;
		mycents = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
