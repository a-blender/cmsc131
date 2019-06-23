//Poker Hand Evaluator Class
//@author Anna Blendermann
package poker;
public class PokerHandEvaluator 
{
	//HAIR PAIR METHOD****************************************************
	public static boolean hasPair(Card[] cards) 
	{
		//compare first cards with every other card;
		for(int first=0; first<cards.length; first++)
		{
			for(int sec=0; sec<cards.length; sec++)
			{
				if(cards[first].getValue() == cards[sec].getValue() && first!=sec)
					return true; //two pair exists
			}
		}
		return false; //true or false
	} //end of hasPair method

	//HAS TWO PAIR METHOD*************************************************
	public static boolean hasTwoPair(Card[] cards) 
	{	
		int main_count = 0;
		int first = 0; //temp var for first index
		int sec = 0; //temp var for second index

		for(int x = 0; x < cards.length-1; x++)
		{
			for(int y = x + 1; y < cards.length; y++)
			{
				if(cards[x].getValue() == cards[y].getValue() 
						&& cards[x].getValue() != first
						&& cards[y].getValue() != sec)
				{
					main_count++; //increment counter
					if (main_count == 1)
						first = cards[x].getValue();
					else if(main_count == 2)
						sec = cards[x].getValue();
				}
			}
		} //end of looping through five cards
		return(main_count == 2);
	} //end of twoPair method

	//THREE OF A KIND METHOD*********************************************
	public static boolean hasThreeOfAKind(Card[] cards) 
	{
		//compare first cards with every other card;
		for(int first=0; first<cards.length; first++)
		{
			for(int sec=0; sec<cards.length; sec++)
			{
				if(cards[first].getValue() == cards[sec].getValue() && first!=sec)
				{
					for(int third=0; third<cards.length; third++)
					{
						if(cards[sec].getValue() == cards[third].getValue() 
								&& sec!=third && first!=third)
							return true; //three of a kind exists
					}	
				}
			}
		} //end of for loops
		return false;
	} //end of threeOfAKind method

	//HAS STRAIGHT METHOD8******************************************	
	public static boolean hasStraight(Card [] cards) {
		int count = 0;
		int value;
		int sortArray [] = new int[cards.length];
		int sortAceArray[] = new int[cards.length];

		//Moving the values from the cards array to an integer array
		for(int x = 0; x < cards.length; x++) {
			sortArray[x] = cards[x].getValue();
			if(cards[x].getValue() == 1){
				sortAceArray[x] = 14;
			} else{
				sortAceArray[x] = cards[x].getValue();
			}
		}

		for(int x = 0; x < cards.length; x++) {
			sortArray[x] = cards[x].getValue();
		}

		// Sorting the integer array in numerical value
		for(int x = 0; x < sortArray.length-1; x++) {
			for(int y = x +1; y < sortArray.length; y++) {
				if(sortArray[x] > sortArray[y]){
					value = sortArray[y];
					sortArray[y] = sortArray[x];
					sortArray[x] = value;
				}
			}
		}
		for(int x = 0; x < sortAceArray.length-1; x++){
			for(int y = x +1; y < sortAceArray.length; y++){
				if(sortAceArray[x] > sortAceArray[y]){
					value = sortAceArray[y];
					sortAceArray[y] = sortAceArray[x];
					sortAceArray[x] = value;
				}
			}
		}
		//Find out the array at position x is less than position x+1
		int ace_count = 0; //special case for 
		for(int x = 0; x < cards.length-1; x++)
		{
			if(sortArray[x]+1 == sortArray[x+1])
				count++;
		}
		for(int x = 0; x < cards.length-1; x++){
			if(sortAceArray[x]+1 == sortAceArray[x+1]){
				ace_count++;
			}
		}
		return(count == 4 || ace_count == 4);
	} //end of new hasStraight method

	//HAS FLUSH METHOD****************************************************
	public static boolean hasFlush(Card[] cards) 
	{
		if(cards[0].getSuit() == cards[1].getSuit())
		{
			if(cards[1].getSuit() == cards[2].getSuit())
			{
				if(cards[2].getSuit() == cards[3].getSuit())
				{
					if(cards[3].getSuit() == cards[4].getSuit())
						return true; //return true
				}
			}
		} //end of if-statements
		return false;		
	} //end of hasFlush method

	//HAS FULL HOUSE METHOD************************************************
	public static boolean hasFullHouse(Card[] cards) 
	{
		int numEncounter = 1;
		int firstPairChecker = 0;
		int firstPairCounter = 0;
		int secondPairCounter = 0;
		int secondPairChecker = 0;
		//READS THROUGH ARRAY TO FIND FULL HOUSE IF IT EXISTS
		for (int x = 0; x < cards.length-1; x++)
		{
			//reads through the array numbers that are just after the x values
			for (int y = x + 1; y < cards.length; y++)
			{
				if (cards[x].getValue() == cards[y].getValue())
				{	
					if (numEncounter == 1)
					{
						firstPairChecker = cards[x].getValue();
						numEncounter++;
					}
					else 
					{
						if (numEncounter == 2 && cards[x].getValue() != firstPairChecker)
						{ //second pair can't have same value as first pair value
							secondPairChecker = cards[x].getValue(); //sets to find second pair
						}
					}
					if (cards[x].getValue() == firstPairChecker)
						firstPairCounter++; //number of cards matching value of first pair
					else
					{
						if (cards[x].getValue() == secondPairChecker)
							secondPairCounter++; //number of cards matching second pair value
					}
				}
			}
		}
		return(firstPairCounter == 3 && secondPairCounter == 1 
				|| firstPairCounter == 1 && secondPairCounter == 3);
	} //end of Full House method (so annoying)

	//HAS FOUR OF A KIND METHOD********************************************	
	public static boolean hasFourOfAKind(Card[] cards) 
	{
		int num_four = 0; //number of kinds
		for(int x=0; x<cards.length-1; x++)
		{
			for(int evaluate=(x+1); evaluate<cards.length; evaluate++)
				if(cards[x].getValue() == cards[evaluate].getValue())
					num_four = num_four + 1;
		}
		return(num_four == 6);
	}

	//HAS STRAIGHT FLUSH METHOD********************************************
	public static boolean hasStraightFlush(Card[] cards) 
	{
		return(hasStraight(cards) && hasFlush(cards));
	}	
} //end of PokerHandEvaluator class

