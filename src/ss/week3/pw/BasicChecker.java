package ss.week3.pw;

public class BasicChecker implements Checker{
	public final static String INITPASS = "blabla123";

	

	@Override
	public String generatePassword() {
		return INITPASS;
	}

	
}
