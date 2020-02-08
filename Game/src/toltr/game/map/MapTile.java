package toltr.game.map;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import toltr.Config;
import toltr.engine.graphics.Drawable;

public class MapTile extends Drawable{
	
	private TileProperty tile;
	
	public MapTile(Vector2f position, TileProperty tile) {
		super(new Vector3f(position.x * Config.MAP_TILE_SCALE, position.y * Config.MAP_TILE_SCALE, -0.1f), 0f, new Vector2f(Config.MAP_TILE_SCALE * Config.PERSPECTIVE_FACTOR, Config.MAP_TILE_SCALE), tile.getTexture());
		this.tile = tile;
	}

	public TileProperty getTile() {
		return tile;
	}
	
}
