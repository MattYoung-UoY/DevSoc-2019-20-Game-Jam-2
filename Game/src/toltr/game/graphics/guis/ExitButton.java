package toltr.game.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.Main;
import toltr.engine.graphics.Texture;
import toltr.engine.graphics.guis.GuiButton;

public class ExitButton extends GuiButton{

	public ExitButton(Vector2f position, float zLayer, Vector2f scale, Texture texture) {
		super(position, zLayer, scale, texture, "Exit", true);
	}

	@Override
	public void buttonClicked() {
		Main.closeGame();
	}

}
