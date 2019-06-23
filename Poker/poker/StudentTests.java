//JUNIT Test Case for PokerEvaluator
//@author Anna Blendermann
package poker;
import junit.framework.TestCase;

public class StudentTests extends TestCase
{
	PokerHandEvaluator phe = new PokerHandEvaluator();
	Card[] hand1, hand2, hand3; 

	@Override
	protected void setUp() throws Exception {
		phe = new PokerHandEvaluator();

		hand1 = new Card[5];
		hand1[0] = new Card(2,0);
		hand1[1] = new Card(4,1);
		hand1[2] = new Card(6,2);
		hand1[3] = new Card(8,3);
		hand1[4] = new Card(12,3);

		hand2 = new Card[5];
		hand2[0] = new Card(2,0);
		hand2[1] = new Card(2,0);
		hand2[2] = new Card(5,3);
		hand2[3] = new Card(2,0);
		hand2[4] = new Card(2,1);

		hand3 = new Card[5];
		hand3[0] = new Card(8,2);
		hand3[1] = new Card(9,2);
		hand3[2] = new Card(10,2);
		hand3[3] = new Card(11,2);
		hand3[4] = new Card(12,2);	
	} //end of setup method

	@Override
	protected void tearDown() throws Exception {
		phe = null;
		hand1 = hand2 = hand3 = null;
	} //end of teardown method

	public void testHasPair() {
		assertFalse(PokerHandEvaluator.hasPair(hand1));
		assertTrue(PokerHandEvaluator.hasPair(hand2));
		assertFalse(PokerHandEvaluator.hasPair(hand3));
	}

	public void testHasTwoPair() {
		assertFalse(PokerHandEvaluator.hasTwoPair(hand1));
		assertFalse(PokerHandEvaluator.hasTwoPair(hand2));
		assertFalse(PokerHandEvaluator.hasTwoPair(hand3));
	}

	public void testHasThreeOfAKind() {
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(hand1));
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand2));
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(hand3));
	}

	public void testHasStraight() {
		assertFalse(PokerHandEvaluator.hasStraight(hand1));
		assertFalse(PokerHandEvaluator.hasStraight(hand2));
		assertTrue(PokerHandEvaluator.hasStraight(hand3));
	} 

	public void testHasFlush() {
		assertFalse(PokerHandEvaluator.hasFlush(hand1));
		assertFalse(PokerHandEvaluator.hasFlush(hand2));
		assertTrue(PokerHandEvaluator.hasFlush(hand3));
	}

	public void testHasFullHouse() {
		assertFalse(PokerHandEvaluator.hasFullHouse(hand1));
		assertFalse(PokerHandEvaluator.hasFullHouse(hand2));
		assertFalse(PokerHandEvaluator.hasFullHouse(hand3));
	}

	public void testHasFourOfAKind() {
		assertFalse(PokerHandEvaluator.hasFourOfAKind(hand1));
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand2));
		assertFalse(PokerHandEvaluator.hasFourOfAKind(hand3));
	}

	public void testHasStraightFlush() {
		assertFalse(PokerHandEvaluator.hasStraightFlush(hand1));
		assertFalse(PokerHandEvaluator.hasStraightFlush(hand2));
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand3));
	}

} //end of junit test class for PokerEvaluator
