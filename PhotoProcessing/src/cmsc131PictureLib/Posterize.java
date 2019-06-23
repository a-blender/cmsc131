package cmsc131PictureLib;

/**
 * Posterize - Creates a new picture by rounding up (to 1.0) or 
 *             rounding down (to 0.0) the color components of 
 *  		   the pixels.
 * @author CMSC131 Fall04
 * Copyright(C) 2004 University of Maryland
 */

public class Posterize implements Picture {
	Picture basePic;

	public Posterize(Picture basePicture) {
		basePic = basePicture;
	}

	public PictureColor getColor(int x, int y) {
		PictureColor origColor;
		double redValue = 0, greenValue = 0, blueValue = 0;

		origColor = basePic.getColor(x, y);

		// creating new pixel color (posterized)
		if (origColor.getRed() > 0.5)
			redValue = 1.0;

		if (origColor.getGreen() > 0.5)
			greenValue = 1.0;

		if (origColor.getBlue() > 0.5)
			blueValue = 1.0;

		return new PictureColor(redValue, greenValue, blueValue);
	}

	public int getWidth() {
		return basePic.getWidth();
	}

	public int getHeight() {
		return basePic.getHeight();
	}
}
