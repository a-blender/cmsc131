package sysutilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressTest 
{
	Address obj1, obj2, obj3, obj4, obj5;

	@Before
	public void setUp() throws Exception {
		obj1 = new Address();
		obj2 = new Address("1234 Cherry Hill Road");
		obj3 = new Address("345 Disaster Lane", "Rondevu", "WA", "20875");
		obj4 = new Address(" 456 Borne Road", "Gaither", " VA ", "24588");
		obj5 = new Address("129 Blue Drive ", "FortHenry ", "AZ", "345pd");
	}

	@After
	public void tearDown() throws Exception {
		obj1 = obj2 = obj3 = null;
	}

	@Test
	public void getStreetTest() {
		assertEquals("8332 Paint Branch Dr.", obj1.getStreet());
		assertEquals("1234 Cherry Hill Road", obj2.getStreet());
		assertEquals("345 Disaster Lane", obj3.getStreet());
		assertEquals("456 Borne Road", obj4.getStreet());
		assertEquals("129 Blue Drive", obj5.getStreet());
	}

	@Test
	public void getCityTest() {
		assertEquals("College Park", obj1.getCity());
		assertEquals("College Park", obj2.getCity());
		assertEquals("Rondevu", obj3.getCity());
		assertEquals("Gaither", obj4.getCity());
		assertEquals("FortHenry", obj5.getCity());	
	}

	@Test
	public void getStateTest() {
		assertEquals("MD", obj1.getState());
		assertEquals("MD", obj2.getState());
		assertEquals("WA", obj3.getState());
		assertEquals("VA", obj4.getState());
		assertEquals("AZ", obj5.getState());
	}

	@Test
	public void getZipCodeTest() {
		fail("Not yet implemented");
	}

	@Test
	public void equalsTest() {
		fail("Not yet implemented");
	}

	@Test
	public void toStringTest() {
		fail("Not yet implemented");
	}

}
