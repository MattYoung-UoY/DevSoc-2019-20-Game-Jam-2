package toltr.game.gameStates;

import java.util.ArrayList;
import java.util.List;

import toltr.engine.entities.Entity;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;

public class MainMenuState extends GameState{

	public MainMenuState(List<GuiComponent> guis, List<Text> strings) {
		super(null, null, guis, new ArrayList<Entity>(), strings);
	}

	@Override
	protected void update() {
	}

	@Override
	public void cleanUp() {
	}

}
