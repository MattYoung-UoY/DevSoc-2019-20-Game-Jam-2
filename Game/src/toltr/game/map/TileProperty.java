package toltr.game.map;

import toltr.engine.graphics.Texture;

public class TileProperty {

	private Texture texture;
	private boolean collision;
	
	public TileProperty(Texture texture, boolean collision) {
		this.texture = texture;
		this.collision = collision;
	}

	public Texture getTexture() {
		return texture;
	}

	public boolean getCollision() {
		return collision;
	}
	
}
