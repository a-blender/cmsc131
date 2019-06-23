package cmscMarqueeLib;

import javax.swing.*;
public class Alphabet {
    private int characterHeight, characterWidth;
    private int[][] array;
    private static Alphabet alphabet = null;
    
    public static int[][] toIntArray(char inputChar) {
        if (alphabet == null) {
            alphabet = new Alphabet(ConfigValues.CHARACTER_WIDTH,
                    				ConfigValues.CHARACTER_HEIGHT);
        }
        
        return alphabet.mapCharToIntArray(inputChar);
    }
    
    public Alphabet(int characterWidth, int characterHeight) {
        if (characterWidth < 5 || characterHeight < 5) {
            String message = "Invalid character dimensions";
            JOptionPane.showInputDialog(null,message);
        }
        this.characterHeight = characterHeight;
        this.characterWidth = characterWidth;
    }
    
    public int[][] mapCharToIntArray(char inputChar) {
        array = new int[characterHeight][characterWidth];
        switch (inputChar) {
        	case 'A':
        	case 'a':
        	    upperBar();
        	    leftBar();
        	    rightBar(characterWidth-1);
        	    middleBar();
        	    break;
            case 'B':
            case 'b':
                upperBar();
                for (int r=0; r<characterHeight; r++)
        	        array[r][2]=1;
                lowerBar();
        	    for (int c=1;c<characterWidth; c++) 
        	        array[characterHeight/2][c] = 1;   
                rightBar(characterWidth-1);
                array[characterHeight/2][characterWidth-1]=0;
            	array[0][characterWidth-1] = 0;
            	array[characterHeight-1][characterWidth-1] = 0;
                break;
            case 'C':
            case 'c':
                upperBar();
            	leftBar();
            	lowerBar();
            	break;
            case 'D':
            case 'd':
                upperBar();
           	    for (int r=0; r<characterHeight; r++)
        	        array[r][1]=1;
            	lowerBar();
            	rightBar(characterWidth-1);
            	array[0][characterWidth-1] = 0;
            	array[characterHeight-1][characterWidth-1] = 0;
            	break;
        	case 'E':
        	case 'e':
        	    upperBar();
        	    leftBar();
        	    halfMiddleBar();
        	    lowerBar();
        	    break;
        	case 'F':
        	case 'f':
        	    upperBar();
        	    leftBar();
        	    halfMiddleBar();
        	    break;
           	case 'G':
           	case 'g':
        	    upperBar();
        	    leftBar();
        	    for (int c=2; c<characterWidth; c++)
        	        array[characterHeight/2 + 1][c] = 1;
                for (int r=characterHeight/2 + 1; r<characterHeight; r++)
        	        array[r][characterWidth-1]=1;
                lowerBar();
        	    break;
        	case 'H':
        	case 'h':
        	    leftBar();
        	    rightBar(characterWidth-1);
        	    middleBar();
        	    break;
        	case 'I':
        	case 'i':
        	    upperBar();
        	    rightBar(characterWidth/2);
        	    lowerBar();
        	    break;
        	case 'J':
        	case 'j':
        	    upperBar();
        	    rightBar(characterWidth-3);
        	    for (int c=0; c<characterWidth-2; c++)
        	        array[characterHeight-1][c] = 1;
                for (int r=characterHeight-3; r<characterHeight; r++)
        	        array[r][0]=1;
        	    break;
            case 'K':
            case 'k':
                leftBar();
                lowerRightParamDiagonal(characterWidth/2 - 3);
                
                int c=characterWidth-4;
                for (int r=0; r<characterHeight/2; r++) {
                    if (c >= characterWidth/2-3) {
                        array[r][c--] = 1;
                    }
                }        
                break;
            case 'L':
            case 'l':
                leftBar();
                lowerBar();
                break;
            case 'M':
            case 'm':
                leftBar();
                rightBar(characterWidth-1);
                upperLeftDiagonal();
                upperRightDiagonal();
                break;
                
            case 'N':
            case 'n':
                leftBar();
                c = 1;
                for (int r=1; r<characterHeight; r++) {
                    if (c <characterWidth) {
                        array[r][c] = 1;
                        c++;
                    }
                }
                array[characterHeight-1][characterWidth-1] = 1;
                rightBar(characterWidth-1);
                
                //leftDiagonal();
                break;
            case 'O':
            case 'o':
                leftBar();
                upperBar();
                lowerBar();
                rightBar(characterWidth-1);
                break;
            case 'P':
            case 'p':
                upperBar();
                middleBar();
                leftBar();
                for (int r=0; r<characterHeight/2; r++){
                   array[r][characterWidth-1] = 1;
                }
                break;
            case 'Q':
            case 'q':
                upperBar();
                lowerBar();
                leftBar();
                rightBar(characterWidth-1);
                int col = characterWidth/2;
                for (int r=characterHeight/2+2; r<characterHeight; r++) {
                    if (col < characterWidth)
                        array[r][col++] = 1;
                }
                break;
            case 'R':
            case 'r':
                leftBar();
        	    for (col=0; col<characterWidth; col++) {
        	        array[0][col] = 1;
        	    }
                for (int r=0; r<characterHeight/2; r++){
                    array[r][characterWidth-1] = 1;
                }
                lowerRightDiagonal();
        	    for (int r=0;r<characterWidth; r++) 
        	        array[characterHeight/2][r] = 1;       
                break;
            case 'S':
            case 's':
                upperBar();
                lowerBar();
                middleBar();
                for (int r=0; r<characterHeight/2; r++) {
                    array[r][0] = 1;
                }
                for (int r=characterHeight/2; r<characterHeight; r++) {
                    array[r][characterWidth-1] = 1;
                }
                break;
            case 'T':
            case 't':
                upperBar();
                for (int r=0; r<characterHeight; r++) {
                    array[r][characterWidth/2] = 1;
                }
                break;
            case 'U':
            case 'u':
                leftBar();
                rightBar(characterWidth-1);
                lowerBar();
                break;
            case 'V':
            case 'v':
                c = 0;
                int times = 0;
                for (int r=0; r<characterHeight && c<=characterWidth/2; r++) {
                    array[r][c] = 1;
                    array[r][characterWidth-1-c] = 1;
                    if (times == 2) {
                        times = 0;
                        c++;
                    }
                    times++;
                }
                break;
            case 'W':
            case 'w':
                leftBar();
                rightBar(characterWidth-1);
                lowerRightDiagonal();
                lowerLeftDiagonal();
                break;
            case 'X':
            case 'x':
                rightDiagonal();
                leftDiagonal();
                break;
            case 'Y':
            case 'y':
                upperLeftDiagonal();
                upperRightDiagonal();
                for (int r=characterHeight/2-1; r<characterHeight; r++)
                    array[r][characterWidth/2] = 1;
                break;
            case 'Z':
            case 'z':
                upperBar();
                lowerBar();
                rightDiagonal();
                break;
        	case ' ':
                break;
            default:
                JOptionPane.showInputDialog(null, "Alphabet: invalid character");
                break;
        }
        
        return array;
    }
    
