package toltr.game.graphics.guis;

import org.lwjgl.util.vector.Vector2f;

import toltr.engine.graphics.Texture;
import toltr.engine.graphics.guis.GuiImage;

public class ProgressBar {
	
	private GuiImage back, front;
	private float maxWidth;
	
	public ProgressBar(Texture back, Texture front, Vector2f pos, Vector2f scale) {
		this.back = new GuiImage(pos, -0.4f, new Vector2f(scale), back);
		this.front = new GuiImage(new Vector2f(pos.x, pos.y + (scale.y * 0.2f)), -0.5f, new Vector2f(scale), front);
		maxWidth = scale.x;
	}

	public void setProgress(float progress) {
		if(progress > 1 || progress < 0) throw new IllegalArgumentException("Progress needs to be between 0 and 1 (inclusive)");
		front.setWidth(maxWidth * progress);
	}
	
	public GuiImage getFront() {
		return front;
	}

	public GuiImage getBack() {
		return back;
	}
	
}
