//CUSTOMER CLASS
//@author Anna Blendermann
package mediaRentalManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//CUSTOMER CLASS******************************************************
/**
 * Customer class is the recipe for a customer object
 * @author Anna Blendermann
 */
public class Customer extends MediaRentalManager implements Comparable<Customer> 
{
	/*
	 * Define a name, address, plan, and two lists (queues)
	 * which represents interests and rented movies, for the customer 
	 */
	String name, address, plan; //customer name, address, and rental plan
	ArrayList<String> rented_queue = new ArrayList<String>(); //list of 
	ArrayList<String> request_queue = new ArrayList<String>(); //list of media

	//THREE-PARAM CONSTRUCTOR****************************************
	public Customer(String name, String address, String plan)
	{
		//set the name, address, and customer plan
		this.name = name;
		this.address = address;
		this.plan = plan;
	}

	//GET NAME METHOD*************************************************
	/**
	 * getName returns name of customer
	 * @return
	 */
	public String getName() {
		return this.name; 
	}

	//GET ADDRESS METHOD***********************************************
	/**
	 * getAddress returns address of customer
	 * @return
	 */
	public String getAddress() {
		return this.address; 
	}

	//GET PLAN METHOD**************************************************
	/**
	 * getPlan returns customer's limit plan
	 * @return
	 */
	public String getPlan() {
		return this.plan; 
	}

	//GET QUEUE METHOD***************************************************
	/**
	 * getQueue returns request queue
	 * @return
	 */
	public ArrayList<String> getQueue() {
		return this.request_queue; 
	}

	//GET RENTED METHOD**************************************************
	/**
	 * getRented returns rented queue
	 * @return
	 */
	public ArrayList<String> getRented() {
		return this.rented_queue; 
	}

	//ADD TO QUEUE METHOD***********************************************
	/**
	 * addToQueue adds media to requested queue
	 * @param media title
	 * @return true or false
	 */
	public boolean addQueue(Media mediaTitle) {
		for(String str : request_queue) {
			if(str.equals(mediaTitle.title))
				return false; }
		return request_queue.add(mediaTitle.title); 
	}

	//REMOVE QUEUE METHOD********************************************
	/**
	 * removeQueue deletes media from requested queue
	 * @param mediaTitle
	 * @return true or false
	 */
	public boolean removeQueue(Media mediaTitle) {
		for(String str : request_queue) {
			if(str.equals(mediaTitle.title))
				return request_queue.remove(mediaTitle.title); ; }
		return false;
	}

	//ADD RENTED METHOD************************************************
	/**
	 * addRented moves media from requested queue to rented queue
	 * @param mediaTitle
	 * @return true or false
	 */
	public boolean addRented(Media mediaTitle) {

		for(Media media : media_list) {
			if(media.getTitle().equals(mediaTitle.title)) {
				media.setCopiesAvailable(media.getCopiesAvailable()-1);
				return (rented_queue.add(mediaTitle.title));
			}
		}
		return false;
	}

	//RETURN RENTAL METHOD*********************************************
	/**
	 * removeRented deletes media from the rented queue
	 * @param mediaTitle
	 * @return true or false
	 */
	public boolean removeRented(Media mediaTitle) {

		for(Media media : media_list) {
			if(media.title.equals(mediaTitle.title)) {
				media.setCopiesAvailable(media.getCopiesAvailable()+1);
				return (rented_queue.remove(mediaTitle.title)); 
			}
		}
		return false;
	}

	//TO STRING METHOD*************************************************
	/**
	 * toString method for the current customer
	 */
	public String toString() {
		return ("Name: " + name + ", Address: " + address 
				+ ", Plan: "+ plan + "\nRented: " + rented_queue 
				+ "\nQueue: " + request_queue);
	}

	//COMPARE TOO METHOD************************************************
	/**
	 * Override compareTo method for customer
	 */
	public int compareTo(Customer name) {
		return this.getName().compareTo(name.getName());
	}

} //end of Customer class

