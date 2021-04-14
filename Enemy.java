/*
 * @Author Dylan Diedrich
 * @Version 1.0
 * @Since 04/15/2021
 */


public class Enemy extends Characters {
	
	  int playerExperience;
//Constructor for the demons
	public Enemy(String name,int playerExperience) {
		super(name, (int) (Math.random()*playerExperience + 10), (int) (Math.random()*(playerExperience/2 +5)));
		this.playerExperience = playerExperience;
		
	}
//demon specific version of these methods
	@Override
	public int attack() {
		return (int) (Math.random()*(playerExperience+5 *2));
	}
	@Override
	public int defense() {
		return (int) (Math.random()*(playerExperience+1));
	}

}
