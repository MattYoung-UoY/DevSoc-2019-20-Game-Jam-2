package toltr.game.gameStates;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;

import toltr.Config;
import toltr.Main;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.graphics.Textures;
import toltr.game.graphics.guis.ExitButton;
import toltr.game.graphics.guis.StateChangeButton;
import toltr.game.map.GrasslandsMap;

public class GameStates {

	/*
	 * 0-Main Menu
	 * 1-Level Selection Screen
	 * 2-Pause Screen
	 * 3-Grasslands
	 */
	public static GameState[] states = new GameState[4];
	
	public static void setup() {
		mainMenuState();
		levelSelectState();
		pauseState();
		grasslandsState();
	}
	
	protected static void resetLevels() {
		grasslandsState();
		Main.setCameraPosition(new Vector2f(-Config.GRASSLANDS_START_POSITION.x, -Config.GRASSLANDS_START_POSITION.y));
	}
	
	private static void mainMenuState() {
		List<Text> strings = new ArrayList<Text>();
		strings.add(new Text(new Vector2f(-0.3f, 0.3f), -0.4f, 0.1f, "TOLTR"));
		
		List<GuiComponent> guis = new ArrayList<GuiComponent>();

		ExitButton exitButton = new ExitButton(new Vector2f(-0.25f, -0.5f), -0.5f, new Vector2f(0.5f, 0.1f),
				Textures.button);

		StateChangeButton playButton = new StateChangeButton(new Vector2f(-0.25f, -0.3f), -0.5f, new Vector2f(0.5f, 0.1f), 1, "Play", true);

		guis.add(exitButton);
		guis.add(playButton);

		states[0] = new MainMenuState(null, null, guis, null, strings);
	}
	
	private static void levelSelectState() {
		List<Text> strings = new ArrayList<Text>();
		strings.add(new Text(new Vector2f(-0.5f, 0.8f), -0.4f, 0.05f, "Level Selection"));
		strings.add(new Text(new Vector2f(0.96f, 0.3f), -0.4f, 0.025f, "Levels"));
		
		List<GuiComponent> guis = new ArrayList<GuiComponent>();
		StateChangeButton grasslandButton = new StateChangeButton(new Vector2f(0.47f, 0.15f), -0.5f, new Vector2f(0.5f, 0.1f), 3, "Grasslands", true);
		guis.add(grasslandButton);
		
		StateChangeButton desertButton = new StateChangeButton(new Vector2f(0.47f, 0f), -0.5f, new Vector2f(0.5f, 0.1f), 3, "Desert", false);
		guis.add(desertButton);
		
		StateChangeButton volcanoButton = new StateChangeButton(new Vector2f(0.47f, -0.15f), -0.5f, new Vector2f(0.5f, 0.1f), 3, "Volcano", false);
		guis.add(volcanoButton);
		
		StateChangeButton mainMenuButton = new StateChangeButton(new Vector2f(0.72f, -0.95f), -0.5f, new Vector2f(0.25f, 0.1f), 0, "Main menu", true);
		guis.add(mainMenuButton);
		
		states[1] = new LevelSelectionState(null, null, guis, null, strings);
	}

	private static void pauseState() {

		List<Text> strings = new ArrayList<Text>();
		strings.add(new Text(new Vector2f(-0.3f, 0.3f), -0.4f, 0.05f, "Paused"));
		
		List<GuiComponent> guis = new ArrayList<GuiComponent>();
		
		StateChangeButton resumeButton = new StateChangeButton(new Vector2f(-0.25f, -0.3f), -0.5f, new Vector2f(0.5f, 0.1f), 3, "Resume", true);
		guis.add(resumeButton);
		
		StateChangeButton quitLevelButton = new StateChangeButton(new Vector2f(-0.25f, -0.5f), -0.5f, new Vector2f(0.5f, 0.1f), 1, "Quit Level", true);
		guis.add(quitLevelButton);
		
		states[2] = new PauseState(null, null, guis, null, strings);
	}
	
	private static void grasslandsState() {
		states[3] = new GrasslandsState(new Player(Config.GRASSLANDS_START_POSITION, Textures.playerForward, Textures.playerBackward,
				Textures.playerLeft, Textures.playerRight), new GrasslandsMap(), null,
				null, null);
	}
	
}
