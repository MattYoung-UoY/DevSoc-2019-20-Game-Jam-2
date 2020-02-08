package toltr.engine.entities;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import toltr.Config;
import toltr.engine.graphics.Drawable;
import toltr.engine.graphics.Moveable;
import toltr.engine.graphics.Texture;

public abstract class Entity extends Drawable implements Moveable{

	protected Texture forward, backward, left, right;
	
	protected Entity(Vector2f position, float rotation, Vector2f size, Texture forward, Texture backward, Texture left, Texture right) {
		super(new Vector3f(position.x, position.y, -0.2f), rotation, new Vector2f(size.x * Config.PERSPECTIVE_FACTOR, size.y), backward);
		this.forward = forward;
		this.backward = backward;
		this.left = left;
		this.right = right;
	}
	
}
