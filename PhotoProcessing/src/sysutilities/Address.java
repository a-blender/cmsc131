//Address class
//@author Anna Blendermann
package sysutilities;

//ADDRESS CLASS***********************************************
public class Address
{
	private String street = ""; //name of street
	private String city = ""; //name of city
	private String state = ""; //name of state
	private String zip = ""; //users zipcode 
	
	private static final String DEFAULT_STREET = "8223 Paint Branch Dr.";
	private static final String DEFAULT_CITY = "College Park";
	private static final String DEFAULT_STATE = "MD";
	private static final String DEFAULT_ZIP = "20742";

	//FOUR PARAMETER CONSTRUCTOR**********************************
	public Address(String street, String city, String state, String zip)
	{
		//confirm that passed variables aren't null
		if(street!=null && city!=null && state!=null && zip!=null)
		{
			this.street = street.trim();
			this.city = city.trim();
			this.state = state.trim();

			//confirm that all indexs in zipcode are digits
			for(int x=0; x<zip.trim().length(); x++)
			{
				if(Character.isDigit(zip.trim().charAt(x)))
					this.zip = zip.trim();
				else //throw new argument exception
					throw new IllegalArgumentException("Invalid Address Argument");	
			}
		}
		else //throw new argument exception
			throw new IllegalArgumentException("Invalid Address Argument");
	}//end of four-parameter constructor

	//DEFAULT CONSTRUCTOR**************************************
	public Address()
	{
		this.street = DEFAULT_STREET;
		this.city = DEFAULT_CITY;
		this.state = DEFAULT_STATE;
		this.zip = DEFAULT_ZIP;
	}//end of default constructor

	//COPY CONSTRUCTOR******************************************
	public Address copy()
	{
		Address newAddress = new Address();
		return newAddress;
	}

	//ONE PARAMETER CONSTRUCTOR***********************************
	public Address(String street)
	{
		this.street = street.trim();
		this.city = DEFAULT_CITY;
		this.state = DEFAULT_STATE;
		this.zip = DEFAULT_ZIP;
	} //end of one-param constructor

	//GET STREET METHOD*******************************************
	public String getStreet()
	{
		return street;
	}

	//GET CITY METHOD**********************************************
	public String getCity()
	{
		return city;
	}

	//GET STATE METHOD**********************************************
	public String getState()
	{
		return state;
	}

	//GET ZIPCODE METHOD*********************************************
	public String getZipCode()
	{
		return zip;
	}

	//EQUALS METHOD*************************************************f
	public boolean equals(Address object)
	{
		if(object != null)
		{
			if(this.getStreet().equals(object.getStreet())
					&& this.getCity().equals(object.getCity())
					&& this.getState().equals(object.getState())
					&& this.getZipCode().equals(object.getZipCode()))
				return true;
			else //one of those are not equal
				return false;
		}
		else if(object == null) //object is null
			return false;

		return false;
	} //end of equals method

	//TO STRING METHOD************************************************
	public String toString()
	{
		return (street + " " + city + " " + state + " " + zip);
	} //end of toString method
	
} //end of Address class
