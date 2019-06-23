package cmsc131PictureLib;

/**
 * CombineLeftRight - Combines two pictures into a single larger picture with
 * one input picture on the left and one input picture on the right
 * 
 * @author Ben Bederson
 * @author Bill Pugh
 * Copyright (C) 2003 University of Maryland
 */
public class CombineLeftRight implements Picture {
	Picture leftPic, rightPic;

	public CombineLeftRight(Picture leftPicture, Picture rightPicture) {
		leftPic = leftPicture;
		rightPic = rightPicture;
	}

	public PictureColor getColor(int x, int y) {
		PictureColor color;
		
		if (x < leftPic.getWidth()) {
			color = leftPic.getColor(x, y);
		} else {
			color = rightPic.getColor(x - leftPic.getWidth(), y);
		}
		
		return color;
	}

	public int getWidth() {
		return leftPic.getWidth() + rightPic.getWidth();
	}

	public int getHeight() {
		return Math.max(leftPic.getHeight(), rightPic.getHeight());
	}
}