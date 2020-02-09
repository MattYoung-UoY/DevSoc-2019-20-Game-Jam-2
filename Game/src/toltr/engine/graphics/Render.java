package toltr.engine.graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import toltr.engine.entities.Entity;
import toltr.engine.gameStates.GameState;
import toltr.engine.graphics.guis.GuiComponent;
import toltr.engine.graphics.text.Text;
import toltr.engine.graphics.text.TextCharacter;
import toltr.engine.maths.Maths;
import toltr.engine.shaders.EntityShader;
import toltr.engine.shaders.GuiShader;
import toltr.engine.shaders.MapTileShader;
import toltr.engine.shaders.TextShader;
import toltr.game.entities.Player;
import toltr.game.map.MapTile;

public class Render {

	private Quad quad;
	private MapTileShader mtShader;
	private GuiShader guiShader;
	private EntityShader entityShader;
	private TextShader textShader;
	private Camera camera;

	public Render() {
		quad = new Quad();
		mtShader = new MapTileShader();
		guiShader = new GuiShader();
		entityShader = new EntityShader();
		textShader = new TextShader();
	}

	public void setCamera(Camera camera) {
		if (this.camera == null)
			this.camera = camera;
		else {
			System.err.println("The camera has already been set!");
			System.exit(-1);
		}
	}

	public void cleanUp() {
		mtShader.cleanUp();
	}

	public void prepare() {
		if (camera == null) {
			System.err.println("Camera has not been set!");
			System.exit(-1);
		}

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0.2f, 0.2f, 0.3f, 1.0f);
	}

	public void render(GameState gs) {
		renderMap(gs);
		renderGuis(gs);
		renderEntities(gs);
		renderText(gs);
	}

	private void renderMap(GameState gs) {
		if (gs.getMap() != null) {
			mtShader.start();
			mtShader.loadViewMatrix(camera);
			GL30.glBindVertexArray(quad.getVaoID());
			GL20.glEnableVertexAttribArray(0);
			GL20.glEnableVertexAttribArray(1);
			for (MapTile tile : gs.getMap().getTiles()) {
				Matrix4f transformationMatrix = Maths.createTansformationMatrix(tile.getPosition(), tile.getRotation(),
						tile.getScale());
				mtShader.loadTransformationMatrix(transformationMatrix);
				GL13.glActiveTexture(GL13.GL_TEXTURE0);
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, tile.getTextureID());
				GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
				GL11.glDrawElements(GL11.GL_TRIANGLES, quad.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
			}
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
			GL20.glDisableVertexAttribArray(0);
			GL20.glDisableVertexAttribArray(1);
			GL30.glBindVertexArray(0);
			mtShader.stop();
		}
	}

	private void renderGuis(GameState gs) {
		guiShader.start();
		GL30.glBindVertexArray(quad.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		for (GuiComponent gui : gs.getGuis()) {
			if(gs.getPlayer() != null) if(gui == gs.getPlayer().getHealthBar().getFront()) System.out.println(gs.getPlayer().getHealthBar().getFront().getScale().x);
			Matrix4f transformationMatrix = Maths.createTansformationMatrix(gui.getPosition(), gui.getRotation(),
					gui.getScale());
			guiShader.loadTransformationMatrix(transformationMatrix);
			GL13.glActiveTexture(GL13.GL_TEXTURE0);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, gui.getTextureID());
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			GL11.glDrawElements(GL11.GL_TRIANGLES, quad.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		}
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL30.glBindVertexArray(0);
		guiShader.stop();
	}

	private void renderEntities(GameState gs) {
		entityShader.start();
		entityShader.loadViewMatrix(camera);
		GL30.glBindVertexArray(quad.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		for (Entity entity : gs.getEntities()) {
			Matrix4f transformationMatrix = Maths.createTansformationMatrix(entity.getPosition(), entity.getRotation(),
					entity.getScale());
			entityShader.loadTransformationMatrix(transformationMatrix);
			GL13.glActiveTexture(GL13.GL_TEXTURE0);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, entity.getTextureID());
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			GL11.glDrawElements(GL11.GL_TRIANGLES, quad.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		}
		Player player = gs.getPlayer();
		if(player != null){
			Matrix4f transformationMatrix = Maths.createTansformationMatrix(player.getPosition(), player.getRotation(),
					player.getScale());
			entityShader.loadTransformationMatrix(transformationMatrix);
			GL13.glActiveTexture(GL13.GL_TEXTURE0);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, player.getTextureID());
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			GL11.glDrawElements(GL11.GL_TRIANGLES, quad.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
		}
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL30.glBindVertexArray(0);
		entityShader.stop();
	}

	private void renderText(GameState gs) {
		textShader.start();
		GL30.glBindVertexArray(quad.getVaoID());
		GL20.glEnableVertexAttribArray(0);
		GL20.glEnableVertexAttribArray(1);
		for (Text text : gs.getStrings()) {
			for (TextCharacter character : text.getTextChars()) {
				Matrix4f transformationMatrix = Maths.createTansformationMatrix(character.getPosition(),
						character.getRotation(), character.getScale());
				textShader.loadTransformationMatrix(transformationMatrix);
				GL13.glActiveTexture(GL13.GL_TEXTURE0);
				GL11.glBindTexture(GL11.GL_TEXTURE_2D, character.getTextureID());
				GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
				GL11.glDrawElements(GL11.GL_TRIANGLES, quad.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
			}
		}
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
		GL20.glDisableVertexAttribArray(0);
		GL20.glDisableVertexAttribArray(1);
		GL30.glBindVertexArray(0);
		textShader.stop();
	}

}
