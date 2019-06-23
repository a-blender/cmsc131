package sysutilities;

/**
 * Example of using the Name class.
 * 
 * @author cmsc131
 *
 */
public class Driver {

	public static void main(String[] args) {
		Name name1 = new Name("Claudia", "I.", "Smith");
		System.out.println(name1);

		Name name2 = new Name("Rachel", "I.", "Green", '#');
		System.out.println(name2);

		Name name3 = new Name("Joseph", "K", "Falk");
		name3.setNickname("Joe");
		System.out.println(name3);

		Name name4 = new Name();
		System.out.println(name4);

		System.out.println("Same: " + name1.equals(name2));

		System.out.println("Comparing: " + (name1.compareTo(name2) < 0));

		Name name5 = Name.normalize(name3, true);
		System.out.println("Normalized: " + name5);

		System.out.println("Total number of name objects: " + Name.getNumberOfNameObjects());
	}
}
