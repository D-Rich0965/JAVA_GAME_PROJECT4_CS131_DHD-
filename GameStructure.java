/*
 * @Author Dylan Diedrich
 * @Version 1.0
 * @Since 04/15/2021
 */
import java.util.Scanner;

public class GameStructure {
	static Scanner scr = new Scanner(System.in);
	
	static Player player;
	static Enemy demon;
	
	public static boolean isRunning;
	//Arrays to hold encounter names and demon names
	public static String[] encounters = {"Fight", "Ambush", "Battle", "Rest"};
	public static String[] demons = {"Imp", "Mancubus", "Cacodemon", "Archvile", "Cyber Demon", "Tyrant"};
	
	public static int place = 0, part = 1;
	public static String[] places = {"Earth","Louisville Kentucky","UnderWorld", "Dark Lord's Tower"};
	
	//method used to get input from user
	public static int readInt(String prompt, int userSelection) {
		int userInput;
		
	do {
			System.out.println(prompt);
			try {
				userInput = Integer.parseInt(scr.next());
					}catch(Exception e) {
						userInput = -1;
				System.out.println("Please enter an integer");
			}
	}while(userInput < 1 || userInput > userSelection);
		return userInput;
	}
	
	//method that calls randomBattle method
	public static void randomEncounter() {

			randomBattle();
		}
	
	//method to pause the game until user is ready to continue
	public static void continueGame() {
		System.out.println("\nPress a button to continue");
		scr.next();
	}
	
	//Method for introduction to the game and name creation
	public static void startGame() {
		boolean nameSet = false;
		String name;
		
		System.out.println("\nDOOM: Welcome To the UnderWorld");
		
		do {
			System.out.println("Enter Character Name");
			name = scr.next();
			System.out.println("\nYou have chosen " + name + "\n Is this correct?");
			System.out.println("(1) Yes!");
			System.out.println("(2) No, let me change my name!");
			int userInput = readInt("-> " , 2);
			if(userInput==1)
				nameSet = true;
		}
		while(!nameSet);
		
		Plot.printBeginning();
			
		player = new Player(name);
		
		Plot.printPartOneIntro();
		
		isRunning=true;
		
		gameLoop();
	}
	
	//method that checks the part of the story and prints out story text and types of available enemies
	public static void checkPart() {
		if(player.experience >= 25 && part == 1) {
		
		part = 2;
		place = 1;
		
		Plot.printPartOneEnd();
		
		player.chooseAbility();
		
		Plot.printPartTwoBeginning();
		
		
		demons[0] = "Archvile";
		demons[1] = "Robotic Mancubus";
		demons[2] = "Cacodemon";
		demons[3] = "Stone Imp";
		demons[4] = "Cyber Demon";
		demons[5] = "Tyrant";
		
		encounters[0] = "Battle";
		encounters[1] = "Battle";
		encounters[2] = "Battle";
		encounters[3] = "Battle";
		
	}
	else if(player.experience >= 50 && part == 2) {
		
		part = 3;
		place = 2;
		
		Plot.printPartTwoEnd();
		player.chooseAbility();
		Plot.printPartThreeBeginning();
		
		demons[0] = "Flying Mancubus";
		demons[1] = "Earth Imp";
		demons[2] = "Cacodemon";
		demons[3] = "High Archvile";
		demons[4] = "Cacodemon";
		demons[5] = "Giant Tyrant";
		
		encounters[0] = "Battle";
		encounters[1] = "Battle";
		encounters[2] = "Battle";
		encounters[3] = "Battle";
		
		finalFight();
	}
	else if(player.experience >= 100 && part ==3){
		
		part = 4;
		place = 3;
		
		if(player.lifePoints>0) {
			Plot.printPartThreeEnd();
		}
		Plot.printCredits(player);
	}
}
	
		

	//method that progresses the story until the final fight
	public static void continueStory() {
	checkPart();
		
		if(part !=3)
			randomEncounter();
	}
	
	//Method to print the stats of the player in a visible menu
	public static void characterStats() {
		System.out.println("\n---Character Stats---");
		System.out.println(player.name + "\tLife Points: " + player.lifePoints + "/" +player.maxLifePoints);
		System.out.println("Experience: " + player.experience);
		System.out.println("Number of MedKits remaining " + player.medKits);
		
		if(player.numOffensiveAbilities>0) {
			System.out.println("Your offensive abilities are: " + player.offensiveAbilities[player.numOffensiveAbilities-1]);
		
	}
		if(player.numDefensiveAbilities > 0) {
			System.out.println("Your defensive abilites are: " + player.defensiveAbilities[player.numDefensiveAbilities-1]);
		}
		continueGame();
	}
	
