package ss.week1;

public class Student {
	int score ;
	public static Boolean student(int score) {
		Boolean result = null;
		if (score >= 70) {
			result = true;
		} 
		else if (score < 70) {
			result = false;
		}
		return result;
	} 
	public static void main(String[] args) {
		System.out.println(student(50));
		// TODO Auto-generated method stub

	}
	

}
