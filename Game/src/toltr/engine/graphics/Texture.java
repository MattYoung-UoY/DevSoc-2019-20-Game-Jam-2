package toltr.engine.graphics;

public class Texture {

	private int textureID;
	
	public Texture(String filepath) {
		this.textureID = Loader.loadTexture(filepath);
	}

	public int getTextureID() {
		return textureID;
	}
	
}
