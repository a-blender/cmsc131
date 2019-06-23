package cmsc131PictureLib;
import cmsc131PictureLib.Picture;
import cmsc131PictureLib.PictureColor;

public class SelectComponents implements Picture {
	private Picture sourcePicture;
	private boolean red, green, blue;

	public SelectComponents(Picture basePicture, boolean theRed, boolean theGreen, boolean theBlue) {
		sourcePicture = basePicture;
		red = theRed;
		blue = theBlue;
		green = theGreen;
	}

	public PictureColor getColor(int x, int y) {
		PictureColor color = sourcePicture.getColor(x, y);
		return new PictureColor(red   ? color.getRed()  : 0.0,
								green ? color.getGreen(): 0.0, 
								blue  ? color.getBlue() : 0.0);
	}

	public int getWidth() {
		return sourcePicture.getWidth();
	}

	public int getHeight() {
		return sourcePicture.getHeight();
	}
}