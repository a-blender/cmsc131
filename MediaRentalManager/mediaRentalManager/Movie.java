//MOVIE CLASS
//@author Anna Blendermann
package mediaRentalManager;

//MOVIE CLASS******************************************************
/**
 * Movie class are attributes for movie objects
 * @param title, copiesAvailable, and rating
 */
public class Movie extends Media implements Comparable<Media>
{
	private String rating; //movie rating

	//MOVIE CONSTRUCTOR********************************************
	public Movie(String title, int copiesAvailable, String rating)
	{ 
		super(title, copiesAvailable);
		this.rating = rating;
	}

	//GET RATING METHOD*********************************************
	/**
	 * getRating returns movie rating
	 * @return String
	 */
	public String getRating() {
		return this.rating;
	}

	//TO STRING METHOD**********************************************
	/**
	 * toString returns string of curent movie object
	 * @return String
	 */
	public String toString() {
		return ("Title: " + title + ", Copies Available: " +
				copiesAvailable + ", Rating: " + this.rating); 
	}

	//COMPARE TOO METHOD************************************************
	/**
	 * compareTo method compares movies to each other
	 * @return Integer 0, 1, -1
	 */
	public int compareTo(Movie title) {
		return this.title.compareTo(title.title);
	}

} //end of Movie class

