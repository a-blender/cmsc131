
package cmsc131PictureLib;
/**
 * PictureColor - A color of a picture element (pixel)
 * 
 * @author Ben Bederson
 * @author Bill Pugh
 * Copyright (C) 2003 University of Maryland
 * 
 * @see Picture
 * @see Image
 * @see PictureUtil
 */
public class PictureColor {
	// Some useful basic colors
	public static PictureColor WHITE = new PictureColor(1.0, 1.0, 1.0);
	public static PictureColor BLACK = new PictureColor(0.0, 0.0, 0.0);
	public static PictureColor RED = new PictureColor(1.0, 0.0, 0.0);
	public static PictureColor BLUE = new PictureColor(0.0, 0.0, 1.0);
	public static PictureColor GREEN = new PictureColor(0.0, 1.0, 0.0);
	public static PictureColor YELLOW = new PictureColor(1.0, 1.0, 0.0);
	public static PictureColor CYAN = new PictureColor(0.0, 1.0, 1.0);
	public static PictureColor MAGENTA = new PictureColor(1.0, 0.0, 1.0);
	public static PictureColor GRAY = new PictureColor(0.5, 0.5, 0.5);

	private final int rgb;   // Internal representation of color

	//////////////////////////////////////////////////
	///////////////// PUBLIC API /////////////////////	
	//////////////////////////////////////////////////

	/**
	 * Construct a new color from red, green and blue components each in the range [0.0 - 1.0]
	 */
	public PictureColor(double red, double green, double blue) {
		this.rgb = (toInt(red) << 16) | (toInt(green) << 8) | (toInt(blue));
	}

	/**
	 * Primarily for internal use.
	 * Constructs a new color from a packed rgb representation of red, green and blue.
	 */
	public PictureColor(int rgb) {
		this.rgb = 0xffffff & rgb;
	}

	/**
	 * Primarily for internal use.
	 * Returns the color in packed rgb format.
	 * @return rgb
	 */
	public int getRGB() {
		return rgb;
	}

	/**
	 * Determines the red color component of this pixel.
	 * 
	 * @return The red color component of this pixel in the range [0.0 - 1.0]
	 *         (from black to red)
	 */
	public double getRed() {
		double red = toDouble(rgb >> 16);

		return red;
	}

	/**
	 * Determines the green color component of this pixel.
	 * 
	 * @return The green color component of this pixel in the range [0.0 - 1.0]
	 *         (from black to green)
	 */
	public double getGreen() {
		double green = toDouble(rgb >> 8);

		return green;
	}

	/**
	 * Determines the blue color component of this pixel.
	 * 
	 * @return The blue color component of this pixel in the range [0.0 - 1.0]
	 *         (from black to blue)
	 */
	public double getBlue() {
		double blue = toDouble(rgb);

		return blue;
	}

	public String toString() {
		return "PictureColor("
			+ getRed()
			+ ", "
			+ getGreen()
			+ ", "
			+ getBlue()
			+ ")";
	}

	//////////////////////////////////////////////////////////////
	///////////////// PRIVATE IMPLEMENTATION /////////////////////
	//////////////////////////////////////////////////////////////

	/**
	 * Converts a double color component in [0.0 - 1.0] to an integer in [0 - 255]
	 */
	private int toInt(double v) {
		if (v < 0.0)
			v = 0.0;
		else if (v > 1.0)
			v = 1.0;
		return (int) (v * 255);
	}

	/**
	 * Converts an int color component in [0 - 255] to a double [0.0 - 1.0]
	 */
	private double toDouble(int v) {
		return (0xff & v) / 255.0;
	}
}