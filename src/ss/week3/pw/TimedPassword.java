package ss.week3.pw;
import java.lang.System;

public class TimedPassword extends Password{
    public long validTime;
    public boolean isexpired;
    public long starttime;
    
    
    
    public TimedPassword(long givenvalid) {
    	this.validTime =givenvalid;
    	this.isexpired =false;
    	this.starttime = System.currentTimeMillis();
    }
    
    public TimedPassword() {
    	this(100000000);
    }
    // checks if it is expired 
    public boolean isExpired() {
    	return (System.currentTimeMillis() - this.starttime > this.validTime ) ;    	
    }
    
    @Override
    // so the start time gets updated each time the password is changed
    public boolean setWord(String oldpass, String newpass) {
    	boolean temp = false;
    	if (super.setWord(oldpass, newpass)) {
    		this.starttime = System.currentTimeMillis();
    		temp = true;
    	}
    	return temp;
    }
}
