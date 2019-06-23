package cmsc131PictureLib;

/**
 * CombineTopBottom - Combines two pictures by placing the original pictures
 * side by side.
 * @author CMSC131 Fall04
 * Copyright (C) 2004 University of Maryland
 */
public class CombineTopBottom implements Picture {
	Picture topPicture, bottomPicture;

	public CombineTopBottom(Picture topPicture, Picture bottomPicture) {
		this.topPicture = topPicture;
		this.bottomPicture = bottomPicture;	
	}

	public PictureColor getColor(int x, int y) {
		PictureColor color;
		if (y < topPicture.getHeight())
			color = topPicture.getColor(x, y);
		else {
			color = bottomPicture.getColor(x, y - topPicture.getHeight());
		}
		return color;
	}

	public int getWidth() {
		return Math.max(topPicture.getWidth(), bottomPicture.getWidth());
	}

	public int getHeight() {
		return topPicture.getHeight() + bottomPicture.getHeight();
	}
}
