package toltr;

import org.lwjgl.util.vector.Vector2f;

public class Config {
	
	public static final boolean DEBUG = false;
	
	public static final int MAX_FPS = 60;
	
	public static final float MAP_TILE_SCALE = 0.15f;
	
	public static float PERSPECTIVE_FACTOR;
	
	public static final float MOVE_SPEED = 0.015f;
	public static final Vector2f PLAYER_SCALE = new Vector2f(1f * MAP_TILE_SCALE, 1.6f * MAP_TILE_SCALE);
	public static final Vector2f GRASSLANDS_START_POSITION = new Vector2f(13.5f * MAP_TILE_SCALE, -15 * MAP_TILE_SCALE);
	
}