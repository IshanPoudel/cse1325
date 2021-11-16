package store;

import java.io.*;
import java.util.*;
import java.lang.String.*;
import javax.swing.*;




public class Store
{
	public String storeName;
	public ArrayList<Product> products = new ArrayList<Product>();
	public ArrayList<Person> customers = new ArrayList<Person>();
	public ArrayList<Person> servers = new ArrayList<Person>();


	
    public Store ()
    {
    	this.storeName = "jade";
    	this.products = new ArrayList<Product>();
    	this.customers = new ArrayList<Person>();
    	this.servers = new ArrayList<Person>();
    }

	public Store(String storeName)
	{
		this.storeName = storeName;
		this.products = products;
		this.customers = customers;
	}

	public String storeName()
	{
		return this.storeName;
	}

	public void addProduct(Product p)
	{
		this.products.add(p);
	}

	public void addCustomer(Customer c)
	{
		this.customers.add(c);
	}

	public void addServer(Server s)
	{
		this.servers.add(s);
	}


	//GET All the Products(aka Donuts in this case in an arraylist)
	//We need this because our attribute productlist is private

	public ArrayList<Product> getArrayListofProduct()
	{
		int i = this.numberOfProducts();
		ArrayList<Product> returnProductList  = new ArrayList<Product>();



		for (Product p : this.products)
		{
			returnProductList.add(p);
		}

		return returnProductList;


	}

	public ArrayList<Person> getArrayListofPerson()
	{
		int i = this.numberOfProducts();
		ArrayList<Person> returnPersonList  = new ArrayList<Person>();



		for (Person c : this.customers)
		{
			returnPersonList.add(c);
		}

		return returnPersonList;

	}

    
    //Create savefile
    //Iterates through the files
    //uses the getAttributes method which goes through all the files. 
    //At first prints the number of elements.
    //List each parameter of Donut class in one line.
	public void savefile(BufferedWriter bw)
	{
		// System.out.println("Hey from Store class " );
		// System.out.println("I got  a buffered writer " + bw);
		ArrayList<Product> getProductList;
		getProductList = this.getArrayListofProduct();

		try
	    {
	      
	      bw.write(  getProductList.size() + "\n");
	      bw.write(this.storeName + "\n");
	      for (Product p : getProductList)
	      {
	      	
	      	bw.write(p.getAttributes()+"\n");
	      	// System.out.println("I wrote values  to the bw");   //getaatributes is a methos which gives all the features of the donut
	      }
	      bw.close();

	    } catch (Exception e)
	    {
	      return ;
	    }

	}

	public static Java parseJava(String s)
	{
		String[] JavaAttributes  = s.split("\\s+");
		int size = JavaAttributes.length;

		int total_shots = Integer.parseInt(JavaAttributes[size-1]);
		

		
		System.out.println(total_shots);

		//Create new java

		Java java = new Java ((JavaAttributes[0]) , 
			Double.parseDouble(JavaAttributes[1]) ,
			Double.parseDouble(JavaAttributes[2]) , 
			Darkness.valueOf(JavaAttributes[3]));

		//Add shots to the java
		//Starts from 4 to n-1;
		for (int i=4; i<size-1;i++)
		{
			java.addShot(Shot.valueOf(JavaAttributes[i]));
		}

		return (java);



	}

	public static Donut parseDonut (String s )
	{

		// System.out.println("I am here ");

		
		
		String[] DonutAttributes = s.split("\\s+");
		// System.out.println(DonutAttributes[0]);
		int size = DonutAttributes.length;

		// System.out.println(DonutAttributes[0] , DonutAttributes[1]);
		
		
		// String name = DonutAttributes[0];
		return (new Donut ( DonutAttributes[0] , 
			Double.parseDouble(DonutAttributes[1]) ,
			Double.parseDouble( DonutAttributes[2]) , 
			Boolean.parseBoolean(DonutAttributes[3]) , 
				Frosting.valueOf(DonutAttributes[4]) , 
				Filling.valueOf(DonutAttributes[5])   ));
        
		


	}


