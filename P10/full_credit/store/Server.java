package store;


import java.io.*;

public class Server extends Person
{
	private String ssn;
	public Server(String name , String phone , String ssn)
	{
		super(name , phone );
		this.ssn = ssn;


	}

	@Override
	public String toString()
	{
		return ("Name: " + this.name + "( SSN : " + this.ssn + " )");
	}

	@Override
	public String getAttributes()
	{
		//For saving it to a file
		String s = new String( 
			"Server" + this.getName() + " " + this.getPhoneNumber() );
		return s;
	}


	public static void main(String[] args)
	{
		Server me = new Server("Ishan" , "405-981-8094" , "3242929222");
		System.out.println(me);
	}



}