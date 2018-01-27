package ss.week2.hotel;
 /** @author Bilge Tekes
   */
public class Guest {
	public String guestname;
	public Room guestsroom = null ;
	private Room firstroomofhotel;
	private Room secondroomofhotel;
	
	public String toString(Guest x) {
		return  x +" guest stays in " + x.getRoom() ;
		
	}
	
	/* constructor with name as parameter which sets 
	 *  the given name as the name of the guest
	 */
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
		
	// checks from the name of the guest as a string to find 
	public Guest guestnametoguest(String x) {
		Guest bulunan = null;
		if(firstroomofhotel.getGuest().getName().equals(x)) {
			bulunan = firstroomofhotel.getGuest();
		}
		else if(secondroomofhotel.getGuest().getName().equals(x)) {
			bulunan = secondroomofhotel.getGuest();
		}
		return bulunan;
	}
	
	
	
	

}
