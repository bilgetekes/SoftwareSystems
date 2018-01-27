package ss.week1;

import ss.week1.ThreeWayLampTest;

public class ThreeWayLamp  {
	int settingoflamp;
	int INITIAL = 0;
	
	
	public ThreeWayLamp() {
		this.settingoflamp = INITIAL;
		
	}
	public int getSetting() {
		return settingoflamp;
	}
	public void switchSetting() {
		settingoflamp = (settingoflamp + 1) % 4; 
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
