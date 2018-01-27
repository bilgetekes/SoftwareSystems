package ss.week2.hotel;

public class Safe {
	
	//@ public invariant (\forall boolean active; \result == true || \result = false); 
	//@ public invariant (\forall boolean open; \result == true || \result = false);
   public boolean active;
   public boolean open;
   public /*@ non_null @*/ Password safesPassword;

   //main method
   public static void main(String[] args) {
	   
	   Safe deneme = new Safe();
	   deneme.activate(null);
	   
}
   //constructor
   public Safe() {
	   this.active = false;
	   this.open = false;
	   this.safesPassword = new Password();
   }
   // commands
   //@ requires triedpass != null ;
   //@ (\old(isActive()) || getPassword().testWord(triedpass)) ==> isActive();
   // activates safe
   public void activate(String triedpass) {
	   assert triedpass != null ;
	   if ((safesPassword.testWord(triedpass))) {
		   active = true;
	   }
	   else {		   
		   active = false;
	   }
   }   
	// closes safe and deactivates it  
   //@ ensures active == false && open == false;
   
	public void deactivate () {
		active = false;
		open = false;
	}   
	// opens safe if it is active and pass given is correct
	 //@ requires toOpenPass != null ; 
	public void open (String toOpenPass) {
		assert toOpenPass != null: " Given variable is null!";
		if((safesPassword.testWord(toOpenPass))  & active == true) {
			open = true;
		}
		else {
			open = false;
		}
	}
	//closes safe doesn't change activity
	//@ ensures !isOpen();
	public void close () {
		open = false;
		}
	// queries
	
	//returns active status
	//@ pure	
	public boolean isActive() {
		return active;
	}
	// returns open status
	//@ pure
	public boolean isOpen() {
		return open;
	}
	// returns pass of safe
	//@ pure
	public Password getPassword() {
		return safesPassword;
	}
	   
	  

}
