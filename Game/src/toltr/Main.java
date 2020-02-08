package toltr;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.Camera;
import toltr.engine.graphics.DisplayManager;
import toltr.engine.graphics.Loader;
import toltr.engine.graphics.Render;
import toltr.engine.input.MouseHandler;
import toltr.game.gameStates.GameStates;
import toltr.game.graphics.Textures;

public class Main {

	private static boolean running = true;

	private static GameState currentGameState;

	private static Camera camera;
	
	public static void main(String[] args) {
		DisplayManager.createDisplay();

		Render renderer = new Render();
		camera = new Camera(new Vector2f(-Config.START_POSITION.x, -Config.START_POSITION.y));
		renderer.setCamera(camera);

		Textures.setup();
		GameStates.setup();
		
		currentGameState = GameStates.menuState;

		while (!Display.isCloseRequested() && running) {

			MouseHandler.update();

			currentGameState.updateState();

			renderer.prepare();
			renderer.render(currentGameState);

			DisplayManager.updateDisplay();
		}

		currentGameState.cleanUp();
		renderer.cleanUp();
		Loader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
	public static void increaseCameraPosition(Vector2f deltaPos) {
		Vector2f startPos = camera.getPosition();
		Vector2f nextPos = new Vector2f(startPos.x + deltaPos.x, startPos.y + deltaPos.y);
		camera.setPosition(nextPos);
	}

	public static void setCameraPosition(Vector2f pos) {
		camera.setPosition(pos);
	}

	public static void changeGameState(GameState nextState) {
		currentGameState.cleanUp();
		currentGameState = nextState;
	}

	public static void closeGame() {
		running = false;
	}
	
}