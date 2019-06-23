package cmscMarqueeLib;

import java.awt.*;

/* Immutable class */
public class Cell {
	private Color color;

	public Cell(Color color) {
	    this.color = color;
	}
	
	public Color getColor() {
	    return color;
	}
	
	public String toString() {
	    if (color == ConfigValues.FOREGROUND_COLOR) {
	        return "1";
	    } else if (color == ConfigValues.BACKGROUND_COLOR) {
	        return " ";
	    } else {
	        return "X";
	    }
	}
	
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else if (!(obj instanceof Cell)) {
			return false;
		} else {
			Cell c = (Cell)obj;
			return color == c.color;
		}
	}
	
	public static void main(String[] args) {
	    Cell c1 = new Cell(Color.RED);
	    System.out.println(c1);
	    
	    Cell c2= new Cell(Color.WHITE);
	    System.out.println(c2);
	    
	    if (c1.equals(c2)) {
	        System.out.println("EQUALS METHOD SAME 1");
	    } else {
	        System.out.println("EQUALS METHOD DIFFERENT 1");
	    }
	    
	    Cell c3 = new Cell(Color.RED);
	    if (c1.equals(c3)) {
	        System.out.println("EQUALS METHOD SAME 2");
	    }
	}
}