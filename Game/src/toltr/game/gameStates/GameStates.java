package toltr.game.gameStates;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;

import toltr.Config;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.graphics.Textures;
import toltr.game.graphics.guis.ExitButton;
import toltr.game.graphics.guis.StateChangeButton;
import toltr.game.map.MainMap;

public class GameStates {

	private static List<GuiComponent> guis;
	private static List<Text> strings;
	private static GuiComponent exitButton, playButton;

	public static MainMenuState menuState;
	public static PlayState playState;

	public static void setup() {

		strings = new ArrayList<Text>();
		strings.add(new Text(new Vector2f(-0.4f, 0.1f), -0.4f, 0.1f, "deja vu"));
		
		playState = new PlayState(new Player(Config.START_POSITION, Textures.playerForward, Textures.playerBackward,
				Textures.playerLeft, Textures.playerRight), new MainMap(), null,
				null, null);

		guis = new ArrayList<GuiComponent>();

		exitButton = new ExitButton(new Vector2f(-0.25f, -0.6f), 1, new Vector2f(0.5f, 0.10f),
				Textures.button);

		playButton = new StateChangeButton(new Vector2f(-0.25f, -0.3f), 1, new Vector2f(0.5f, 0.10f),
				Textures.button, playState);

		guis.add(exitButton);
		guis.add(playButton);

		menuState = new MainMenuState(guis, strings);
	}

}
