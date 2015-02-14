package me.subtleoliver.stickmandrawer;

public class Info {
	
	public static String assetspath(String path){
		return "/assets/subtleoliver/Stickman/" + path;
	}
	
	//Hats
		private static byte hat = 1;
		private static byte hatamount = 4;
	//Shirts
		
	//Pants
		
	//Shoes
		
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
