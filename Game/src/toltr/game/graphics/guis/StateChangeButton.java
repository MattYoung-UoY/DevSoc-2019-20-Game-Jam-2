package toltr.game.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.Main;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.Texture;
import toltr.engine.graphics.guis.GuiButton;

public class StateChangeButton extends GuiButton{

	GameState nextState;
	
	public StateChangeButton(Vector2f position, int zLayer, Vector2f scale, Texture texture, GameState nextState) {
		super(position, zLayer, scale, texture);
		this.nextState = nextState;
	}

	@Override
	public void buttonClicked() {
		Main.changeGameState(nextState);
	}

}
