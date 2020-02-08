package toltr.game.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.Main;
import toltr.engine.graphics.guis.GuiButton;
import toltr.game.gameStates.GameStates;
import toltr.game.graphics.Textures;

public class StateChangeButton extends GuiButton{

	private int nextStateIndex;
	
	public StateChangeButton(Vector2f position, float zLayer, Vector2f scale, int nextStateIndex, String text, boolean active) {
		super(position, zLayer, scale, Textures.button, text, active);
		this.nextStateIndex = nextStateIndex;
	}

	@Override
	public void buttonClicked() {
		Main.changeGameState(GameStates.states[nextStateIndex]);
	}

}
