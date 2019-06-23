//MEDIA RENTAL MANAGER CLASS
//@author Anna Blendermann
package mediaRentalManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * MediaRentalManager implments the interface
 * adds customers and media to the database of arraylists
 * @author anna
 */
public class MediaRentalManager implements MediaRentalManagerInt
{
	/*
	 * create two arraylists to represent your mediarental database, 
	 * one with customer objects and the other with media objects 
	 * also set the limited plan limit to 2 movies/albums 
	 */
	ArrayList<Customer> customer_list = new ArrayList<Customer>();
	ArrayList<Media> media_list = new ArrayList<Media>();
	int plan_limit = 2;

	//ADD CUSTOMER METHOD********************************************
	/**
	 * addCustomer adds customers to the database
	 * @param customer name, address, and system plan
	 */
	public void addCustomer(String name, String address, String plan) {
		//add new Customer object to first arraylist
		customer_list.add(new Customer(name,address,plan));
	}

	//ADD MOVIE METHOD************************************************
	/**
	 * addMovie adds movies to the database 
	 * @param media title, copiesAvailable, and media rating
	 */
	public void addMovie(String title, int copiesAvailable, String rating) {
		//add new Movie object to second arraylist	
		media_list.add(new Movie(title, copiesAvailable, rating));
	}

	//ADD ALBUM METHOD****************************************************
	/**
	 * addAlbum adds album to the database
	 * @param media title, copiesAvailable, album artist, and songs
	 */
	public void addAlbum(String title, int copiesAvailable, String artist,
			String songs) {
		//create new Album object and add to media_list
		media_list.add(new Album(title, copiesAvailable, artist, songs));		
	}

	//SET LIMITED PLAN LIMIT METHOD****************************************
	/**
	 * setLimitedPlan sets the customer limit plan
	 * @param value - new limit plan
	 */
	public void setLimitedPlanLimit(int value) {
		this.plan_limit = value;
	}

	//GET ALL CUSTOMERS INFO METHOD*****************************************
	/**
	 * getAllCustomersInfo returns string of customers in the database
	 */
	public String getAllCustomersInfo() {
		//build a header and return customer info in string form
		String customer_info = "***** Customers' Information *****";

		//sort that array to alphabetize the customer names
		Collections.sort(customer_list);

		//get all customers info in alphabetized order
		for(int x=0; x<customer_list.size(); x++)
			customer_info += "\n" + customer_list.get(x).toString(); 
		return customer_info;
	}

	//GET ALL MEDIA INFO**********************************************
	/**
	 * getAllMediaInfo returns string of all media in the database
	 */
	public String getAllMediaInfo() {
		//build a header and return media info in string form
		String media_info = "***** Media Information *****";

		//sort that array to alphabetize the media titles
		Collections.sort(media_list);

		//get all customers info in alphabetized order
		for(int x=0; x<media_list.size(); x++)
			media_info += "\n" + media_list.get(x).toString(); 

		return media_info;
	}

	//ADD TO QUEUE METHOD************************************************
	/**
	 * addToQueue adds media to the requested queue
	 * @param customer name, media title
	 */
	public boolean addToQueue(String customerName, String mediaTitle) {
		for(Customer customer : customer_list) 
		{
			if(customer.getName().equals(customerName)) 
			{
				for(Media media : media_list){
					if(media.getTitle().equals(mediaTitle) && media.getCopiesAvailable()>0)
						return customer.addQueue(media);
				} 
			} 
		}
		return false;
	} //end of addToQueue method

