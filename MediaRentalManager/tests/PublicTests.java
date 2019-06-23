package tests;
import mediaRentalManager.MediaRentalManager;
import junit.framework.TestCase;
import java.util.ArrayList;

public class PublicTests extends TestCase {

	public void testAddingCustomers() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();		
		loadCustomersData(manager);

		resultsBuffer.append(manager.getAllCustomersInfo());

		assertTrue(TestingSupport.correctResults("pubTestAddingCustomers.txt", resultsBuffer.toString()));
	}

	public void testAddingMedia() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();		
		loadMediaData(manager);

		resultsBuffer.append(manager.getAllMediaInfo());

		assertTrue(TestingSupport.correctResults("pubTestAddingMedia.txt", resultsBuffer.toString()));
	}

	public void testingAddingToQueue() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadCustomersData(manager);
		loadMediaData(manager);

		resultsBuffer.append(manager.getAllCustomersInfo() + "\n");

		if (!manager.addToQueue("Smith, John", "Jaws")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Rocky")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Bad")) {
			resultsBuffer.append("Failed to add to queue");
		}
		resultsBuffer.append("After adding to queues\n");
		resultsBuffer.append(manager.getAllCustomersInfo());

		assertTrue(TestingSupport.correctResults("pubTestAddingToQueue.txt", resultsBuffer.toString()));
	}

	public void testingRemovingFromQueue() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadCustomersData(manager);
		loadMediaData(manager);

		if (!manager.addToQueue("Smith, John", "Rocky")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Rocky")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Journey")) {
			resultsBuffer.append("Failed to add to queue");
		}

		resultsBuffer.append("After adding to queues\n");
		resultsBuffer.append(manager.getAllCustomersInfo());

		manager.removeFromQueue("Albert, Mike", "Rocky");
		resultsBuffer.append("After removing from queue\n");

		resultsBuffer.append(manager.getAllCustomersInfo());

		assertTrue(TestingSupport.correctResults("pubTestRemovingFromQueue.txt", resultsBuffer.toString()));
	}

	public void testProcessingRequestsOne() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadCustomersData(manager);
		loadMediaData(manager);

		if (!manager.addToQueue("Smith, John", "Jaws")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Smith, John", "Mickey")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Smith, John", "Gone with the Wind")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Rocky")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Bad")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Journey")) {
			resultsBuffer.append("Failed to add to queue");
		}

		resultsBuffer.append("After adding to queues\n");
		resultsBuffer.append(manager.getAllCustomersInfo());

		resultsBuffer.append("Result of processing requests\n");
		resultsBuffer.append(manager.processRequests());

		resultsBuffer.append("After processing requests\n");
		resultsBuffer.append(manager.getAllCustomersInfo());

		resultsBuffer.append(manager.getAllMediaInfo());
		assertTrue(TestingSupport.correctResults("pubTestProcessingRequestsOne.txt", resultsBuffer.toString()));
	}

	public void testProcessingRequestsTwo() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadCustomersData(manager);
		loadMediaData(manager);

		if (!manager.addToQueue("Smith, John", "Mickey")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Smith, John", "Jaws")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Rocky")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Mickey")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Journey")) {
			resultsBuffer.append("Failed to add to queue");
		}

		resultsBuffer.append("After adding to queues\n");
		resultsBuffer.append(manager.getAllCustomersInfo());

		resultsBuffer.append("Result of processing requests\n");
		resultsBuffer.append(manager.processRequests());

		resultsBuffer.append("After processing requests\n");
		resultsBuffer.append(manager.getAllCustomersInfo());
		resultsBuffer.append(manager.getAllMediaInfo());

		assertTrue(TestingSupport.correctResults("pubTestProcessingRequestsTwo.txt", resultsBuffer.toString()));
	}

	public void testReturnMedia() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadCustomersData(manager);
		loadMediaData(manager);

		if (!manager.addToQueue("Smith, John", "Mickey")) {
			resultsBuffer.append("Failed to add to queue");
		}

		if (!manager.addToQueue("Albert, Mike", "Rocky")) {
			resultsBuffer.append("Failed to add to queue");
		}

		resultsBuffer.append(manager.processRequests());
		resultsBuffer.append("Result of processing requests\n");
		resultsBuffer.append("**** Customer Info ****\n");
		resultsBuffer.append(manager.getAllCustomersInfo());
		resultsBuffer.append("\n**** Media Info ****\n");
		resultsBuffer.append(manager.getAllMediaInfo());

		manager.returnMedia("Smith, John", "Mickey");
		resultsBuffer.append("\nAfter returning media\n");
		resultsBuffer.append(manager.getAllCustomersInfo());
		resultsBuffer.append(manager.getAllMediaInfo());
		
		//my test
		System.out.println(resultsBuffer);

		assertTrue(TestingSupport.correctResults("pubTestReturnMedia.txt", resultsBuffer.toString()));
	}

	public void testSearchMedia() {
		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadMediaData(manager);

		ArrayList<String> searchResults = manager.searchMedia(null, "PG", null, null);
		resultsBuffer.append("PG Search: " + searchResults);

		searchResults = manager.searchMedia("Rocky", null, null, null);
		resultsBuffer.append("\nTitle Search: " + searchResults);

		searchResults = manager.searchMedia(null, null, null, "Far Away");
		resultsBuffer.append("\nSong Search: " + searchResults);


		assertTrue(TestingSupport.correctResults("pubTestSearchMedia.txt", resultsBuffer.toString()));
	}

	/* Private support methods */
	private static void loadCustomersData(MediaRentalManager manager) {
		String limited = "LIMITED", unlimited = "UNLIMITED";

		String[] names = {"Smith, John", "Albert, Mike", "Park, Laura"};
		String[] addresses = {"354 South J Ave MD", 
				"11 Apple Mount VA",
		"227 Park Lane DC"};
		String[] plans = {unlimited, limited, unlimited}; 
		if ((names.length != addresses.length) && (addresses.length != plans.length)) {
			System.err.println("Invalid data in loadCustomerData");
			System.exit(0);
		}

		for (int i = 0; i < names.length; i++) {
			manager.addCustomer(names[i], addresses[i], plans[i]);
		}
	}

	private static void loadMediaData(MediaRentalManager manager) {

		/* Loading movies */
		String title[] =          {"Rocky", "Jaws", "Mickey", "Gone with the Wind"};
		int[] copiesAvailable =   {3,       4,      1,        2};
		String[] rating =         {"PG",    "R",    "PG",     "PG"};

		if ((title.length != copiesAvailable.length) && (copiesAvailable.length != rating.length)) {
			System.err.println("Invalid data in loadMedia (loading movies)");
			System.exit(0);
		}

		for (int i = 0; i < title.length; i++) {
			manager.addMovie(title[i], copiesAvailable[i], rating[i]);
		}

		/* Loading Albums */
		String albumTitle[] =          {"Bad", 			    "Journey", };
		int[] albumCopiesAvailable =   {2,       		    1,        };
		String[] albumArtist =         {"Mike J",           "ABBA"    };
		String[] albumSongs = 		   {"Mirror, Far Away", "Yesterday, Hello"};

		if ((albumTitle.length != albumCopiesAvailable.length) &&
				(albumCopiesAvailable.length != albumArtist.length) && (albumArtist.length != albumSongs.length)) {
			System.err.println("Invalid data in loadMedia (loading albums)");
			System.exit(0);			
		}

		for (int i = 0; i < albumTitle.length; i++) {
			manager.addAlbum(albumTitle[i], albumCopiesAvailable[i], albumArtist[i], albumSongs[i]);
		}
	}
}