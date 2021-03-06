package toltr.game.map;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;

import toltr.Config;

public abstract class Map{
	
	private List<MapTile> tileList = new ArrayList<MapTile>();
	
	protected Map(TileProperty[] tileTextures, int[][] tileMap) {
		for(int i = 0; i < tileMap.length; i++) {
			int[] subList = tileMap[i];
			for(int j = 0; j < subList.length; j++) {
				tileList.add(new MapTile(new Vector2f(j * Config.PERSPECTIVE_FACTOR, -i), tileTextures[subList[j]]));
			}
		}
	}
	
	public List<MapTile> getTiles(){
		return tileList;
	}
	
}
