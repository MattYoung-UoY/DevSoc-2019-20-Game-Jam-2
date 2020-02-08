package toltr.engine.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.engine.graphics.Texture;
import toltr.engine.graphics.text.Text;
import toltr.engine.input.MouseHandler;
import toltr.game.graphics.Textures;

public abstract class GuiButton extends GuiComponent {

	Text buttonText;
	boolean active = true;

	public GuiButton(Vector2f position, float zLayer, Vector2f scale, Texture texture, String text, boolean active) {
		super(position, zLayer, scale, texture);
		buttonText = new Text(new Vector2f(position.x * 2 + (scale.y * 0.2f), position.y + (scale.y * 0.2f)),
				zLayer - 0.1f, (scale.y / 2) - (scale.y * 0.2f), text);
		setActive(active);
	}

	public abstract void buttonClicked();

	@Override
	public void update() {
		Vector2f mouse = MouseHandler.getCoords();
		Vector2f box = new Vector2f(super.getPosition().x, super.getPosition().y);
		Vector2f scale = super.getScale();
		if (active) {
			if (mouse.x > box.x && mouse.x < (box.x + scale.x)) {
				if (mouse.y > box.y && mouse.y < (box.y + scale.y)) {
					if (MouseHandler.getKey() == MouseHandler.MOUSE_LEFT) {
						buttonClicked();
					}
					setTexture(Textures.buttonDark);
				} else
					setTexture();
			} else
				setTexture();
		} else
			setTexture();
	}

	public void setActive(boolean isActive) {
		active = isActive;
		setTexture();
	}

	private void setTexture() {
		if (active) {
			this.setTexture(Textures.button);
		} else {
			this.setTexture(Textures.buttonInactive);
		}
	}

	public Text getText() {
		return buttonText;
	}

}
