package toltr.engine.shaders;

import org.lwjgl.util.vector.Matrix4f;

public class GuiShader extends ShaderProgram{

	private final static String VERTEX = "/res/shaders/guis/vertex.glsl", 
			FRAGMENT = "/res/shaders/guis/fragment.glsl";

	private int location_transformationMatrix;
	
	public GuiShader() {
		super(VERTEX, FRAGMENT);
	}

	@Override
	protected void getAllUniformLocations() {
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "texCoords");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(location_transformationMatrix, matrix);
	}
	
}