    private void upperBar() {
	    for (int c=0; c<characterWidth; c++) 
	        array[0][c] = 1;
    }
   
    private void leftBar() {
   	    for (int r=0; r<characterHeight; r++)
	        array[r][0]=1;
    }
    
    private void rightBar(int offset) {
   	    for (int r=0; r<characterHeight; r++)
	        array[r][offset]=1;
    }
    
    private void halfMiddleBar() {
	    for (int r =0;r<=characterWidth/2; r++) 
	        array[characterHeight/2][r] = 1;        
    }
    
    private void middleBar() {
	    for (int r =0;r<characterWidth; r++) 
	        array[characterHeight/2][r] = 1;        
    }

    private void lowerBar() {
	    for (int c=0; c<characterWidth; c++) 
	        array[characterHeight-1][c] = 1;       
    }
    
    private void upperLeftDiagonal() {
        int c=0;
        for (int r=0; r<characterHeight/2; r++) {
            if (c <= characterWidth/2) {
                array[r][c++] = 1;
            }
        }
    }
    
    private void upperRightDiagonal() {
        int c=characterWidth-1;
        for (int r=0; r<characterHeight/2; r++) {
            if (c >= characterWidth/2) {
                array[r][c--] = 1;
            }
        }        
    }
    
    private void lowerLeftDiagonal() {
        int c=characterWidth/2;
        for (int r=characterHeight/2; r<characterHeight; r++) {
            if (c >= 0) {
                array[r][c--] = 1;
            }
        }
    }
    
    private void lowerRightDiagonal() {
        int c=characterWidth/2;
        for (int r=characterHeight/2; r<characterHeight; r++) {
            if (c >= 0 && c<characterWidth) {
                array[r][c++] = 1;
            }
        }        
    }

    private void lowerRightParamDiagonal(int c) {
        for (int r=characterHeight/2; r<characterHeight; r++) {
            if (c >= 0) {
                array[r][c++] = 1;
            }
        }        
    }
    
    private void rightDiagonal() {
        int c = characterWidth-1;
        for (int r=0; r<characterHeight; r++) {
            if (c >= 0) {
                array[r][c--] = 1;
            }
        }
        array[characterHeight-1][0] = 1;
    }
    
    private void leftDiagonal() {
        int c = 0;
        for (int r=0; r<characterHeight; r++) {
            if (c <characterWidth) {
                array[r][c++] = 1;
            }
        }
        array[characterHeight-1][characterWidth-1] = 1;
    }
    
    private static void printArray(int[][] array) {
        for (int r=0; r<array.length; r++) {
            for (int c=0; c<array[r].length; c++) {
                if (array[r][c] != 0)
                   System.out.print(array[r][c]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] array = new Alphabet(7, 9).mapCharToIntArray('E');
        printArray(array);
    }
}