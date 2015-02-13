package me.subtleoliver.stickmandrawer;

public class Info {
	
	public static String assetspath = "/assets/subtleoliver/Stickman/";
	

	private static byte hat = 1;
	private static byte hatamount = 4;

	public static byte getHat() {
		return hat;
	}
	
	public static byte getHats() {
		return hatamount;
	}

	public static void setHat(byte Hat) {
		Info.hat = Hat;
	}
	
	

}
