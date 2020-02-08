package toltr.engine.input;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

public class MouseHandler {

	public static final int MOUSE_LEFT = 0, MOUSE_RIGHT = 1;
	
	private static int key = -1;
	
	private static Vector2f coords = new Vector2f(0, 0);
	
	public static void update() {
		getButtonDown();
		getMouseCoords();
	}
	
	private static void getButtonDown() {
		key = -1;
		while(Mouse.next()) if(Mouse.getEventButtonState()) key = Mouse.getEventButton();
	}
	
	private static void getMouseCoords() {
		coords = getNormalizedDeviceCoords(Mouse.getX(), Mouse.getY());
	}
	
	private static Vector2f getNormalizedDeviceCoords(float mouseX, float mouseY){
		float x = (2f * (mouseX / (float) Display.getWidth()) - 1);
		float y = (2f * (mouseY / (float) Display.getHeight()) - 1);
		return new Vector2f(x, y);
	}
	
	public static int getKey() {
		return key;
	}
	
	public static Vector2f getCoords() {
		return coords;
	}
	
}
