package me.subtleoliver.stickmandrawer;

public class Info {

	public static String assetspath(String path) {
		return "/assets/subtleoliver/Stickman/" + path;
	}

	// Hats
		public static short hat = 0;
	// Shirts
		private static short shirt = 1;
		private static short shirtamount = 2;

	// Pants

	// Shoes

	// Hats
		public static short getHat() {
			return (short) (hat);
		}


		public static void setHat(short Hat) {
			Info.hat = Hat;
		}

	// Shirts
		public static short getShirt() {
			return shirt;
		}

		public static short getShirts() {
			return shirtamount;
		}

		public static void setShirt(byte Shirt) {
			Info.shirt = Shirt;
		}


		public static void nextHat() {
			if(Info.getHat() < Drawer.hats.size()-1) hat++; else hat =0;
		}

}
