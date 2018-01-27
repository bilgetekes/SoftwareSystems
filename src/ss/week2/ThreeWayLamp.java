package ss.week2;

import ss.week1.ThreeWayLampTest;


public class ThreeWayLamp  {
	lampsettings settingoflamp;
	

	public enum lampsettings{ OFF,LOW,MEDIUM,HIGH}
	public ThreeWayLamp() {
		this.settingoflamp = lampsettings.OFF;
		
	}
	//@ pure
	public lampsettings getSetting() {
		return settingoflamp;
	}
	//@ ensures getSetting()==lampsettings.LOW==> \old(getSetting())== lampsettings.OFF ;
	//@ ensures getSetting()==lampsettings.MEDIUM==> \old(getSetting())== lampsettings.LOW ;
	//@ ensures getSetting()==lampsettings.HIGH==> \old(getSetting())== lampsettings.MEDIUM ;
	//@ ensures getSetting()==lampsettings.OFF==> \old(getSetting())== lampsettings.HIGH ;
	
	public void switchSetting() {
		switch (settingoflamp) {
		case OFF: 
			settingoflamp = lampsettings.LOW;
			break;
		case LOW:
			settingoflamp = lampsettings.MEDIUM;
			break;
		case MEDIUM:
			settingoflamp = lampsettings.HIGH;
			break;
		case HIGH:
			settingoflamp = lampsettings.OFF;
			break;
		}
	}
	public static void main(String[] args) { 
		ThreeWayLamp example = new ThreeWayLamp();
		ThreeWayLampTest testobject = new ThreeWayLampTest();
		testobject.threeWayLampTest();
	/*System.out.println(example.getSetting());
		example.switchSetting();
		System.out.println(example.getSetting());
		example.switchSetting();
		System.out.println(example.getSetting());*/
		
	}
    
}
