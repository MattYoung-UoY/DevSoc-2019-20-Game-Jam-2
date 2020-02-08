package toltr.engine.graphics;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;

public class Camera{

	private Vector2f position;
	
	public Camera(Vector2f position) {
		this.position = new Vector2f(position.x, position.y);
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position.x = position.x;
		this.position.y = position.y;
	}
	
	public Matrix4f getViewMatrix() {
		Matrix4f viewMatrix = new Matrix4f();
		viewMatrix.setIdentity();
		Matrix4f.translate(position, viewMatrix, viewMatrix);
		return viewMatrix;
	}
	
}
