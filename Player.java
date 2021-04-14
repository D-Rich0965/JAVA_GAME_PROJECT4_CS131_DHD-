/*
 * @Author Dylan Diedrich
 * @Version 1.0
 * @Since 04/15/2021
 */
public class Player extends Characters {
	
	public int numOffensiveAbilities;
	public int numDefensiveAbilities;
	
	public int medKits;
	
	//Arrays for different abilities
	public String[] defensiveAbilities = {"Hand of God", "Iron Flesh", "Touch of Death", "Living armor", "Blinding Sight"};
	public String[] offensiveAbilities = {"Infused Grip", "Sharpened Blade", "Poison Tip", "Flaming Aura"};

	//Constructor for the player 
	public Player(String name) {
		super(name, 100, 5);
		
		this.numOffensiveAbilities = 0;
		this.numDefensiveAbilities = 0;
		this.medKits = 2;
		
		chooseAbility();
	}

	
	//Player version of these methods
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*experience + 7 + numOffensiveAbilities*3);
	}

	@Override
	public int defense() {
		// TODO Auto-generated method stub
		return (int) (Math.random()* experience + numDefensiveAbilities*2);
	}
	
	//Method to let user choose a new ability
	public void chooseAbility() {
		System.out.println("\nChoose a new ability");
		System.out.println("(1) " + offensiveAbilities[numOffensiveAbilities]);
		System.out.println("(2) " + defensiveAbilities[numDefensiveAbilities]);
		
		int userInput = GameStructure.readInt("-> " , 2);
		
		if(userInput==1) {
			System.out.println("You selected " + offensiveAbilities[numOffensiveAbilities]);
			numOffensiveAbilities++;
		}
		else {
			System.out.println("You selected " + defensiveAbilities[numDefensiveAbilities]);
			numDefensiveAbilities++;
		}
		GameStructure.continueGame();
	}

}
