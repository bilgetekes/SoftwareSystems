package ss.week3.pw;

public interface Checker {
	
	
    //@ ensures \result instance of Boolean;
	//@ requires triedPassword != null;
	default public Boolean acceptable(String triedpassword) {
		return triedpassword.length() >= 6 && !triedpassword.contains(" ");
	}
	public String generatePassword();
}
