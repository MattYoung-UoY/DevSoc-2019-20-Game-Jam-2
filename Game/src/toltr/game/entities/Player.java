package toltr.game.entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;

import toltr.Config;
import toltr.Main;
import toltr.engine.entities.Entity;
import toltr.engine.graphics.Texture;
import toltr.engine.maths.Maths;
import toltr.game.map.MapTile;

public class Player extends Entity {

	public Player(Vector2f position, Texture forward, Texture backward, Texture left, Texture right) {
		super(position, 0f, Config.PLAYER_SCALE, forward, backward, left, right);
	}

	@Override
	public void move(List<MapTile> mapTiles) {
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

		Vector2f nextPos = new Vector2f(this.getPosition().x, this.getPosition().y);
		nextPos.x += direction.x;
		nextPos.y += direction.y;

		List<MapTile> toTest = new ArrayList<MapTile>();

		for (MapTile tile : mapTiles) {
			if (tile.getTile().getCollision()) {
				if (Maths.distance(new Vector2f(tile.getPosition().x, tile.getPosition().y), nextPos) < 5f) {
					toTest.add(tile);
				}
			}
		}
		
		boolean colliding = false;
		for(MapTile tile: toTest) {
			if(Maths.isColliding(new Vector2f(tile.getPosition().x + 0.02f, tile.getPosition().y + 0.008f), new Vector2f(Config.MAP_TILE_SCALE * Config.PERSPECTIVE_FACTOR * 0.54f, Config.MAP_TILE_SCALE * 0.9f), nextPos, new Vector2f(Config.PLAYER_SCALE.x * Config.PERSPECTIVE_FACTOR, Config.PLAYER_SCALE.y))) {
				colliding = true;
				break;
			}
		}

		if(!colliding) {
			this.increasePosition(direction.x, direction.y);
			Main.increaseCameraPosition(new Vector2f(-direction.x, -direction.y));
		}
	}
	
}
