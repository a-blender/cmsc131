//MARQUEE DATA MANAGER
//@author Anna Blendermann
import java.awt.Color;
import cmscMarqueeLib.*;

//MARQUEE DATA MANAGER CLASS*********************************************
public class MarqueeDataManager implements DataManager
{
	private String message = ""; //message to display on marquee
	private int stepCount = 0; //number of steps that have passed

	private Cell[][] emptyArray;
	private Cell[][] messageArray;
	private Cell[][] paddedArray;
	private Cell[][] displayArray;

	//TWO PARAM CONSTRUCTOR***********************************************
	public MarqueeDataManager(String message, int animationPattern)
	{
		System.out.println("The constructor has been implemented!");

		//intialize passed parameters to field variables
		this.message = message.toUpperCase(); //message to display

		emptyArray = new Cell[ConfigValues.MARQUEE_HEIGHT][ConfigValues.MARQUEE_WIDTH];
		emptyArray = generateEmptyCellsArray();
		messageArray = createMessageArray(this.message);

		int length = message.length()*10-1, def_width = ConfigValues.MARQUEE_WIDTH;
		paddedArray = new Cell[ConfigValues.MARQUEE_HEIGHT][def_width*2+length];

		for(int row=0; row < emptyArray.length; row++) {
			for(int col=0; col < emptyArray[row].length; col++)
				paddedArray[row][col] = emptyArray[row][col];
		}
		for(int row=0; row < messageArray.length; row++) {
			for(int col=0; col < messageArray[row].length; col++)
				paddedArray[row][col + def_width] = messageArray[row][col];
		}
		for(int row=0; row < emptyArray.length; row++) {
			for(int col=0; col < emptyArray[row].length; col++)
				paddedArray[row][col + def_width + length] = emptyArray[row][col];
		}

		//PRINT AND THINGS
		for(int row=0; row < paddedArray.length; row++) {
			System.out.println();
			for(int col=0; col < paddedArray[row].length; col++)
				System.out.print(paddedArray[row][col]);
		}
	} //end of two-param constructor

	//STEP METHOD**********************************************************
	@Override
	public Cell[][] step() 
	{
		//Use cellArray as our sliding window for displayArray
		displayArray = new Cell[ConfigValues.MARQUEE_HEIGHT][ConfigValues.MARQUEE_WIDTH];

		//display letters for getStepCount() columns			
		for(int row=0; row < displayArray.length; row++)
		{
			for(int col=0; col < displayArray[row].length; col++)
				displayArray[row][col] = paddedArray[row][col + getStepCount()];
		}

		//need to account for the wrap around
		if(getStepCount() < message.length()*10-1 + 79)
			this.stepCount++;
		else
			this.stepCount = 1; //return step to zero

		return displayArray; //return 2d array of cell objects
	} //end of step method

	//APPEND ARRAYS METHOD*********************************************
	public Cell[][] appendArrays(Cell[][] first, Cell[][] second)
	{
		//return an array with rows from the first & second arrays
		//both arrays have the same number of rows, different num of columns
		Cell[][] newArray = new Cell[first.length][first[0].length+second[0].length];

		//append first array onto newArray
		for(int row=0; row < first.length; row++) {
			for(int col=0; col < first[row].length; col++)
				newArray[row][col] = first[row][col];
		}
		//append second array onto newArray
		for(int row=0; row < second.length; row++) {
			for(int col=0; col < second[row].length; col++)
				newArray[row][col + first[row].length] = second[row][col];
		}
		return newArray; //return appended array
	} //end of append arrays method

	//GENERATE EMPTY CELLS ARRAY METHOD***********************************
	public Cell[][] generateEmptyCellsArray()
	{
		//returns a Cell[][] array with cells that have the white color
		Cell[][] emptyArray = new Cell[ConfigValues.MARQUEE_HEIGHT][ConfigValues.MARQUEE_WIDTH];

		//generate entire marquee with white cells
		for(int row=0; row < emptyArray.length; row++)
		{
			for(int col=0; col < emptyArray[row].length; col++)
				emptyArray[row][col] = new Cell(Color.WHITE);
		}
		return emptyArray; //return white array
	}

	//CONVERT INT ARRAY METHOD*******************************************
	public Cell[][] convertIntArray(int[][] charArray)
	{
		Cell[][] convertArray = new Cell[charArray.length][charArray[0].length];
		//convert 2d integer array into a 2d cell object array
		for(int row=0; row < charArray.length; row++)
		{
			for(int col=0; col < charArray[row].length; col++)
			{	
				if(charArray[row][col] == 1) //these were reversed
					convertArray[row][col] = new Cell(Color.RED);
				else if(charArray[row][col] == 0)
					convertArray[row][col] = new Cell(Color.WHITE);
			}
		}
		return convertArray; //return converted array
	}

	//CREATE MESSAGE ARRAY***************************************************
	//GET STEPHAN AND CHRIS TO HELP YOU FIX THIS DAMN METHOD
	public Cell[][] createMessageArray(String message)
	{
		Cell[][] lettersArray = new Cell[ConfigValues.MARQUEE_HEIGHT][0];

		//append arrays of message letters to the left padding
		for(int x=0; x<message.length(); x++) //convert another letter
		{
			//1. convert letter into a 2d integer array
			int[][] charArray = Alphabet.toIntArray(message.charAt(x));

			//2. convert 2d integer array to array of cell objects
			Cell[][] tempArray = convertIntArray(charArray);

			//3. append 2d array of cell objects (one letter) to cellArray
			lettersArray = appendArrays(lettersArray, tempArray); //PROBlEM HERE

			//4. add column of white cells to letterArray
			Cell[][] oneColArray = new Cell[ConfigValues.MARQUEE_HEIGHT][1];

			for(int row=0; row < oneColArray.length; row++) {
				for(int col=0; col < oneColArray[row].length; col++)
					oneColArray[row][col] = new Cell(Color.WHITE);
			} //added one white column after the letter

			lettersArray = appendArrays(lettersArray, oneColArray);

		} //end of adding message letters to cellArray
		return lettersArray;
	} //end of createMessageArray method


	//GET STEP COUNT METHOD************************************************
	public int getStepCount()
	{
		return this.stepCount; //return step
	}

} //end of MarqueeDataManager class
