package prac2;

public class ThreeWayLampTest {
	
	public static void main(String[] args) {
		ThreeWayLamp lamp = new ThreeWayLamp();
		System.out.println(lamp.getState());
		lamp.switchSetting();
		lamp.switchSetting();
		System.out.println(lamp.getState());
		lamp.switchSetting();
		lamp.switchSetting();
		System.out.println(lamp.getState());
		lamp.switchSetting();
		System.out.println(lamp.getState());
	}

}
