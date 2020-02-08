package toltr.engine.maths;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class Maths {

	public static Matrix4f createTansformationMatrix(Vector3f translation, float rotation, Vector2f scale) {
		Matrix4f matrix = new Matrix4f();
		matrix.setIdentity();
		Matrix4f.translate(translation, matrix, matrix);
		Matrix4f.rotate((float) Math.toRadians(rotation), new Vector3f(0, 0, 1), matrix, matrix);
		Matrix4f.scale(new Vector3f(scale.x / Display.getWidth(), scale.y / Display.getWidth(), 1), matrix, matrix);
		return matrix;
	}

	public static float distance(Vector2f vector1, Vector2f vector2) {
		float difX = vector1.getX() - vector2.getX();
		float difY = vector1.getY() - vector2.getY();

		float absolute = (float) Math.sqrt((difX * difX) + (difY * difY));

		return absolute;
	}

	public static boolean isColliding(Vector2f pos1, Vector2f scale1, Vector2f pos2, Vector2f scale2) {
		return (pos1.x < pos2.x + scale2.x
				&& pos1.x + scale1.x > pos2.x
				&& pos1.y < pos2.y + scale2.y
				&& pos1.y + scale1.y > pos2.y);
	}

}
