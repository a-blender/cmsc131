import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import cmscMarqueeLib.Cell;
import cmscMarqueeLib.DataManager;

public class TestsSupport {    
    public static String runMarquee(DataManager dataManager, int stepsToComplete) {     
        /* Calling the step method several times */
        Cell[][] arrayResult, stepResult;
        StringBuffer buffer = new StringBuffer();
        
        arrayResult = dataManager.step();
        buffer.append("=====================================================================Step: 1\n");
        buffer.append(convertCellArrayToStr(arrayResult));
        buffer.append("\n");
        for (int i=0; i<stepsToComplete-1; i++) {
            stepResult = dataManager.step();
            buffer.append("=====================================================================Step: " + (i+2) + "\n");
            buffer.append(convertCellArrayToStr(stepResult));
            buffer.append("\n"); 
        }
        buffer.append("\n");
        
        return buffer.toString();
    }
    
    /**** Auxiliary methods *****/
    private static String convertCellArrayToStr(Cell[][] array) {
        StringBuffer result = new StringBuffer();
        int rowSize;
        for (int row=0; row<array.length; row++) {
            rowSize = array[row].length;
            for (int col=0; col<rowSize-1; col++) {
                result.append(array[row][col]);
            }
            if (rowSize != 0) {
                result.append(array[row][rowSize-1]);
            }
            result.append("\n");
        }
        
        return result.toString();
    }
            
    public static boolean correctResults(String filename, String results) {
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader fin = new BufferedReader(new FileReader(filename));
            int c;
            
            String line;
            while ((line = fin.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }
            
        }catch (IOException e) {
            System.out.println("File opening failed.");
            return false;
        } 
 
        if (results.equals(buffer.toString())) {
            return true;
        }
        
        return false;
    }
 
    public static boolean writeToFile(String filename, String message) {
        
       try {
           FileWriter output = new FileWriter(filename);
           output.write(message);
           output.close(); 
           
       } catch(IOException exception) { 
          System.out.println("ERROR: Writing to file " + filename + " failed.");
          return false;
       }
       return true;
   }    
}