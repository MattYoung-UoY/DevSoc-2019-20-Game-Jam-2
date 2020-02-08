package toltr.game.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import toltr.Config;
import toltr.Main;
import toltr.engine.entities.Entity;
import toltr.engine.graphics.Texture;

public class Player extends Entity{

	public Player(Vector2f position, Texture forward, Texture backward, Texture left,
			Texture right) {
		super(position, 0f, new Vector2f(1f, 2f), forward, backward, left, right);
	}

	@Override
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			this.increasePosition(0, Config.MOVE_SPEED);
			Main.increaseCameraPosition(new Vector2f(0, -Config.MOVE_SPEED));
			setTexture(forward);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.increasePosition(0, -Config.MOVE_SPEED);
			Main.increaseCameraPosition(new Vector2f(0, Config.MOVE_SPEED));
			setTexture(backward);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			this.increasePosition(-Config.MOVE_SPEED, 0);
			Main.increaseCameraPosition(new Vector2f(Config.MOVE_SPEED, 0));
			setTexture(left);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.increasePosition(Config.MOVE_SPEED, 0);
			Main.increaseCameraPosition(new Vector2f(-Config.MOVE_SPEED, 0));
			setTexture(right);
		}
	}

}
