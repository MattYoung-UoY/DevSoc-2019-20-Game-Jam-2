package toltr.engine.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.engine.graphics.Texture;
import toltr.engine.graphics.text.Text;
import toltr.engine.input.MouseHandler;
import toltr.game.graphics.Textures;

public abstract class GuiButton extends GuiComponent{

	Text buttonText;
	
	public GuiButton(Vector2f position, float zLayer, Vector2f scale, Texture texture, String text) {
		super(position, zLayer, scale, texture);
		buttonText = new Text(new Vector2f(position.x - 0.225f, position.y + (scale.y * 0.2f)), zLayer - 0.1f, (scale.y/2) - (scale.y * 0.2f), text);
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

	public Text getText() {
		return buttonText;
	}
	
}
