package toltr.engine.gameStates;

import java.util.ArrayList;
import java.util.List;

import toltr.engine.entities.Entity;
import toltr.engine.graphics.guis.GuiButton;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.map.Map;
import toltr.game.map.MapTile;

public abstract class GameState {

	private Player player;
	private List<Entity> entities;
	private Map map;
	private List<GuiComponent> guis;
	private List<Text> strings;

	public GameState(Player player, Map map, List<GuiComponent> guis, List<Entity> entities, List<Text> strings) {
		this.map = map;
		
		if (entities != null)
			this.entities = entities;
		else
			this.entities = new ArrayList<Entity>();
		
		if (strings != null) {
			this.strings = strings;
		} else {
			this.strings = new ArrayList<Text>();
		}
		
		if (guis != null) {
			this.guis = guis;
		} else {
			this.guis = new ArrayList<>();
		}
		for (GuiComponent comp : this.guis) {
			if (comp instanceof GuiButton) {
				this.strings.add(((GuiButton) comp).getText());
			}
		}
		
		if (player != null) {
			this.player = player;
			this.guis.add(player.getHealthBar().getFront());
			this.guis.add(player.getHealthBar().getBack());
		}
	}

	public abstract void init();
	
	protected abstract void update();

	public abstract void cleanUp();

	public void updateState() {
		update();
		updateGuis();
		updateEntities();
	}

	private void updateEntities() {
		if (player != null) {
			if (map != null) {
				player.update(map.getTiles());
				player.move(map.getTiles());
			} else {
				player.update(new ArrayList<MapTile>());
				player.move(new ArrayList<MapTile>());
			}
		}
		for (Entity entity : entities) {
			if (map != null) {
				entity.update(map.getTiles());
				entity.move(map.getTiles());
			}else {
				entity.update(new ArrayList<MapTile>());
				entity.move(new ArrayList<MapTile>());
			}
		}
	}

	private void updateGuis() {
		if (guis != null) {
			for (GuiComponent gui : guis) {
				gui.update();
			}
		}
	}

	public Map getMap() {
		return map;
	}

	public List<GuiComponent> getGuis() {
		return guis;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public List<Text> getStrings() {
		return strings;
	}

	public Player getPlayer() {
		return player;
	}

}
