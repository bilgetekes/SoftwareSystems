package ss.week1.hotel;
 /** @author Bilge Tekes
   */
public class Guest {
	public String guestname;
	public Room guestsroom = null ;
	
	public String toString(Guest x) {
		return  x +" guest stays in " + x.getRoom() ;
		
	}
	public Guest(String name){
		this.guestname = name;
	}
	public String getName() {
		return guestname;
	}
	public Room getRoom() {
		return guestsroom;
	}
	/** @return boolean according to if check in was completed right
	 * @param the room of the guest is roomnumber*/
	public Boolean checkin(Room roomnumber) {
		Boolean result = null;
		if (guestsroom == null && roomnumber.getGuest()==null) {
		     guestsroom = roomnumber;
		     roomnumber.setGuest(this);
		     result = true;
		     }
		else {
			result = false;
		}
		return result;	
	}
	
	public Boolean checkout() {
		Boolean result = null;
		if (guestsroom != null) {
			guestsroom.setGuest(null);
			guestsroom = null;
			
			result = true;
		}
		else{
			
			result = false;
		}
		return result;
	}
	
	
	

}
