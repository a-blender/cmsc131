//DECK Class
//@author Anna Blendermann
package poker;

//DECK CLASS**************************************************************
public class Deck 
{
	private Card[] cards;
	//DEFAULT CONSTRUCTOR*************************************************
	public Deck() 
	{
		this.cards = new Card[52]; //initialize card array
		int count = 0; //temp variable for array count 
		//intalize array with 52 card values
		//1 through 13 represent card values 1 through king
		//0 through 3 represent card suits (spade, heart, club, diamond)
		for(int suit=0; suit<=3; suit++)
		{
			for(int value=1; value<=13; value++)
			{
				cards[count] = new Card(value, suit);
				count = count + 1;
			}
		} //end of for loop
	} //end of default constructor

	//ONE PARAM CONSTRUCTor***********************************************
	public Deck(Deck other) 
	{
		//copy the current object but
		//use another memory location in storage
		int newLength = other.cards.length;
		this.cards = new Card[newLength];
		for(int x=0; x< newLength; x++)
			this.cards[x] = other.cards[x]; //deep copy
	}

	//GET CARD AT METHOD**************************************************
	public Card getCardAt(int position) 
	{
		return cards[position]; 
	}

	//GET NUM CARDS METHOD************************************************
	public int getNumCards() 
	{
		return cards.length;
	}

	//SHUFFLE METHOD******************************************************
	public void shuffle() 
	{
		if(cards.length%2 == 0) //divide by two
		{
			Card[] top_packet = new Card[cards.length/2];
			Card[] bottom_packet = new Card[cards.length/2];

			//place first half of deck into top_packet
			for(int x=0; x<top_packet.length; x++) {
				top_packet[x] = cards[x]; }

			//place second half of deck into bottom_packet
			for(int x=0; x<bottom_packet.length; x++) {
				bottom_packet[x] = cards[(bottom_packet.length)+x]; }

			for(int x = 0; x < top_packet.length; x++) {
				cards[(x * 2)] = top_packet[x]; }

			//this makes the array longer, and continues to fill it in with
			//the type of code form before
			for(int x = 0; x < bottom_packet.length; x++) {
				cards[(x * 2)+1] = bottom_packet[x]; }
		} //end of if-statement with even halves

		else if(cards.length%2 != 0) //the array is odd numbered
		{
			Card[] top_packet = new Card[cards.length/2+1];
			Card[] bottom_packet = new Card[cards.length/2];

			//place first half of deck into top_packet
			for(int x=0; x<top_packet.length; x++)
				top_packet[x] = cards[x];

			//place second half of deck into bottom_packet
			for(int x=0; x<bottom_packet.length; x++)
				bottom_packet[x] = cards[bottom_packet.length+x+1];

			for(int x = 0; x < top_packet.length; x++)
				cards[(x * 2)] = top_packet[x];

			//this makes the array longer, and continues to fill it in with
			//the type of code form before
			for(int x = 0; x < bottom_packet.length; x++)
				cards[(x * 2) + 1] = bottom_packet[x];
			
		} //end of if-statement with odd array

	} //end of shuffle method
	
	//CUT METHOD**********************************************************
	public void cut(int position) 
	{ 
		Card[] frontCut = new Card[position];
		Card[] backCut = new Card[cards.length - position];

		for(int x = 0; x < frontCut.length; x++){
			frontCut[x] = cards[x];
		}
		for(int x = 0; x < backCut.length; x++){
			backCut[x] = cards[x + position];
		}
		for(int x = 0; x < backCut.length; x++){
			cards[x] = backCut[x];
		}
		for(int x = 0; x < frontCut.length; x++){
			cards[backCut.length + x] = frontCut[x]; 
		}
	} //end of cut method

	//DEAL METHOD*********************************************************
	public Card[] deal(int numCards) 
	{
		Card[] dealt = new Card[numCards];
		Card[] smaller = new Card[cards.length - numCards];

		//copy cards BEING dealt into the "dealt" array
		for(int x=0; x<numCards; x++){
			dealt[x] = cards[x]; }
		//copy cards NOT being dealt into the "smaller" array
		for(int x=0; x<smaller.length; x++) {
			smaller[x] = cards[x + numCards]; }

		cards = smaller; //reassign array instance variable
		return dealt; //return array of dealt cards
	} //end of deal method

} //end of Deck class
