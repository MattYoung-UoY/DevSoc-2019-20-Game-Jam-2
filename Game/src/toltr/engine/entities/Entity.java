package toltr.engine.entities;

import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import toltr.Config;
import toltr.engine.graphics.Drawable;
import toltr.engine.graphics.Moveable;
import toltr.engine.graphics.Texture;
import toltr.game.map.MapTile;

public abstract class Entity extends Drawable implements Moveable{
	
	protected Entity(Vector2f position, float rotation, Vector2f size, Texture texture) {
		super(new Vector3f(position.x, position.y, -0.2f), rotation, new Vector2f(size.x * Config.PERSPECTIVE_FACTOR, size.y), texture);
	}
	
	public abstract void update(List<MapTile> mapTiles);
	
}
