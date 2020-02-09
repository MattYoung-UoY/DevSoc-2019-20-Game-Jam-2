package toltr.game.entities;

import org.lwjgl.util.vector.Vector2f;

import toltr.engine.entities.Entity;
import toltr.engine.graphics.Texture;

public abstract class LivingEntity extends Entity{

	private int health, maxHealth;
	
	protected LivingEntity(Vector2f position, float rotation, Vector2f size, Texture texture, int maxHealth) {
		super(position, rotation, size, texture);
		health = maxHealth;
		this.maxHealth = maxHealth;
	}
	
	public void damage(int damage) {
		if (damage < 0) throw new IllegalArgumentException("Damage dealt cannot be < 0");
		health -= damage;
		if(health < 0) health = 0;
	}

	public void heal(int health) {
		if (health < 0) throw new IllegalArgumentException("Health healed cannot be < 0");
		this.health += health;
		if(this.health > maxHealth) health = maxHealth;
	}

	public int getHealth() {
		return health;
	}

	public int getMaxHealth() {
		return maxHealth;
	}
	
}
