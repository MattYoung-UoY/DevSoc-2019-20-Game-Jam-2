package toltr.engine.graphics;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public abstract class Drawable {
	
	private Vector2f scale;
	private Vector3f position;
	public float rotation;
	private int textureID;
	
	protected Drawable(Vector3f position, float rotation,  Vector2f size, Texture texture) {
		this.position = position;
		this.rotation = rotation;
		this.scale = size;
		this.textureID = texture.getTextureID();
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public void increasePosition(float x, float y) {
		position.x += x;
		position.y += y;
	}
	
	public float getRotation() {
		return rotation;
	}

	public Vector2f getScale() {
		return scale;
	}
	
	public int getTextureID() {
		return textureID;
	}
	
	public void setTexture(Texture texture) {
		textureID = texture.getTextureID();
	}

	public void setWidth(float width) {
		scale.x = width;
	}
	
}
