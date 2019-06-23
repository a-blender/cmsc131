package cmsc131PictureLib;


public class BlackAndWhite implements Picture {
	Picture sourcePicture;

	public BlackAndWhite(Picture basePicture) {
		sourcePicture = basePicture;
	}
	
	public PictureColor getColor(int x, int y) {
		PictureColor color = sourcePicture.getColor(x, y);
		double avg = (color.getRed() + color.getGreen() + color.getBlue())/3;
		return new PictureColor(avg, avg, avg);
	}

	public int getWidth() {
		return sourcePicture.getWidth();
	}

	public int getHeight() {
		return sourcePicture.getHeight();
	}
}