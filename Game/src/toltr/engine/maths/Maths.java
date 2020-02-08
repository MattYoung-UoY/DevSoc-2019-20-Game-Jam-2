package toltr.engine.maths;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Maths {

	private static final float FOV = 90, NEAR_PLANE = 1f, FAR_PLANE = -1000f;
	
	public static Matrix4f createTansformationMatrix(Vector3f translation, float rotation, Vector2f scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotation), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale.x / Display.getWidth(), scale.y / Display.getWidth(), 1), matrix, matrix);
		return matrix;
	}
	
	public float distance(Vector2f vector1, Vector2f vector2) {
		float difX = vector1.getX() - vector2.getX();
		float difY = vector1.getY() - vector2.getY();
		
		float absolute = (float) Math.sqrt((difX*difX)+(difY*difY));
		
		return absolute;
	}
	
	public static float distance(Vector3f vector1, Vector3f vector2) {
		float difX = vector1.getX() - vector2.getX();
		float difY = vector1.getY() - vector2.getY();
		float difZ = vector1.getZ() - vector2.getZ();
		
		float absolute = (float) Math.sqrt((difX*difX)+(difY*difY)+(difZ*difZ));
		
		return absolute;
	}

	public static Matrix4f getProjectionMatrix() {
		Matrix4f res = new Matrix4f();
		
		float aspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
		float yScale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
		float xScale = yScale / aspectRatio;
		float frustumLength = FAR_PLANE - NEAR_PLANE;
		
		res.m00 = xScale;
		res.m11 = yScale;
		res.m22 = -((FAR_PLANE + NEAR_PLANE) / frustumLength);
		res.m23 = -1;
		res.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustumLength);
		res.m33 = 0;
		
		return res;
	}

}
