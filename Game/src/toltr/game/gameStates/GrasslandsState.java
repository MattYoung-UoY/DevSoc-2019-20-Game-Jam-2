package toltr.game.gameStates;

import java.util.List;

import org.lwjgl.input.Keyboard;

import toltr.Main;
import toltr.engine.entities.Entity;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.map.Map;

public class GrasslandsState extends GameState{
	
	public GrasslandsState(Player player, Map map, List<GuiComponent> guis, List<Entity> entities, List<Text> strings) {
		super(player, map, guis, entities, strings);
	}

	@Override
	public void update() {
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) Main.changeGameState(GameStates.states[2]);
		getPlayer().damage(1);
	}

	@Override
	public void cleanUp() {
	}

	@Override
	public void init() {
	}

}
