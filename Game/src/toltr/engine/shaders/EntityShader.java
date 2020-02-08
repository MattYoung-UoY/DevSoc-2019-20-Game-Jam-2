package toltr.engine.shaders;

import org.lwjgl.util.vector.Matrix4f;

import toltr.engine.graphics.Camera;

public class EntityShader extends ShaderProgram{

	private final static String VERTEX = "/res/shaders/entities/vertex.glsl", 
			FRAGMENT = "/res/shaders/entities/fragment.glsl";

	private int location_transformationMatrix;
	private int location_viewMatrix;
	
	public EntityShader() {
		super(VERTEX, FRAGMENT);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "texCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(location_transformationMatrix, matrix);
	}

	public void loadViewMatrix(Camera camera) {
		super.loadMatrix(location_viewMatrix, camera.getViewMatrix());
	}
	
}
