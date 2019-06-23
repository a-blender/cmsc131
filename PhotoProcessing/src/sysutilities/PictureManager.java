package sysutilities;

import javax.swing.*;
import cmsc131PictureLib.*;

public class PictureManager {
	private static boolean GRAPHICAL_MODE = true;

	public static void graphicalModeOff() {
		GRAPHICAL_MODE = false;
	}

	public static void graphicalModeOn() {
		GRAPHICAL_MODE = true;
	}

	public static void main(String[] args) {
		graphicDemo();
		nonGraphicDemo();
	}

	public static void graphicDemo() {
		PictureManager.displayPicture("testudo.jpg");
		PictureManager.displayPicture("http://www.cs.umd.edu/sites/all/themes/cs/logo.png");
		JOptionPane.showMessageDialog(null, "Press OK to clear screen");
		PictureManager.clearScreen();
		JOptionPane.showMessageDialog(null, "Press OK to display last picture");
		PictureManager.displayLastPicture();
		PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", true, false);
		PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", true, true);
		PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", false, false);
		PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", false, true);
		PictureManager.displayPictureSelectRedGreenBlue("testudo.jpg", true, false, false);
	}

	public static void nonGraphicDemo() {
		StringBuffer activity = new StringBuffer();
		PictureManager.graphicalModeOff();

		activity.append(PictureManager.displayPicture("testudo.jpg"));
		activity.append(PictureManager.displayPicture("http://www.cs.umd.edu/sites/all/themes/cs/logo.png"));
		JOptionPane.showMessageDialog(null, "Press OK to clear screen");
		PictureManager.clearScreen();
		JOptionPane.showMessageDialog(null, "Press OK to display last picture");
		activity.append(PictureManager.displayLastPicture());
		activity.append(PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", true, false));
		activity.append(PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", true, true));
		activity.append(PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", false, false));
		activity.append(PictureManager.displayPictureBlackWhitePosterize("testudo.jpg", false, true));
		activity.append(PictureManager.displayPictureSelectRedGreenBlue("testudo.jpg", true, false, false));

		System.out.println(activity);
	}

	public static String displayPicture(String name) {
		if (GRAPHICAL_MODE) {
			PictureUtil.show(new Image(name));
		}

		return "Display " + name + "\n";
	}

	public static String clearScreen() {
		if (GRAPHICAL_MODE) {
			PictureUtil.clearScreen();
		}

		return "clearScreen\n";
	}

	public static String displayLastPicture() {
		if (GRAPHICAL_MODE) {
			PictureUtil.show(PictureUtil.getLastPicDisplayed());
		}

		return "displayLastPicture\n";
	}

	public static String displayPictureBlackWhitePosterize(String name, boolean blackAndWhite, boolean posterize) {
		if (GRAPHICAL_MODE) {
			Picture result = new Image(name);
			if (blackAndWhite) {
				result = new BlackAndWhite(result);
			}
			if (posterize) {
				result = new Posterize(result);
			}
			PictureUtil.show(result);
		}

		return "displayPictureBlackWhitePosterize: " + name + ", " + blackAndWhite + posterize + "\n";
	}

	public static String displayPictureSelectRedGreenBlue(String name, boolean red, boolean green, boolean blue) {
		if (GRAPHICAL_MODE) {
			PictureUtil.show(new SelectComponents(new Image(name), red, green, blue));
		}
		
		return "displayPictureSelectRedGreenBlue: " + name + ", " + red + green + blue + "\n";
	}
}