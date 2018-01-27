package ss.week2.hotel;


public class Hotel {
	private Room firstroomofhotel;
	private Room secondroomofhotel;
	private Password checkinpassword;
	private String name  ;
	//constructor
	public Hotel(String x) {
		checkinpassword = new Password();
		firstroomofhotel = new Room(101);
		secondroomofhotel = new Room(102);
		name = x ;
		
	}
	//queries
	//@pure
	/**
	 * gets called on hotel 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	//commands
	
	// checkin that creates a new guest with the name given and connects it to a room if password is correct and
	// there isnt a guest already with that name and hotel is not full
	//@ ensures \result != null;
	public Room checkIn(String triedpass, String nameofguest) {
		Room atananoda;
		if (checkinpassword.testWord(triedpass) & (getFreeRoom()!= null) & getRoom(nameofguest) == null) {
			Guest newguest = new Guest(nameofguest);
			atananoda = getFreeRoom();;
			newguest.checkin(atananoda);
			atananoda.setGuest(newguest);
		
		}
		else {
			atananoda = null;
		}
		return atananoda;		
	}
	//Checks out by using the name of the guest the guest is deattached from room and room from guest and the safe is deactivated
	public void checkOut(String guestsname) {
		if (guestnametoguest(guestsname)!= null) {
			Guest x =guestnametoguest(guestsname);
			Room y = x.getRoom();
			x.checkout();
			y.getSafe().deactivate();	
			y.setGuest(null);
			
		}
		else {
			
		}
		
	}
	public Guest guestnametoguest(String x) {
		Guest bulunan = null;
		if(firstroomofhotel.getGuest() != null && firstroomofhotel.getGuest().getName().equals(x)) {
			bulunan = firstroomofhotel.getGuest();
		}
		else if(secondroomofhotel.getGuest() != null && firstroomofhotel.getGuest().getName().equals(x)) {
			bulunan = secondroomofhotel.getGuest();
		}
		return bulunan;
	}
	// finds and returns it if there is free room
	public Room getFreeRoom() {
		Room free = null;
		if (firstroomofhotel.getGuest() == null) {
			free =firstroomofhotel;
		}
		else if (secondroomofhotel.getGuest() == null) {
			free = secondroomofhotel;
		}
		else if (firstroomofhotel.getGuest()!= null & secondroomofhotel.getGuest()!=null) {
			free = null;
		}
		return free;
	}
	// finds and returns room the guest has
	public Room getRoom(String guestname) {
		Room result = null;
		Guest asil = guestnametoguest(guestname);
		if (asil  != null ) {
			 result =asil.getRoom();
		}
		else {
			 result = null;
		}
		return result;
		
	}
	public Password getPassword() {
		return this.checkinpassword;
	}
	public String toString() {
		String x = null;
		if( firstroomofhotel.getGuest() != null && secondroomofhotel.getGuest()!= null) {
		 x = "Firstroomofhotel has the guest"+ firstroomofhotel.getGuest().getName()
					+ "its safe is " + firstroomofhotel.getSafe().isOpen() + "and " +firstroomofhotel.getSafe().isActive() +
					"Secondroomofhotel has the guest"+ secondroomofhotel.getGuest().getName()
					+ "its safe is " + secondroomofhotel.getSafe().isOpen() + "and " +secondroomofhotel.getSafe().isActive();
		}else if (firstroomofhotel.getGuest()!= null) {
			x = "Firstroomofhotel has the guest"+ firstroomofhotel.getGuest().getName()
					+ "its safe is " + firstroomofhotel.getSafe().isOpen() + "and " +firstroomofhotel.getSafe().isActive() ;
		}else if(secondroomofhotel.getGuest()!= null) {
			 x = 	"Secondroomofhotel has the guest"+ secondroomofhotel.getGuest().getName()
					+ "its safe is " + secondroomofhotel.getSafe().isOpen() + "and " +secondroomofhotel.getSafe().isActive();
		}
		else {
			 x = "Firstroomofhotel has no guest its safe is " + firstroomofhotel.getSafe().isOpen() + "and " +firstroomofhotel.getSafe().isActive() +
					"Secondroomofhotel has no guest its safe is " + secondroomofhotel.getSafe().isOpen() + "and " +secondroomofhotel.getSafe().isActive();
		}
		
		return x;
	}
	

}
