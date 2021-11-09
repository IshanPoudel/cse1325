package store;

public abstract class Person
{
	protected  String name;
	protected  String phoneNumber;
	


	public Person(String name , String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		
	}

	public String getName()
	{
		return this.name;
	}

	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}

	

	@Override
	public String toString()
	{
		return this.name;
	}

	
	String getAttributes()
	{
		return this.name;
	}



}