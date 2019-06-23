package cmsc131PictureLib;

/**
 * Picture - interface to specify the content of a picture.
 * 
 * @author Ben Bederson
 * @author Bill Pugh
 * Copyright (C) 2003 University of Maryland
 * 
 * @see PictureColor
 * @see Image
 * @see PictureUtil
 */
public interface Picture {
	/**
	 * This specifies the content of a picture by returning the color
	 * of the picture at each pixel (i.e., position).
	 * @param x The column within the picture
	 * @param y The row within the picture
	 * @return The color of the picture at the specified location
	 */
	public PictureColor getColor(int x, int y);
	public int getWidth();
	public int getHeight();
}