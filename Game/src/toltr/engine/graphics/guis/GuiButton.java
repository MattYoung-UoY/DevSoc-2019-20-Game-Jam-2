package toltr.engine.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.engine.graphics.Texture;
import toltr.engine.input.MouseHandler;
import toltr.game.graphics.Textures;

public abstract class GuiButton extends GuiComponent{

	public GuiButton(Vector2f position, int zLayer, Vector2f scale, Texture texture) {
		super(position, zLayer, scale, texture);
	}

	public abstract void buttonClicked();
	
	@Override
	public void update() {
		Vector2f mouse = MouseHandler.getCoords();
		Vector2f box = new Vector2f(super.getPosition().x, super.getPosition().y);
		Vector2f scale = super.getScale();
		if(mouse.x > box.x && mouse.x < (box.x + scale.x)) {
			if(mouse.y > box.y && mouse.y < (box.y + scale.y)) {
				if(MouseHandler.getKey() == MouseHandler.MOUSE_LEFT) {
					buttonClicked();
				}
				setTexture(Textures.buttonDark);
			}else setTexture(Textures.button);
		}else setTexture(Textures.button);
	}

}
