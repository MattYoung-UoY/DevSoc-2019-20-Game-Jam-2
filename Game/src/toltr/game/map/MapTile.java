package toltr.game.map;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import toltr.Config;
import toltr.engine.graphics.Drawable;
import toltr.engine.graphics.Texture;

public class MapTile extends Drawable{
	
	public MapTile(Vector2f position, Texture texture) {
		super(new Vector3f(position.x * Config.MAP_TILE_SCALE, position.y * Config.MAP_TILE_SCALE, -10f), 0f, new Vector2f(Config.MAP_TILE_SCALE, Config.MAP_TILE_SCALE), texture);
	}
	
}
