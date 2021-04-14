/*
 * @Author Dylan Diedrich
 * @Version 1.0
 * @Since 04/15/2021
 */

public abstract class Characters {
	
	//Variables for each character
	public String name;
	public int maxLifePoints;
	public int lifePoints;
	public int experience;
	
	//Constructor for the characters
	public Characters(String name, int maxLifePoints, int experience) {
		this.name = name;
		this.maxLifePoints = maxLifePoints;
		this.experience = experience;
		this.lifePoints = maxLifePoints;
	}
	//methods for each character
	public abstract int attack();
	public abstract int defense();

}
