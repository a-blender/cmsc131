package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sysutilities.Name;

public class PublicTests {
    /* We use this string to prevent any hardcoding of results. */
    /* The submit server uses a different value for TESTS_TAG   */
    public static final String TESTS_TAG = "\nEndTest";
	
	@Test
	public void test1() {
		String answer = "";
		Name name1 = new Name("Claudia", "I.", "Smith");
		answer += name1 + "\n";
		
		Name name2 = new Name("Rachel", "I.", "Green", '#');
		answer += name2 + "\n";
		
		Name name3 = new Name("Joseph", "K.", "Falk");
		name3.setNickname("Joe");
		answer += name3 + "\n";
		
		Name name4 = new Name();
		answer += name4 + "\n";
		
		answer += "Same: " + name1.equals(name2) + "\n";
		
		answer += "Number of objects: " + Name.getNumberOfNameObjects();
		
		answer += TESTS_TAG;
		
		assertTrue(TestsSupport.isCorrect("pubTest1.txt", answer));
	}
}