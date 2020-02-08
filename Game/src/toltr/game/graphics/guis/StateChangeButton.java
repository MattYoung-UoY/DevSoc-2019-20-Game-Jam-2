package toltr.game.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.Main;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.Texture;
import toltr.engine.graphics.guis.GuiButton;

public class StateChangeButton extends GuiButton{

	GameState nextState;
	
	public StateChangeButton(Vector2f position, float zLayer, Vector2f scale, Texture texture, GameState nextState, String text) {
		super(position, zLayer, scale, texture, text);
		this.nextState = nextState;
	}

	@Override
	public void buttonClicked() {
		Main.changeGameState(nextState);
	}

}
