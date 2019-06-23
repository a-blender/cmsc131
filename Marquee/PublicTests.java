import cmscMarqueeLib.ConfigValues;
import junit.framework.TestCase;

public class PublicTests extends TestCase {
	public void testOnePub() {
		String results = TestsSupport.runMarquee(new MarqueeDataManager("Saturday", 0),
				  		 4 * ConfigValues.MARQUEE_WIDTH);
		
		assertTrue(TestsSupport.correctResults("pubTest1Results.txt", results));
	}
	
	public void testTwoPub() {
		String results = TestsSupport.runMarquee(new MarqueeDataManager("Fear the Turtle", 0),
				  		 4 * ConfigValues.MARQUEE_WIDTH);
		
		assertTrue(TestsSupport.correctResults("pubTest2Results.txt", results));
	}
}
