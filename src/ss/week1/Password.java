package ss.week1;

public class Password {
	public static final String INITIAL = "123";
	public String thepassword ;

	public Password() {
		this.thepassword  = INITIAL;
	}
	public Boolean acceptable(String triedpassword) {
		boolean temp = false;
		if ( triedpassword.length() >= 6 && triedpassword.contains(" ")== false) {
			temp = true;
		}
		else {
			temp = false ;
		}
		return temp;
	}
	
	public Boolean testWord (String triedpassword) {
		boolean temp = false;
		if (this.thepassword.equals(triedpassword)) {
			temp = true;
		}
		else {
			temp = false;
		}
		return temp;
	}
	public boolean setWord (String oldpass, String newpass) {
		boolean temp = false;
		if(oldpass.equals(this.thepassword)&& acceptable(newpass) == true) {
			this.thepassword = newpass;
			temp = true;
		}
		else {
			temp = false;
		}
		return temp;
	}
	
	
}
