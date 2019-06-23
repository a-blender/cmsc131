package cmscMarqueeLib;
import java.awt.*;
public class ConfigValues {
    public static final int DEFAULT_FRAME_XCOORD          = 100;
    public static final int DEFAULT_FRAME_YCOORD          = 200;
    public static final int DEFAULT_DISPLAY_CELL_SIZE     = 6;
    public static final int EMPTY_COLUMNS_BETWEEN_CHARS   = 1;
    public static final int CHARACTER_WIDTH               = 9;
    public static final int CHARACTER_HEIGHT              = 10;
    public static final int DEFAULT_MARQUEE_SIZE_IN_CHARS = 8;
    public static final int MARQUEE_HEIGHT = CHARACTER_HEIGHT;
    public static final int MARQUEE_WIDTH  
    		              = (DEFAULT_MARQUEE_SIZE_IN_CHARS * CHARACTER_WIDTH) + 
    		                ((DEFAULT_MARQUEE_SIZE_IN_CHARS*EMPTY_COLUMNS_BETWEEN_CHARS)-
    		                  EMPTY_COLUMNS_BETWEEN_CHARS);
    public static final Color FOREGROUND_COLOR = Color.RED;
    public static final Color BACKGROUND_COLOR = Color.WHITE;
    public static int FRAME_WIDTH_PADDING = 8; 
    public static int FRAME_HEIGHT_PADDING = 45;
}