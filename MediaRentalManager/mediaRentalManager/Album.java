//ALBUM CLASS
//@author Anna Blendermann
package mediaRentalManager;

//ALBUM CLASS******************************************************
/**
 * Album class are attributes for album objects
 * @param title, copiesAvailable, artist, and songs
 */
public class Album extends Media implements Comparable<Media>
{
	//Define attributes for the album: title, copiesAvailable, artist, songs
	private String artist, songs;

	//ALBUM CONSTRUCTOR********************************************
	public Album(String title, int copiesAvailable, String artist, String songs) {
		super(title, copiesAvailable);
		this.artist = artist;
		this.songs = songs;
	}

	//GET ARTIST METHOD***********************************************
	/**
	 * getArtist returns album artist
	 * @return String
	 */
	public String getArtist() {
		return this.artist;
	}

	//GET SONGS METHOD************************************************
	/**
	 * getSongs returns string of album songs
	 * @return String
	 */
	public String getSongs() {
		return this.songs;
	}

	//TO STRING METHOD*************************************************
	/**
	 * toString returns string of album object
	 * @return String
	 */
	public String toString() {
		return("Title: " + title + ", Copies Available: " +
				copiesAvailable + ", Artist: " + this.artist
				+ ", Songs: " + this.songs); 
	}

	//COMPARE TOO METHOD************************************************
	/**
	 * compareTo compares albums to each other
	 * @return Integer 0, 1, or -1
	 */
	public int compareTo(Album title) {
		return this.title.compareTo(title.title);
	}
} //end of Movie class

