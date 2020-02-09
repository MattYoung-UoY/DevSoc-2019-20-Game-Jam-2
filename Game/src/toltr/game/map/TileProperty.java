package toltr.game.map;

import toltr.engine.graphics.Texture;

public class TileProperty {

	private Texture texture;
	private boolean collision;
	private int damage;
	
	public TileProperty(Texture texture, boolean collision, int damage) {
		this.texture = texture;
		this.collision = collision;
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}
	
	public Texture getTexture() {
		return texture;
	}

	public boolean getCollision() {
		return collision;
	}
	
}
