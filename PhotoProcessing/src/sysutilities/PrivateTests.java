package sysutilities;

public class PrivateTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		String answer = "";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, false);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "display", null, false);
		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "selectcolors", "rG", false);
		answer += photoProcessingSys.getTransactions();

		answer += "\nEndTestSubServer";
		
		System.out.println(answer);

	}

}
