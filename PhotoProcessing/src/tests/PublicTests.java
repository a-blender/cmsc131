package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import sysutilities.*;

public class PublicTests {
	/* We use this string to prevent any hardcoding of results. */
	/* The submit server uses a different value for TESTS_TAG   */
	public static final String TESTS_TAG = "\nEndTestSubServer";

	/* If you set to true images will be displayed when you ran the tests */
	public static final boolean GRAPHICAL_MODE_FLAG = false;

	@Test
	public void test1() {
		String answer = "";

		Address address1 = new Address("8134 Java St.", "Silver Spring", "VA", "21567");
		answer += address1 + "\n";
		Address address2 = new Address();
		answer += address2 + "\n";

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest1.txt", answer));
	}

	@Test
	public void test2() {
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys + "\n";

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest2.txt", answer));
	}

	@Test
	public void test3() {
		/* display */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer = photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest3.txt", answer));
	}

	@Test
	public void test4() {
		/* clear */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest4.txt", answer));
	}

	@Test
	public void test5() {
		/* displayLast */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest5.txt", answer));
	}

	@Test
	public void test6() {
		/* black and white */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "blackandwhite", null, GRAPHICAL_MODE_FLAG);

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest6.txt", answer));
	}

	@Test
	public void test7() {
		/* posterize */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "posterize", null, GRAPHICAL_MODE_FLAG);

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest7.txt", answer));
	}

	@Test
	public void test8() {
		/* black and white and posterize */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "blackandwhiteposterize", null, GRAPHICAL_MODE_FLAG);

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest8.txt", answer));
	}

	@Test
	public void test9() {
		/* select colors */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "selectcolors", "rG", GRAPHICAL_MODE_FLAG);

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest9.txt", answer));
	}

	@Test
	public void test10() {
		/* balance */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "selectcolors", "rG", GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.getBalance();

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest10.txt", answer));
	}

	@Test
	public void test11() {
		/* getTransactions */
		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "selectcolors", "rG", GRAPHICAL_MODE_FLAG);
		answer += photoProcessingSys.getTransactions();

		answer += TESTS_TAG;
		assertTrue(TestsSupport.isCorrect("pubTest11.txt", answer));
	}
}