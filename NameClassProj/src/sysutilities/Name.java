//NAME CLASS PROJECT
//@Anna Blendermann
package sysutilities;

//CLASS NAME********************************************
public class Name
{ 	
	private String firstName; //var for first name
	private String middleName; //var for middle name
	private String lastName; //var for last name
	private char sep; //char that separates name sections
	private String nickName; //var for nickname
	private static int nameObjsCount = 0; //var for number of name objects

	//DEFAULT CONSTRUCTOR*********************************
	public Name()
	{
		firstName = "NOFIRSTNAME";
		middleName = "NOMIDDLENAME";
		lastName = "NOLASTNAME";
		nickName = "";
		sep = '#';	
		nameObjsCount++;
	}

	//TWO PARAM CONSTRUCTOR********************************
	public Name(String first, String last)
	{
		firstName = first;
		middleName = "";
		lastName = last;
		nickName = "";
		sep = ',';
		nameObjsCount++;
	}

	//THREE PARAM CONSTRUCTOR*******************************
	public Name(String first, String mid, String last)
	{
		firstName = first;
		middleName = mid;
		lastName = last;
		nickName = "";
		sep = ',';
		nameObjsCount++;
	}

	//FOUR PARAM CONSTRUCTOR********************************
	public Name(String first, String mid, String last, char sp)
	{
		firstName = first;
		middleName = mid;
		lastName = last;
		nickName = "";
		nameObjsCount++;

		if(validSeparator(sp) == true)
			sep = sp;
		else //given separator is invalid
			sep = ',';
	} //end of four param constructor

	//GET FIRSTNAME METHOD**********************************
	public String getFirstname()
	{
		return firstName;
	}

	//GET MIDDLENAME METHOD*********************************
	public String getMiddlename()
	{
		return middleName;
	}

	//GET LASTNAME METHOD***********************************
	public String getLastname()
	{
		return lastName;
	}

	//SET NICKNAME METHOD**********************************
	public void setNickname(String nk)
	{
		nickName = nk;
	}

	//GET NICKNAME METHOD**********************************
	public String getNickname()
	{
		return nickName;
	}

	//SET SEPARATOR METHOD*********************************
	public void setSeparator(char sp)
	{
		if(validSeparator(sp) == true)
			sep = sp;
	}

	//GET SEPARATOR METHOD*********************************
	public char getSeparator()
	{
		return sep;
	}

	//EQUALS METHOD****************************************
	public boolean equals(Name obj)
	{
		if(obj != null)
		{
			if(this.getFirstname().equals(obj.getFirstname())
					&& this.getLastname().equals(obj.getLastname())
					&& this.getMiddlename().equals(obj.getMiddlename()))
				return true;
			else //name sections do not match
				return false;
		}
		else if(obj == null) //object is null
			return false;
		
		return false;
	} //end of equals method

	//TO STRING METHOD*************************************
	public String toString()
	{
		if(!this.getMiddlename().equals("")) //middlename exists
		{
			if(!this.getNickname().equals("")) //both exist
				return lastName + sep + firstName + sep + middleName 
						+ "(" + nickName + ")";
			else if(nickName.equals("")) //only middle exists
				return lastName + sep + firstName + sep + middleName;
		}
		else if(this.getMiddlename().equals(""))
		{
			if(!this.getNickname().equals("")) //only nickname exists
				return lastName + sep + firstName + "(" + nickName + ")";
			else if(nickName.equals("")) //neither exist
				return lastName + sep + firstName;
		}

		return "";
	} //end of toString method

	//COMPARE TO METHOD************************************
	public int compareTo(Name obj)
	{
		if(this.getLastname().equals(obj.getLastname()))
		{
			if(this.getFirstname().equals(obj.getFirstname()))
			{
				if(this.getMiddlename().equals(obj.getMiddlename()))
					return 0; //whole name is equal
				else //middle names are different
				{
					if(this.getMiddlename().compareTo(obj.getMiddlename()) < 0)
						return -1;
					else if(this.getMiddlename().compareTo(obj.getMiddlename()) > 0)
						return 1;
				}
			}
			else //first names are different
			{
				if(this.getFirstname().compareTo(obj.getFirstname()) < 0)
					return -1;
				else if(this.getFirstname().compareTo(obj.getFirstname()) > 0)
					return 1;
			}	
		}
		else //last names are different
		{
			if(this.getLastname().compareTo(obj.getLastname()) < 0)
				return -1;
			else if(this.getLastname().compareTo(obj.getLastname()) > 0)
				return 1;
		}

		return 0;
	} //end of compareTo method

	//GET NUMBER OF NAME OBJECTS****************************
	public static int getNumberOfNameObjects()
	{
		return nameObjsCount;
	}

	//NORMALIZE METHOD*************************************
	public static Name normalize(Name obj, boolean stat)
	{
		Name newName = null; //create new object

		if(stat == true)
		{
			newName = new Name(obj.getFirstname().toUpperCase(),
					obj.getMiddlename().toUpperCase(), obj.getLastname().toUpperCase());
			return newName; //return uppercase object
		}
		else if(stat == false)
		{
			newName = new Name(obj.getFirstname().toLowerCase(),
					obj.getMiddlename().toLowerCase(), obj.getLastname().toLowerCase());
			return newName; //return lowercase object
		}
		return newName; //return object
	} //end of normalize method

	//VALID SEPARATOR METHOD*******************************
	private boolean validSeparator(char param)
	{
		//valid separators are comma, dash, and pound
		if(param == ',' || param == '-' || param  == '#')
			return true;
		else
			return false;
	} //end of validseparator method

} //end of Name Class
