package toltr.engine.gameStates;

import java.util.ArrayList;
import java.util.List;

import toltr.engine.entities.Entity;
import toltr.engine.graphics.guis.GuiButton;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.map.Map;

public abstract class GameState {

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
		if (player != null)
			this.entities.add(player);
		if(strings != null) {
			this.strings = strings;
		}else {
			this.strings = new ArrayList<Text>();
		}
		if(guis != null) {
			this.guis = guis;
		}else {
			this.guis = new ArrayList<>();
		}
		for(GuiComponent comp: this.guis) {
			if(comp instanceof GuiButton) {
				this.strings.add(((GuiButton) comp).getText());
			}
		}
	}

	protected abstract void update();

	public abstract void cleanUp();

	public void updateState() {
		update();
		updateGuis();
		updateEntities();
	}

	private void updateEntities() {
		for (Entity entity : entities) {
			entity.move();
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

}
