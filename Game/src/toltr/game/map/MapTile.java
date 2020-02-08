package toltr.game.map;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import toltr.Config;
import toltr.engine.graphics.Drawable;
import toltr.engine.graphics.Texture;

public class MapTile extends Drawable{
	
	public MapTile(Vector2f position, Texture texture) {
		super(new Vector3f(position.x * Config.MAP_TILE_SCALE, position.y * Config.MAP_TILE_SCALE, -0.1f), 0f, new Vector2f(Config.MAP_TILE_SCALE * Config.PERSPECTIVE_FACTOR, Config.MAP_TILE_SCALE), texture);
	}
	
}
