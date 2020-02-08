package toltr;

import org.lwjgl.util.vector.Vector2f;

public class Config {
	
	public static final int MAX_FPS = 60;
	
	public static final float MAP_TILE_SCALE = 0.15f;
	
	public static final float MOVE_SPEED = 0.015f;
	public static final Vector2f PLAYER_SCALE = new Vector2f(1f * MAP_TILE_SCALE, 1.6f * MAP_TILE_SCALE);
	
	public static final Vector2f START_POSITION = new Vector2f(0 * MAP_TILE_SCALE, -0 * MAP_TILE_SCALE);
	
	public static float PERSPECTIVE_FACTOR;
	
}