	//Method to print a new battle
	public static void randomBattle() {
		System.out.println("\nYou encounter an evil demon, prepare to fight!");
		battle(new Enemy(demons[(int)(Math.random()*demons.length)],player.experience));
		
	}
	/*
	 * This is the method that serves most of the game, functions as a loop that repeats battles
	 * Gives user multiple options and then reacts based on user selection
	 */
	public static void battle(Enemy demons) {
		
	while(true) {
		System.out.println(demons.name + "\nlifePoints: " + demons.lifePoints + "/" + demons.maxLifePoints);
		System.out.println(player.name + "\nlifePoints: " + player.lifePoints + "/" + player.maxLifePoints);
		System.out.println("Choose an action: ");
		System.out.println("(1) Fight");
		System.out.println("(2) Use a MedKit");
		System.out.println("(3) Escape");
		
		int userInput = readInt("-> ", 3);
		
		if(userInput == 1) {
			
			int damage = player.attack() - demons.defense();
			int damageTaken = demons.attack() - player.defense();
			
			if(damageTaken<0){
				damage -=damageTaken/2;
				damageTaken = 0;
			}
			if(damage < 0 ){
				damage = 0;
			}
			player.lifePoints -= damageTaken;
			demons.lifePoints -= damage;
			
			System.out.println("You hit " + demons.name + " for " + damage + "!");
			System.out.println(demons.name + " hit you for " + damageTaken + "!");
			
			continueGame();
			
			if(player.lifePoints <= 0) {
				playerDied();
				break;
				
			}else if(demons.lifePoints <=0) {
				System.out.println("You slayed the " + demons.name + "!");
				player.experience += demons.experience;
				System.out.println("You absorbed the demons experience gaining a total of " + demons.experience + " experience!");
				boolean addMedKit = (Math.random()*5 + 1 <1.99);
				if(addMedKit) {
					player.medKits++;
					System.out.println("You found a medkit!");
				}
				continueGame();
				break;
				
			}
			
			
		}else if(userInput == 2) {
			if(player.medKits > 0 && player.lifePoints < player.maxLifePoints) {
				System.out.println("Are you sure you want to use a MedKit?");
				System.out.println("(1) Yes");
				System.out.println("(2) No");
				userInput = readInt("-> ", 2);
					if(userInput==1) {
						player.lifePoints = player.maxLifePoints;
						System.out.println("You used a medkit to restore your health to full");
						player.medKits -=1;
					}
			}
		}else {
			if(part != 3) {
			if(Math.random()*7 + 3 <=4.5) {
				System.out.println("You successfully escape from " + demons.name);
				continueGame();
				break;
				
			}else {
				System.out.println("You failed to escape and got hit!");
				
				int damageTaken = demons.attack();
				System.out.println("You took " + damageTaken + "!");
				player.lifePoints -= damageTaken;
			continueGame();
			if(player.lifePoints<=0) {
				playerDied();
			}
			}
		}else {
			System.out.println("It is impossible to escape from the tower");
			continueGame();
		}
		}
	}
	}
	//method that prints a selection menu
	public static void printMenu() {
		System.out.println("\n---SELECTION SCREEN---");
		System.out.println("\nMake a selection: ");
		System.out.println("\n(1) Move onward");
		System.out.println("(2) Character Information");
		System.out.println("(3) End Campaign");
	}
	
	//method that replaces a normal encounter with the boss fight encounter
	public static void finalFight() {
		battle(new Enemy("Dark Lord",115));
		Plot.printPartThreeEnd();
		Plot.printCredits(player);
		isRunning=false;
	}
	
	//method for if players life total falls below 0
	public static void playerDied() {
		System.out.println("\nYou have perished on your journey to save the earth, try again!");
		isRunning=false;
	}
	
	//method that loops game choice 
	public static void gameLoop() {
		while(isRunning==true) {
			printMenu();
			int userInput = readInt("->",3);
				if(userInput==1) 
					continueStory();
				else if(userInput==2)
					characterStats();
				else if(userInput==3)
					isRunning=false;
		}
	}
}

