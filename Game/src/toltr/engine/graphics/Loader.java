package toltr.engine.graphics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Loader {

	private static List<Integer> vaos = new ArrayList<Integer>();
	private static List<Integer> vbos = new ArrayList<Integer>();
	private static List<Integer> textures = new ArrayList<Integer>();
	
	public static int loadToVAO(float[] positions, int[] indices, float[] texCoords) {
		int vaoID = createVAO();
		bindIndicesBuffer(indices);
		storeDataInAttributeList(0, positions, 3);
		storeDataInAttributeList(1, texCoords, 2);
		unbindVAO();
		return vaoID;
	}
	
	public static int loadTexture(String filename) {
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture("PNG", Loader.class.getResourceAsStream(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int textureID = texture.getTextureID();
		textures.add(textureID);
		return textureID;
	}
	
	public static void cleanUp() {
		for(int vao: vaos) {
			GL30.glDeleteVertexArrays(vao);
		}
		for(int vbo: vbos) {
			GL15.glDeleteBuffers(vbo);
		}
		for(int texture: textures) {
			GL11.glDeleteTextures(texture);
		}
	}
	
	private static int createVAO() {
		int vaoID = GL30.glGenVertexArrays();
		vaos.add(vaoID);
		GL30.glBindVertexArray(vaoID);
		return vaoID;
	}
	
	private static void bindIndicesBuffer(int[] indices) {
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
		IntBuffer buffer = storeDataInIntBuffer(indices);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
	}
	
	private static IntBuffer storeDataInIntBuffer(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
	private static void storeDataInAttributeList(int attributeNumber, float[] data, int coordSize) {
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		FloatBuffer buffer = storeDataInFloatBuffer(data);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(attributeNumber, coordSize, GL11.GL_FLOAT, false, 0, 0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	
	private static FloatBuffer storeDataInFloatBuffer(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		return buffer;
	}
	
	private static void unbindVAO() {
		GL30.glBindVertexArray(0);
	}
	
}
