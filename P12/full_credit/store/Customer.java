package store;

import java.io.*;

public class Customer extends Person
{
	public Customer(String name , String phoneNumber)
	{
		super(name , phoneNumber);

	}

	@Override
	public String toString()
	{
		return ("Name : " + this.name + "  Phone Number: "  + this.phoneNumber);
	}

	@Override
	public String getAttributes()
	{
		String s = new String(
			this.getName() + " " + this.getPhoneNumber());
		return s;
	}
}