/*
 * @Author Dylan Diedrich
 * @Version 1.0
 * @Since 04/15/2021
 */
public class Plot {

	static Player player;
	
	//All of these are methods that print out story text after the player has progressed far enough
	public static void printBeginning() {
		System.out.println("\nYou are the sole survior of the demon invasion of earth");
		System.out.println("After being infused with special divine powers, it is your responsibility to eradicate the demons left on earth");
		System.out.println("If you fail, the earth will be lost forever, you must not let this happen");
		GameStructure.continueGame();
	}
	
	public static void printPartOneIntro() {
		System.out.println("\nYou managed to narrowly escape from the demons grasps after learning about the invasion, you decided the best place to head is back to your home");
		System.out.println("After getting to your house you see nothing but burning ruins");
		System.out.println("Knowing now that the demons have taken everything away from you, you swear to get your revenege");
		
	}
	
	public static void printPartOneEnd() {
		System.out.println("\nYou were able to overcome the horde of demons who ambushed you!");
		System.out.println("After destroying the demons, you learned of a secret demon base with plans to open a massive portal to the underworld");
		System.out.println("You decide you must make your way to the demon base to stop the portal from opening!");
	}
	
	public static void printPartTwoBeginning() {
		System.out.println("\nYou have made your way through destroyed cities and arrived at the secret demon base ");
		System.out.println("You understand that you are the key to preserving the planet and the remaining survivors");
		System.out.println("You see no signs of any demons, so you enter the base");
	}
	
	public static void printPartTwoEnd() {
		System.out.println("\nAfter clearing the base of demons, you stumble accross the demon portal!");
		System.out.println("After examining the portal, you realize there is no way to destroy it from the outside");
		System.out.println("You realize the only way to close the portal is by going through it...");
	}
	
	public static void printPartThreeBeginning() {
		System.out.println("\nAfter entering the portal to the underworld, you see demons flying across the sky and everything has a hint of red");
		System.out.println("You see all the demons flying to and from a large tower, you decide your best option is to head in that direction");
		System.out.println("You head towards the tower pondering if you have the strength and courage to finish this mission, knowing you might not survive");
		
	}
	
	public static void printPartThreeEnd() {
		System.out.println("\nYou successfully managed to kill the Dark Lord of the Underworld!");
		System.out.println("But it came at a cost...");
		System.out.println("You arrive at the area where you entered the underworld, expecting to see a portal home, but by defeating the dark lord"
				+ "the portal closed and you are trapped in the underworld forever...");
	}
	
	public static void printCredits(Player player) {
		System.out.println("\nCongrats on beating the game " + player.name + " you have successfully saved the earth, but it came at a cost");
		System.out.println("\nGame developed by Dylan Diedrich");
	}
}
