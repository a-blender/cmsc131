package cmsc131PictureLib;

import java.net.*;
import java.awt.*;
import java.awt.image.*;

/**
 * Image - A picture created from an image.
 * 
 * @author Ben Bederson
 * @author Bill Pugh
 * Copyright (C) 2003 University of Maryland
 * 
 * @see Picture
 * @see PictureColor
 * @see PictureUtil
 */
public class Image implements Picture {
	//////////////////////////////////////////////////
	///////////////// PUBLIC API /////////////////////	
	//////////////////////////////////////////////////

	private BufferedImage img;
	private PictureColor backgroundPictureColor;

	/**
	 * Constructs a new picture from image at specified location
	 * @param imageLocation Can be URL or local filename of GIF, JPG, or PNG image
	 */
	public Image(String imageLocation) {
		this(imageLocation, PictureColor.GRAY);
	}
	
	/**
	 * Constructs a new picture from image at specified location with a given background color
	 * @param imageLocation Can be URL or local filename of GIF, JPG, or PNG image
	 * @param backgroundColor Specifies color of image outside of input image bounds
	 */
	public Image(String imageLocation, PictureColor backgroundColor) {
		backgroundPictureColor = backgroundColor;
		try {
			img = loadImage(imageLocation);
		} catch (Exception ex) {
			PictureUtil.showException(ex);
		}
	}
	
	/**
	 * @see Picture#getColor(int, int)
	 */
	public PictureColor getColor(int x, int y) {
		if ((img != null) && (x >= 0) && (x < img.getWidth(null)) && (y >= 0) && (y < img.getHeight(null))) {
			return new PictureColor(img.getRGB(x, y));
		}
		return PictureColor.GRAY;
	}

	/**
	 * @see Picture#getWidth()
	 */
	public int getWidth() {
		return img.getWidth();
	}

	/**
	 * @see Picture#getHeight()
	 */
	public int getHeight() {
		return img.getHeight();
	}

	/**
	 * Specifies the background color of the picture.  That is,
	 * the color returned past the boundaries of the picture. 
	 * @return the bacground color of the picture
	 */
	public PictureColor getBackgroundColor() {
		return backgroundPictureColor;
	}

	//////////////////////////////////////////////////////////////
	///////////////// PRIVATE IMPLEMENTATION /////////////////////
	//////////////////////////////////////////////////////////////

	/**
	 * Loads the specified image. The new image will replace any previous
	 * image.
	 * 
	 * @param imageName Can be either a local filename or a URL 
	 * of a GIF, JPG, or PNG image.
	 */
	private static BufferedImage loadImage(String imageName) {
		java.awt.Image origImage = null;
		BufferedImage img = null;

		if (imageName.startsWith("http://")) {
				URL imageURL;
				try {
					imageURL = new URL(imageName);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
					throw new RuntimeException(e1);
				}
				origImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			
		} else {
			origImage = Toolkit.getDefaultToolkit().getImage(imageName);
		}

		// Java normally loads images in a background thread.
		// This waits for the image to finish loading.
		try {
			MediaTracker tracker = new MediaTracker(new Panel());
			tracker.addImage(origImage, 0);
			tracker.waitForID(0);
			if (tracker.statusID(0,true) != MediaTracker.COMPLETE) { 
				throw new RuntimeException("Unable to load " + imageName);
			}
		} catch(InterruptedException e) {
			// won't be interrupted
		}


		// If image loaded, then create a BufferedImage which is modifiable
		int imageWidth = origImage.getWidth(null);
		int imageHeight = origImage.getHeight(null);
		if ((origImage != null) && (imageWidth > 0) && (imageHeight > 0)) {
			img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			g.drawImage(origImage, 0, 0, null);
		}
		
		return img;
	}
}