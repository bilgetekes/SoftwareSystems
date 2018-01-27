package ss.week3.pw;

public class Password {
	public static final String INITIAL = "123";
	public String thepassword ;
	public Checker checker;
	public String factoryPassword;
	
	//constructor
	public Password(Checker x) {
		this.thepassword = x.generatePassword() ;
		this.checker = x;
	}
	
	public Password() {
		this(new BasicChecker());
	}
	
	public Boolean acceptable(String triedpassword) {
		return this.checker.acceptable(triedpassword);
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
		} else {
			temp = false;
		}
		return temp;
	
	}
	//queries
	public Checker getChecker() {
		return this.checker;
	}
	
	public String getFactoryPassword() {
		return this.factoryPassword;
	}
	public void setFactoryPassword() {
		this.thepassword = "ala123";
	}
	
	
	
	
}
