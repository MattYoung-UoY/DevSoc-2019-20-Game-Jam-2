package toltr.engine.graphics;

public class Quad {
	
	int[] indices = {
			0, 1, 3,
			3, 1, 2
	};

	float[] texCoords = {
			0, 0,
			0, 1,
			1, 1,
			1, 0
	};
	
	private int vaoID, vertexCount = indices.length;
	
	public Quad() {
		
		float[] vertices = new float[] {
				0f, 1, 0f,
				0f, 0f, 0f,
				1, 0f, 0f,
				1, 1, 0f
		};
		
		vaoID = Loader.loadToVAO(vertices, indices, texCoords);
	}

	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
}
