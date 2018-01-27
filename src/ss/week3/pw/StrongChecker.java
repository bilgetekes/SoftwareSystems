
package ss.week3.pw;
import java.lang.Character;

public class StrongChecker  extends BasicChecker  {
	public static final String INIT = "sss123";


	public Boolean acceptable(String triedpassword) {
		boolean temp = false;
		if ( super.acceptable(triedpassword) &&
		Character.isLetter(triedpassword.charAt(0)) && 
		Character.isDigit(triedpassword.charAt(triedpassword.length()-1))) {
			temp = true;
		}
		else {
			temp = false ;
		}
		return temp;
	}


	public String generatePassword() {
		return INIT;
	}

}
