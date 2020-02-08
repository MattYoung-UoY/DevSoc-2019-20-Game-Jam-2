package toltr.game.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import toltr.Config;
import toltr.Main;
import toltr.engine.entities.Entity;
import toltr.engine.graphics.Texture;

public class Player extends Entity {

	public Player(Vector2f position, Texture forward, Texture backward, Texture left, Texture right) {
		super(position, 0f, Config.PLAYER_SCALE, forward, backward, left, right);
	}

	@Override
	public void move() {
		Vector2f direction = new Vector2f(0, 0);

		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			direction.y = 1;
			setTexture(forward);
		} else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			direction.y = -1;
			setTexture(backward);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			direction.x = -1;
			setTexture(left);
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			direction.x = 1;
			setTexture(right);
		}

		float dirMag = direction.length();

		if (dirMag != 0) {
			direction.x /= dirMag;
			direction.y /= dirMag;
		}

		direction.x *= Config.MOVE_SPEED;
		direction.y *= Config.MOVE_SPEED;

		this.increasePosition(direction.x, direction.y);
		Main.increaseCameraPosition(new Vector2f(-direction.x, -direction.y));
	}

}