	//REMOVE FROM QUEUE METHOD********************************************
	/**
	 * removeFromQueue removes media from the requested queue
	 * @param customer name, media title
	 */
	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) 
	{
		for(Customer customer : customer_list) 
		{
			if(customer.getName().equals(customerName)) 
			{
				for(Media media : media_list){
					if(media.getTitle().equals(mediaTitle) && media.getCopiesAvailable()>0)
						return customer.removeQueue(media);
				} 
			} 
		}
		return false;
	} //end of remove from queue method


	//PROCESS REQUESTS METHOD*****************************************
	/**
	 * processRequests doesn't have any parameters, but processes customer requests
	 * this method sorts data and moves media from requested queue to rented queue
	 */
	public String processRequests() 
	{
		//NOTE: if movies are already in the queue, then they
		//have copies available to be rented

		Collections.sort(customer_list); //sort the customer list

		String result = "";
		for (Customer customer : customer_list) {
			ArrayList<String> queue = customer.getQueue();
			ArrayList<String> rented = customer.getRented();
			ArrayList<String> remove = new ArrayList<String>();

			if (queue.size() > 0) { //if queue size is greater than zero
				if (customer.getPlan().equals("UNLIMITED")) { //customer has unlimited plan
					for (String s : queue) { //iterate through queue
						for (int a = 0; a < media_list.size(); a++) {
							if (media_list.get(a).getTitle().equals(s) && media_list.get(a).getCopiesAvailable() > 0) {
								rented.add(media_list.get(a).getTitle());
								remove.add(media_list.get(a).getTitle());
								media_list.get(a).setCopiesAvailable((media_list.get(a).getCopiesAvailable() - 1));
								result += "Sending " + media_list.get(a).getTitle() + " to " + customer.getName() + "\n";
							}
						}
					}
				} 
				else { //if the customer has a limited plan
					int rent = plan_limit - rented.size();
					for (int x = 0; ((x < queue.size() && rent > 0)); x++, rent--) {
						for (int a = 0; a < media_list.size(); a++) {
							if (media_list.get(a).getTitle().equals(queue.get(x)) && media_list.get(a).getCopiesAvailable() > 0) {
								media_list.get(a).setCopiesAvailable((media_list.get(a).getCopiesAvailable() - 1));
								remove.add(queue.get(x));
								rented.add(queue.get(x));
							}
						}
						result += "Sending " + queue.get(x) + " to " + customer.getName() + "\n";
					}
				}
				for (String remove1 : remove) {
					queue.remove(remove1);
				}
			}
		}
		return result;
	} //end of method

	//RETURN MEDIA METHOD***********************************************
	/**
	 * returnMedia removes media from the rented queue
	 * this method also adds media back into the database by calling setCopies
	 * @param customer name, media title
	 */
	public boolean returnMedia(String customerName, String mediaTitle) 
	{
		for(Customer customer : customer_list) 
		{
			if(customer.getName().equals(customerName)) 
			{
				for(Media media : media_list){
					if(customer.getRented().contains(mediaTitle)
							&& media.getTitle().equals(mediaTitle)) {
						media.setCopiesAvailable(media.getCopiesAvailable()+1);
						return (customer.getRented().remove(mediaTitle)); } 
				} 
			} 
		}
		return false;
	}

	//SEARCH MEDIA METHOD*************************************************
	/**
	 * searchMedia returns media titles that match the requested search
	 * @param title, rating, artist, and songs (they could be null)
	 */
	public ArrayList<String> searchMedia(String title, String rating,
			String artist, String songs) {
		Collections.sort(media_list);
		ArrayList<String> array = new ArrayList<String>();

		for(Media media : media_list)
		{
			boolean title1, rating1, artist1, songs1;
			title1 = (title != null && title.equals(media.title));

			if(media instanceof Movie)
			{
				Movie mov = (Movie)media;
				rating1 = (rating != null && rating.equals(mov.getRating()));
				if(rating1)
					array.add(mov.title); //add title
			}
			if(media instanceof Album)
			{
				Album album = (Album)media;
				artist1 = (artist != null && artist.equals(album.getArtist()));
				songs1 = (songs != null && album.getSongs().indexOf(songs)!=-1);
				if(artist1 || songs1)
					array.add(album.title); //add title
			}
			if(title==null && rating==null && songs==null && artist==null || title1)
				array.add(media.title);
		} //end of for loop

		return array;
	} //end of searchMedia method


} //end of MediaRentalManager 
