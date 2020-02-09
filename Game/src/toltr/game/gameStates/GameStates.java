package toltr.game.gameStates;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;

import toltr.Config;
import toltr.Main;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.guis.GuiImage;
import toltr.engine.graphics.text.Text;
import toltr.game.entities.Player;
import toltr.game.entities.PlayerStats;
import toltr.game.graphics.Textures;
import toltr.game.graphics.guis.ExitButton;
import toltr.game.graphics.guis.StateChangeButton;
import toltr.game.map.GrasslandsMap;

public class GameStates {

	/*
	 * 0-Main Menu
	 * 1-Level Selection Screen
	 * 2-Pause Screen
	 * 3-Death Screen
	 * 4-Grasslands
	 */
	public static GameState[] states = new GameState[5];
	
	public static void setup() {
		mainMenuState();
		characterState();
		pauseState();
		deathState();
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
	
	private static void characterState() {
		List<Text> strings = new ArrayList<Text>();
		strings.add(new Text(new Vector2f(-0.25f, 0.8f), -0.4f, 0.05f, "Character"));
		strings.add(new Text(new Vector2f(0.96f, 0.3f), -0.4f, 0.025f, "Levels"));
		strings.add(new Text(new Vector2f(-1.3f, 0.5f), -0.4f, 0.05f, "Character Stats"));
		
		List<GuiComponent> guis = new ArrayList<GuiComponent>();
		GuiImage playerScreenBacking = new GuiImage(new Vector2f(-0.95f, -0.92f), -0.3f, new Vector2f(1f, 1.6f), Textures.playerScreenBacking);
		guis.add(playerScreenBacking);
		
		GuiImage playerIcon = new GuiImage(new Vector2f(-0.9f, -0.5f), -0.4f, new Vector2f(0.15f, 0.4f), Textures.playerBackward);
		guis.add(playerIcon);
		
		StateChangeButton grasslandButton = new StateChangeButton(new Vector2f(0.47f, 0.15f), -0.5f, new Vector2f(0.5f, 0.1f), 4, "Grasslands", true);
		guis.add(grasslandButton);
		
		StateChangeButton desertButton = new StateChangeButton(new Vector2f(0.47f, 0f), -0.5f, new Vector2f(0.5f, 0.1f), 4, "Desert", false);
		guis.add(desertButton);
		
		StateChangeButton volcanoButton = new StateChangeButton(new Vector2f(0.47f, -0.15f), -0.5f, new Vector2f(0.5f, 0.1f), 4, "Volcano", false);
		guis.add(volcanoButton);
		
		StateChangeButton mainMenuButton = new StateChangeButton(new Vector2f(0.72f, -0.95f), -0.5f, new Vector2f(0.25f, 0.1f), 0, "Main menu", true);
		guis.add(mainMenuButton);
		
		states[1] = new CharacterState(null, null, guis, null, strings);
	}

	private static void pauseState() {

		List<Text> strings = new ArrayList<Text>();
		strings.add(new Text(new Vector2f(-0.3f, 0.3f), -0.4f, 0.05f, "Paused"));
		
		List<GuiComponent> guis = new ArrayList<GuiComponent>();
		
		StateChangeButton resumeButton = new StateChangeButton(new Vector2f(-0.25f, -0.3f), -0.5f, new Vector2f(0.5f, 0.1f), 4, "Resume", true);
		guis.add(resumeButton);
		
		StateChangeButton quitLevelButton = new StateChangeButton(new Vector2f(-0.25f, -0.5f), -0.5f, new Vector2f(0.5f, 0.1f), 1, "Quit Level", true);
		guis.add(quitLevelButton);
		
		states[2] = new PauseState(null, null, guis, null, strings);
	}
	
	private static void deathState() {
		List<Text> strings = new ArrayList<Text>();
		strings.add(new Text(new Vector2f(-0.38f, 0.3f), -0.4f, 0.05f, "You have died"));

		List<GuiComponent> guis = new ArrayList<GuiComponent>();
		
		StateChangeButton characterScreen = new StateChangeButton(new Vector2f(-0.25f, -0.3f), -0.5f, new Vector2f(0.5f, 0.1f), 1, "Character Screen", true);
		guis.add(characterScreen);
		
		states[3] = new DeathState(null, null, guis, null, strings);
	}
	
	private static void grasslandsState() {
		List<GuiComponent> guis = new ArrayList<GuiComponent>();
		
		GuiImage playerIcon = new GuiImage(new Vector2f(-0.97f, 0.69f), -0.4f, new Vector2f(0.1f, 0.25f), Textures.playerBackward);
		guis.add(playerIcon);
		
		GuiImage playerInfoBacking = new GuiImage(new Vector2f(-0.98f, 0.66f), -0.3f, new Vector2f(0.45f, 0.31f), Textures.playerInfoBacking);
		guis.add(playerInfoBacking);
		
		Player player = new Player(Config.GRASSLANDS_START_POSITION, Textures.playerForward, Textures.playerBackward,
				Textures.playerLeft, Textures.playerRight, PlayerStats.getHealth());
		states[4] = new GrasslandsState(player, new GrasslandsMap(), guis,
				null, null);
	}
	
}
