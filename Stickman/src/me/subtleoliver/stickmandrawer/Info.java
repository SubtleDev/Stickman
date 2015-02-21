package me.subtleoliver.stickmandrawer;

public class Info {

	public static String assetspath(String path) {
		return "/assets/subtleoliver/Stickman/" + path;
	}

	// Hats
		private static byte hat = 1;
		private static byte hatamount = 4;
	// Shirts
		private static byte shirt = 1;
		private static byte shirtamount = 2;

	// Pants

	// Shoes

	// Hats
		public static byte getHat() {
			return hat;
		}

		public static byte getHats() {
			return hatamount;
		}

		public static void setHat(byte Hat) {
			Info.hat = Hat;
		}

	// Shirts
		public static byte getShirt() {
			return shirt;
		}

		public static byte getShirts() {
			return shirtamount;
		}

		public static void setShirt(byte Shirt) {
			Info.shirt = Shirt;
		}

}
