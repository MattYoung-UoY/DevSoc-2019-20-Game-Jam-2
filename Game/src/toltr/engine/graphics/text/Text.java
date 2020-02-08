package toltr.engine.graphics.text;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import toltr.game.graphics.Textures;

public class Text {

	private List<TextCharacter> chars;
	
	public Text(Vector2f start, float zPos, float fontSize, String text) {
		text = text.toLowerCase();
		chars = new ArrayList<TextCharacter>();
		char[] tempChars = text.toCharArray();
		for(int i = 0; i < tempChars.length; i++) {
			if(tempChars[i] == ' ') continue;
			chars.add(new TextCharacter(new Vector3f((start.x + (i * 1.1f * fontSize)) * 0.5f, start.y, zPos), fontSize, Textures.font1Chars.get(tempChars[i])));
		}
	}
	
	public List<TextCharacter> getTextChars(){
		return chars;
	}
	
}
