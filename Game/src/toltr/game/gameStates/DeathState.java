package toltr.game.gameStates;

import java.util.List;

import toltr.engine.entities.Entity;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.map.Map;

public class DeathState extends GameState{

	public DeathState(Player player, Map map, List<GuiComponent> guis, List<Entity> entities, List<Text> strings) {
		super(player, map, guis, entities, strings);
	}

	@Override
	public void init() {
	}

	@Override
	protected void update() {
	}

	@Override
	public void cleanUp() {
	}

}
