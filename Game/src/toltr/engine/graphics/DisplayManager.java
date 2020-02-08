package toltr.engine.graphics;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.opengl.ImageIOImageData;

import toltr.Config;

public class DisplayManager {

	public static void createDisplay() {

		ContextAttribs attribs = new ContextAttribs(3, 3).withForwardCompatible(true).withProfileCore(true);

		Display.setTitle("Deja Vu");

		try {
			ByteBuffer[] icons = { new ImageIOImageData()
					.imageToByteBuffer(ImageIO.read(DisplayManager.class.getResourceAsStream("/res/textures/icons/snarf32.png")), false, false, null) };
			Display.setIcon(icons);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ArrayList<DisplayMode> modeList = new ArrayList<DisplayMode>();
		DisplayMode[] modes = null;
		try {
			modes = Display.getAvailableDisplayModes();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		for (DisplayMode mode : modes) {
			if (mode.getFrequency() == 60)
				modeList.add(mode);
		}
		DisplayMode displayMode = new DisplayMode(0, 0);
		for (DisplayMode mode : modeList)
			if (mode.getWidth() > displayMode.getWidth())
				displayMode = mode;

		try {
			Display.setDisplayMode(displayMode);
			Display.setFullscreen(true);
			Display.setVSyncEnabled(true);
			Display.create(new PixelFormat(), attribs);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		GL11.glViewport(0, 0, displayMode.getWidth(), displayMode.getHeight());

	}

	public static void updateDisplay() {
		Display.sync(Config.MAX_FPS);
		Display.update();
	}

	public static void closeDisplay() {
		Display.destroy();
	}

}
