package cmsc131PictureLib;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.*;


import java.util.*;

/**
 * PictureUtil - a class for displaying Picture's.  Each new picture is displayed
 * in a separate frame, layed out in a grid on the screen.
 * <p>
 * Motivated by the JavaPicture class from
 * <a href="http://coweb.cc.gatech.edu/cs1315">Georgia Tech's Media
 * Computation class</a>
 * 
 * @author Ben Bederson
 * @author Bill Pugh
 * Copyright (C) 2003 University of Maryland
 * 
 * @see Picture
 * @see PictureColor
 * @see Image
 */
public class PictureUtil {
	//////////////////////////////////////////////////
	///////////////// PUBLIC API /////////////////////	
	//////////////////////////////////////////////////

	private static ArrayList frameList = new ArrayList();
	private static Picture lastPicture = null;
	
	/**
	 * Displays a picture with title
	 * 
	 * @param picture The picture to show
	 * @param title The title in the window frame
	 */
	public static void show(Picture picture, String title) {
		MyFrame frame = new MyFrame(picture, title);
		frameList.add(frame);
	}

	/**
	 * Displays a picture.  Title is extracted from class name of picture.
	 * 
	 * @param picture The picture to show
	 */
	public static void show(Picture picture) {
		String title = picture.getClass().getName();
		int i = title.lastIndexOf('.');
		title = title.substring(i + 1);
		lastPicture = picture;
		show(picture, title);
	}

	/**
	 * Clear all the pictures on the screen.
	 * 
	 */
	public static void clearScreen() {
		Iterator iterator = frameList.iterator();
		while (iterator.hasNext()) {
			((MyFrame)iterator.next()).clear();
		}
	}
	
	/**
	 * Returns the last picture displayed. 
	 * @return Reference to last picture displayed.
	 */
	
	public static Picture getLastPicDisplayed() {
		return lastPicture;
	}
	
	/**
	 * Returns true is any picture has been displayed. 
	 * @return true is any picture has been displayed false otherwise.
	 */
	
	public static boolean anyPicDisplayed() {
		if (lastPicture != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Saves the specified picture to the specified file as a JPEG image.  
	 * The file can be specified as an absolute path, or a relative path 
	 * (in which case it will get saved in a location relative to where 
	 * this program is run from.  If the file doesn't end in ".jpg", then
	 * that extension will be added.
	 * 
	 * @param picture The picture to be saved
	 * @param fileName The name of the file to save the picture in.
	 */
	public static void save(Picture picture, String fileName) {
		if (!fileName.endsWith(".jpg")) {
			fileName = fileName + ".jpg";
		}
		BufferedImage image = createImage(picture);
		File file = new File(fileName);
		try {
			ImageIO.write(image, "jpg", file);
		} catch (Exception e) {
			throw new RuntimeException("Unable to save " + fileName);			
		}
	}
	
	/**
	 * Internal utility method to display exceptions to the screen in a pop-up window.
	 * @param ex The exception
	 */
	static public void showException(Exception ex) {
		System.out.println(ex);
		ex.printStackTrace();
		
		StringBuffer msgBuffer = new StringBuffer();
		msgBuffer.append(ex.toString());
		msgBuffer.append("\n");
		StackTraceElement[] elements = ex.getStackTrace();
		for (int i=0; i<elements.length; i++) {
			msgBuffer.append(elements[i].toString());
			msgBuffer.append("\n");
		}
		JOptionPane.showMessageDialog(null, msgBuffer.toString(), "alert", JOptionPane.ERROR_MESSAGE);
	}

	
	//////////////////////////////////////////////////////////////
	///////////////// PRIVATE IMPLEMENTATION /////////////////////
	//////////////////////////////////////////////////////////////
	
	static private BufferedImage createImage(Picture p) {
		BufferedImage image;
		image = new BufferedImage(p.getWidth(), p.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		try {
			for (int row = 0; row < p.getHeight(); row++) {
				for (int col = 0; col < p.getWidth(); col++) {
					PictureColor color = p.getColor(col, row);
					image.setRGB(col, row, color.getRGB());
				}
			}
		} catch (Exception ex) {
			showException(ex);
		}

		return image;
	}
	
	static private class MyFrame extends JPanel {
		// Space between picture frames
		final static int SPACE_HOR = 30;
		final static int SPACE_VER = 70;
		
		// Distance between pictures and edge of screen
		final static int BUFFER_HOR = 50;
		final static int BUFFER_VER = 50;
		
		// Position of next picture to display
		static int x = BUFFER_HOR;
		static int y = BUFFER_VER;
		static int maxHeight = 0;         // Maximum height of picture in current row

		// Image and size of image to display
		BufferedImage image;
		Dimension size;
		JFrame frame;

		/**
		 * Constructor creates a frame containing specified picture and title
		 */
		MyFrame(Picture p, String title) {
			setBackground(Color.gray);
			image =	PictureUtil.createImage(p);
			
			// Create a top-level window to put the picture in
			frame = new JFrame(title);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.setContentPane(this);

			maxHeight = Math.max(maxHeight, p.getHeight() + SPACE_VER);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			if ((x > 0) && ((x + p.getWidth()) > screenSize.getWidth())) {
				y += maxHeight;
				x = BUFFER_HOR;
				maxHeight = 0;
			}
			frame.setLocation(x, y);
			x += p.getWidth() + SPACE_HOR;
			size = new Dimension(p.getWidth(), p.getHeight());
			frame.pack();
			frame.show();
		}

		/**
		 * Removes the picture. 
		 */
		
		public void clear() {
			frame.dispose();
			x = BUFFER_HOR;
			y = BUFFER_VER;
		}
		
		/**
		 * Tells Java how big picture frame should be.
		 */
		public Dimension getPreferredSize() {
			return size;
		}

		/**
		 * This paints the actual image
		 */
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, null);
		}
	}
}