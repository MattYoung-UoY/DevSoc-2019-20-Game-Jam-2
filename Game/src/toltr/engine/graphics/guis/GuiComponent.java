package toltr.engine.graphics.guis;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import toltr.engine.graphics.Drawable;
import toltr.engine.graphics.Texture;

public abstract class GuiComponent extends Drawable{
	
	protected GuiComponent(Vector2f position, float zLayer, Vector2f scale, Texture texture) {
		super(new Vector3f(position.x, position.y, zLayer), 0f, scale, texture);
	}
	
	public abstract void update();
	
}
