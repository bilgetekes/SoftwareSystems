package ss.week1;
import ss.week1.ThreeWayLamp;

public class ThreeWayLampTest {
	
	private ThreeWayLamp testobject ;
	
	public  ThreeWayLampTest() {
		testobject = new ThreeWayLamp();
	}
	public void threeWayLampTest() {
		lampInitialState();
		lampSettingChange();		
		
	}
	
	private void lampInitialState() {
		System.out.println("lampInitialState:");
		System.out.println("Initial state = " + testobject.getSetting());
	}
	private void lampSettingChange() {
		System.out.println("lampSettingChange:");
		System.out.println("Starting setting =" + testobject.getSetting());
		testobject.switchSetting();
		System.out.println("After 1 change =" + testobject.getSetting());
		testobject.switchSetting();
		System.out.println("After 2 changes =" + testobject.getSetting());
		testobject.switchSetting();
		System.out.println("After 3 changes =" + testobject.getSetting());
	}
}