//MEDIA CLASS
//@author Anna Blendermann
package mediaRentalManager;

//MEDIA CLASS********************************************************
/**
 * Media Class is the manager for movies and albums
 * @author anna
 */
public class Media implements Comparable<Media>
{
	//Depending on the num of params, declare movie/album object
	protected String title; //title for the media
	protected int copiesAvailable; //copies available of the media

	//MOVIE CONSTRUCTOR***********************************************
	public Media(String title, int copiesAvailable) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}

	//GET TITLE METHOD*********************************************
	/**
	 * getTitle returns the media title
	 * @return String
	 */
	public String getTitle() {
		return this.title;
	}

	//GET COPIES AVAILABLE METHOD***********************************
	/**
	 * getCopiesAvailale returns the number of media copies
	 * @return Integer
	 */
	public int getCopiesAvailable() {
		return this.copiesAvailable;
	}

	//SET COPIES AVAILABLE METHOD*************************************
	/**
	 * setCopiesAvailable sets the copies variable
	 * @param new number of copies
	 */
	public void setCopiesAvailable(int copies) {
		this.copiesAvailable = copies;
	}

	//COMPARE TOO METHOD************************************************
	/**
	 * Override method compares media to each other
	 * @return Integer 0, 1 or -1
	 */
	public int compareTo(Media title) {
		return this.title.compareTo(title.title);
	}

} //end of Media class

