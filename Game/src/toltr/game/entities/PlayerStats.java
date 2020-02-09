package toltr.game.entities;

public class PlayerStats {

	private static int health = -1, gold = 0, exp = 0, level = 1;
	
	public static void setup(int initHealth) {
		if (initHealth <= 0) throw new IllegalArgumentException("Init Health cannot be <= 0");
		health = initHealth;
	}
	
	public static void increaseMaxHealth(int deltaHealth) {
		if(deltaHealth <= 0) throw new IllegalArgumentException("DeltaHealth cannot be <= 0");
		health += deltaHealth;
	}
	
	public static int getHealth() {
		if(health < 0) throw new IllegalStateException("Must initialise Health to a non-zero, non-negative number. Run PlayerStats.setup");
		return health;
	}
	
	public static int getGold() {
		return gold;
	}
	
	public static int getExp() {
		return exp;
	}
	
	public static int getLevel() {
		return level;
	}
}
