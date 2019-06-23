//PhotoProcessingSys Class
//@author Anna Blenderman
package sysutilities;
import javax.swing.JOptionPane;

//PHOTO PROCESSING SYS CLASS**********************************************
public class PhotoProcessingSys
{
	private String name; //customer name variable
	private Address newobj; //customer address object
	private double balance;
	StringBuffer trans_log = new StringBuffer();
	private int trans_count = 1;

	//FOUR PARAMETER CONSTRUCTOR******************************************
	public PhotoProcessingSys(String name, String street, String city, String state, String zip)
	{
		this.name = name; //set customer name
		try //validate the passed address
		{
			if(name!=null || street!=null || city!=null || zip!=null)
				newobj = new Address(street, city, state, zip);
			else //address is invalid
				newobj = new Address(); //use default constructor
		}
		catch(IllegalArgumentException e1) {
			e1.printStackTrace(); }

	} //end of five-param constructor

	//DEFAULT CONSTRUCTOR************************************************
	public PhotoProcessingSys()
	{
		this.name = "NONAME";
		newobj = new Address(); //use default constructor
	}

	//TO STRING METHOD***************************************************
	public String toString()
	{
		String final_string = "Customer Name: " + this.name + "\n"
				+ "Customer Address: " + newobj.toString() + "\n"
				+ "Balance: " + getBalance();
		return final_string;
	}

	//IMAGE TRANSACTION METHOD8*******************************************
	public String imageTransaction(String imageName, String task, String taskOptions, boolean graphicalMode)
	{
		if(graphicalMode == true)
			PictureManager.graphicalModeOn(); //turn graphical mode on
		else if(graphicalMode == false)
			PictureManager.graphicalModeOff(); //turn graphical mode off

		if(task.equals("clear")) //clears the screen
		{
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			this.balance++; //increment balance by $1.00
			String clearTask = PictureManager.clearScreen();
			trans_log.append("Transaction #" + trans_count + ": " + clearTask);
			trans_count = trans_count + 1; //increment trans_count
			return clearTask; //return task
		}

		else if(task.equals("display")) //displays picture
		{
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			this.balance++; //increment balance by $1.00
			String displayTask = PictureManager.displayPicture(imageName);
			trans_log.append("Transaction #" + trans_count + ": " + displayTask);
			trans_count = trans_count + 1; //increment trans_count
			return displayTask; //return task
		}


		else if(task.equals("displayLast")) //displays last picture
		{
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			this.balance++; //increment balance by $1.00
			String displayLastTask = PictureManager.displayLastPicture();
			trans_log.append("Transaction #" + trans_count + ": " + displayLastTask);
			trans_count = trans_count + 1; //increment trans_count
			return displayLastTask; //return task
		}

		else if(task.equals("blackandwhite")) //displays black and white picture
		{
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			this.balance++; //increment balance by $1.00
			String contrastTask = PictureManager.displayPictureBlackWhitePosterize(imageName, true, false);
			trans_log.append("Transaction #" + trans_count + ": " + contrastTask);
			trans_count = trans_count + 1; //increment trans_count
			return contrastTask; //return task
		}

		else if(task.equals("posterize")) //displays posterized picture
		{
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			this.balance++; //increment balance by $1.00
			String posterizeTask = PictureManager.displayPictureBlackWhitePosterize(imageName, false, true);
			trans_log.append("Transaction #" + trans_count + ": " + posterizeTask);
			trans_count = trans_count + 1; //increment trans_count
			return posterizeTask; //return task
		}

		else if(task.equals("blackandwhiteposterize")) //displays both elements
		{
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			this.balance++; //increment balance by $1.00
			String contrastPosterizeTask = PictureManager.displayPictureBlackWhitePosterize(imageName, true, true);
			trans_log.append("Transaction #" + trans_count + ": " + contrastPosterizeTask);
			trans_count = trans_count + 1; //increment trans_count
			return contrastPosterizeTask; //return task
		}

		else if(task.equals("selectcolors")) //selects colors for picture
		{
			boolean red=false, green=false, blue=false;
			for(int x=0; x<taskOptions.length(); x++)
			{
				if(taskOptions.charAt(x)=='R' || taskOptions.charAt(x)=='r')
					red = true;
				if(taskOptions.charAt(x)=='G' || taskOptions.charAt(x)=='g')
					green = true;
				if(taskOptions.charAt(x)=='B' || taskOptions.charAt(x)=='b')
					blue = true;	
			}
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			this.balance = balance + 2; //increment balance by $2.00
			String colorTask = PictureManager.displayPictureSelectRedGreenBlue(imageName, red, green, blue);
			trans_log.append("Transaction #" + trans_count + ": " + colorTask);
			trans_count = trans_count + 1; //increment trans_count
			return colorTask; //return task
		}

		else //invalid option
		{
			if(graphicalMode == true)
				JOptionPane.showMessageDialog(null, "Continue");
			trans_log.append("Transaction #" + trans_count + ": Invalid photoProcessing option");
			trans_count = trans_count + 1; //increment trans_count
			return "Invalid photoProcessing option";
		}	

	} //end of image transactions method

	//GET TRANSACTIONS METHOD************************************************
	public String getTransactions()
	{		
		return "Image Transactions\n" + trans_log.toString();
	}

	//GET BALANCE METHOD*****************************************************
	public double getBalance()
	{
		return this.balance;
	}

} //end of PhotoProcessingSys class
