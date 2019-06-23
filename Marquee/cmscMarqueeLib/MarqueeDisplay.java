package cmscMarqueeLib;
import java.awt.*;
import javax.swing.*;

public class MarqueeDisplay extends JPanel implements Display {
    private JFrame frame;
    private String title = "MarqueeDisplay";
  
    private int displayAreaWidthInPixels, displayAreaHeightInPixels;
    private int displayAreaWidthInCells, displayAreaHeightInCells;
    private Cell[][] displayCells;
    
    public MarqueeDisplay() {
        this(ConfigValues.MARQUEE_WIDTH, 
             ConfigValues.MARQUEE_HEIGHT);
    }
    public MarqueeDisplay(int displayAreaWidthInCells,
            			  int displayAreaHeightInCells){
        this.displayAreaWidthInCells  = displayAreaWidthInCells;
        this.displayAreaHeightInCells = displayAreaHeightInCells;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGUI();
			}
		});
    }
    
    public void displayMessage(Cell[][] displayCells) {
        this.displayCells = displayCells;
        repaint();
    }
    	
	public void paintComponent(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
		
		int numRows = displayAreaHeightInCells;
		int numCols = displayAreaWidthInCells;
		int cellHeight = ConfigValues.DEFAULT_DISPLAY_CELL_SIZE;
		int cellWidth  = ConfigValues.DEFAULT_DISPLAY_CELL_SIZE;
		
		/* Creating borderlines */
		g.setColor(Color.gray);
		g2.drawRect(0, 0, displayAreaWidthInPixels-1, displayAreaHeightInPixels-1);
		
		/* Drawing the cells array */
		if (displayCells != null) {
		    /* Validity check in case they are trying to pass invalid array */
		    if (displayCells.length != numRows || displayCells[0].length != numCols) {
		        String message = "ERROR: Invalid display cells array.";
		        message += "\nNumber of rows: " + displayCells.length;
		        message += "\nNumber of colums: " + displayCells[0].length;
		        message += "\nExpected rows: " + numRows;
		        message += "\nExpected columns: " + numCols;
		        JOptionPane.showMessageDialog(null, message);
		        System.exit(0);
		    } else {
				for (int row = 0; row < numRows; row++) {
					for (int col = 0; col < numCols; col++) {
						if (displayCells[row][col] != null) {
							g.setColor(displayCells[row][col].getColor());
							g.fill3DRect((int) (col * cellWidth), (int) (row * cellHeight), (int) (cellWidth), (int) (cellHeight), true);
						}
					}
				}
		    }
		}
	}
	
	private void createGUI() {
	    frame = new JFrame();
	    
        frame.setLocation(ConfigValues.DEFAULT_FRAME_XCOORD, ConfigValues.DEFAULT_FRAME_YCOORD);
        frame.setTitle(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // Setting the size of the panel
        displayAreaWidthInPixels  = displayAreaWidthInCells  * ConfigValues.DEFAULT_DISPLAY_CELL_SIZE;
        displayAreaHeightInPixels = displayAreaHeightInCells * ConfigValues.DEFAULT_DISPLAY_CELL_SIZE;
        this.setSize(new Dimension(displayAreaWidthInPixels, displayAreaHeightInPixels));
        frame.getContentPane().add(this);
        frame.setSize(displayAreaWidthInPixels + ConfigValues.FRAME_WIDTH_PADDING, 
        			  displayAreaHeightInPixels + ConfigValues.FRAME_HEIGHT_PADDING);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        frame.setVisible(true);
	}
}