	// Construct Store from the class
	public Store(BufferedReader br)  
	{

		// System.out.println("I am trying to construct store from savefile"  );

		


		
		try{
		//Get number of elements.
			int numOfProducts = Integer.parseInt(br.readLine());
			
			this.storeName = br.readLine();
			this.products = new ArrayList<Product>();

		

			



			//Get the next two;
			for (int i=0  ; i<numOfProducts ; i++)
			{
				//GET A STRING WITH EACH ELEMENT
				//if donut parse donut
				// System.out.println("I am here iterating through the file");
				String s= br.readLine();
				// cSystem.out.println(s);
				if (s.equals("D"))
				{
					// System.out.println("Adding Donut");
					this.products.add(parseDonut(br.readLine()));

					// System.out.println("Added" + (parseDonut(br.readLine()) ));

				}


				if ( s.equals("J") )
				{
					// br.readLine();
					
					this.products.add(parseJava(br.readLine()));
				}

				
				
				//Add to store.

				//if java parse java

				//add to store

			}

			

	    } catch (Exception e)
	    {
	    	this.storeName = "Empty";
	    	this.products = new ArrayList<Product>();
	    	// System.out.println("You did not finish try");
	    	System.out.println(e);
	    }

	   

	    






		

        


	}



	public int numberOfProducts()
	{
		return this.products.size();
	}

	public int numberOfPersons()
	{
		return this.customers.size();
	}
	public int numberOfServers()
	{
		return this.servers.size();
	}

	public String toString(int productindex){
		return (this.products.get(1) + " ");
	}


	@Override
	public String toString()
	{
		ArrayList<String> menu = new ArrayList<String>();

		System.out.println("You have the following orders: ");
		
		for (int i=0; i<this.products.size();i++)
		{

			menu.add(i+1 + ")" + this.products.get(i) );
			// System.out.printf( i+1 + ")");
			// System.out.println(this.products.get(i));
 
		}
		String menuConverted= new String();

		for (String s: menu)
		{
			menuConverted += s + "\t" + "\n";

		}

		return (menuConverted);


		

	}

	//get the customer values
	public String PersontoString()
	{
		ArrayList <String> personlist = new ArrayList<String>();

		System.out.println("You have the following customers");

		for (int i=0; i<this.customers.size();i++)
		{
			personlist.add( i+1 + ")" + this.customers.get(i));
		}

		String personConverted = new String();

		for (String s: personlist)
		{
			personConverted += s + "\t" + "\n";

		}

		return personConverted;
	}

	public String ServertoString()
	{
		ArrayList <String> serverlist = new ArrayList<String>();

		for (int i=0; i<this.servers.size();i++)
		{
			serverlist.add( i+1 + ")" + this.servers.get(i));
		}

		String serverConverted = new String();

		for (String s: serverlist)
		{
			serverConverted += s + "\t" + "\n";

		}

		return serverConverted;



	}


	public static void main(String[] args)
	{
		ArrayList<Donut> pr = new ArrayList<Donut>();
		Store jade = new Store("JADE" );
		jade.addProduct( new Donut ("LocalDonut" , 2.0 , 0.5 , false , Frosting.unfrosted , Filling.creme));
		jade.addProduct( new Donut ("ABCDonut" , 5.0 , 0.5 , true , Frosting.glazed , Filling.creme ));
		
		// Create Java Product to add
		Java cof = new Java("Local" , 2.00 , 2.00 , Darkness.blond);
		cof.addShot(Shot.chocolate);
		cof.addShot(Shot.vanilla);

		jade.addProduct(cof);

		Customer ishan = new Customer("Ishan" , "405-981-8094");
		jade.customers.add(ishan);

		Server me = new Server("Me" , "405-981-8-94" , "4243312134341");
		jade.servers.add(me);




		System.out.println(jade);
		System.out.println(jade.PersontoString());
		System.out.println(jade.ServertoString());

		

		




	}





}