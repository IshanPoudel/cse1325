import java.util.*;
import java.util.Scanner;

public class Store{
	protected String storeName;
	protected ArrayList<Product> products = new ArrayList<Product>();




	public Store(String storeName , ArrayList<Product> products)
	{
		this.storeName = storeName;
		this.products = products;
	}

	public String storeName()
	{
		return this.storeName;
	}

	public void addProduct(Product product)
	{
		this.products.add(product);

	}

	public int numberOfProducts()
	{
		return this.products.size();

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
			menuConverted += s + "\t";

		}

		return (menuConverted);


		

	}

	// public static void main(String[] args)
	// {
	// 	ArrayList<Product> pr = new ArrayList<Product>();

	// 	Store JadeStore = new Store("JadeStore" , pr );
	// 	JadeStore.cli();
		

		
		

		 
	// 	//JadeStore.addProduct(new Donut("Local" , 2.00 , 3.00 , Frosting.unfrosted , false , Filling.creme ));
	// 	// System.out.println(JadeStore);
	// }

	public void cli()
	{
		System.out.println("Welcome to " + this.storeName);

		System.out.println("=====MENU=====");
		boolean check = true;

		Scanner sc = new Scanner(System.in);


		//Declare shot array to store shot variable values.
		ArrayList<Shot> shots_to_add = new ArrayList<Shot>();
		//Declare darkness variable to add darkness.
		Darkness darkness_to_add = Darkness.blond;
		//Declare frosting enum to add frosting 
		Frosting frosting_to_add = Frosting.glazed;
		//Declare filling enum to add filling
		Filling filling_to_add = Filling.unfilled;
		//Declare boolean to indicate sprinkles.
		boolean sprinkles_to_add = true;

		while(check)
		{
			System.out.println(" Options: ");
			
			System.out.println("0) Exit");
			System.out.println("1) Add Java");
			System.out.println("2) Add donut");
			System.out.println(" ");

			System.out.printf("Choice? ");
			char c = sc.next().charAt(0);
			
			switch(c){

				case '0': 
				    check=false; 
				    break;

				case '1': 
				    System.out.println("You pressed Java"); 
				    System.out.println("BREW OPTIONS");
				    System.out.println("=============");
				    System.out.println( " 0) Blond " );
				    System.out.println( " 1) Light " );
				    System.out.println( " 2) Medium " );
				    System.out.println( " 3) Dark " );
				    System.out.println( " 4) Extreme " );
				    System.out.printf("Which darkness? ");
				    char brew_option = sc.next().charAt(0);

				    //Add switch to get darkness option.
				    switch(brew_option)
				    {
				    	case '0': darkness_to_add = Darkness.blond; break;
				    	case '1': darkness_to_add = Darkness.light; break;
				    	case '2': darkness_to_add = Darkness.medium; break;
				    	case '3': darkness_to_add = Darkness.dark; break;
				    	case '4': darkness_to_add = Darkness.extreme; break;
				    	default: System.out.println("You did not print anything");

				    }

				     Java order = new Java("Coffee" , 2.50 , 2.00 , darkness_to_add);


				     


				    System.out.println("You pressed " + brew_option);

				    boolean shot_option = true;
				    while(shot_option)
				    {
				    	System.out.println("Shot Options");
				    	System.out.println("=============");
				    	System.out.println( " 0) None " );
				        System.out.println( " 1) Milk " );
				        System.out.println( " 2) Sugar " );
				        System.out.println( " 3) Creamer " );
				        System.out.println( " 4) Chocolate " );
				        System.out.println( " 5) Vanilla " );
				        System.out.println( " 6) Hazlenut " );
				        System.out.println( " 7) Peppermint " );

				        System.out.printf( "Add shot (-1 when done) ? ");




				        char shot_option_next = sc.next().charAt(0);
				        if (shot_option_next ==('-'))
				        {
				        	shot_option = false;

				        }

				        switch(shot_option_next)
				        {
				        	case '1' : order.addShot(Shot.milk); break;
				        	case '2' : order.addShot(Shot.sugar); break;
				        	case '3' : order.addShot(Shot.creamer); break;
				        	case '4' : order.addShot(Shot.chocolate); break;
				        	case '5' : order.addShot(Shot.vanilla); break;
				        	case '6' : order.addShot(Shot.hazlenut); break;
				        	case '7' : order.addShot(Shot.peppermint); break;


				        }



				        System.out.println(" ");


				    }

				    this.addProduct(order);



				    break;
				case '2':

				    System.out.println("Your pressed Donut"); 

				    System.out.println("Frosting Options");
				    System.out.println("=============");
				    System.out.println( " 0) Unfrosted " );
				    System.out.println( " 1) Glazed " );
				    System.out.println( " 2) Chocolate " );
				    System.out.println( " 3) Vanilla " );
				    System.out.println( " 4) Strawberry " );
				    System.out.println( " 5) Creme " );
				    System.out.println( " 6) Cherry " );
				    System.out.printf("Which Frosting? ");
				    char frosting_option = sc.next().charAt(0);

				    switch(frosting_option)
				    {
				    	case '0': frosting_to_add = Frosting.unfrosted;break;
				    	case '1': frosting_to_add = Frosting.glazed;break;
				    	case '2': frosting_to_add = Frosting.chocolate;break;
				    	case '3': frosting_to_add = Frosting.vanilla;break;
				    	case '4': frosting_to_add = Frosting.strawberry;break;
				    	case '5': frosting_to_add = Frosting.creme;break;
				    	case '6': frosting_to_add = Frosting.cherry;break;
				    	
				    	default: System.out.println("You did not choose anything");

				    }

				    System.out.println("Filling options");
				    System.out.println("=================");
				    System.out.println("0) Unfilled");
				    System.out.println("1) Creme");
				    System.out.println("2) Bavarian");
				    System.out.println("3) Strawberry");

				   System.out.printf("Which Frosting? ");
				   char filling_option = sc.next().charAt(0);

				    switch(filling_option)
				    {
				    	case '0': filling_to_add = Filling.unfilled;break;
				    	case '1': filling_to_add = Filling.creme;break;
				    	case '2': filling_to_add = Filling.bavarian;break;
				    	case '3': filling_to_add = Filling.strawberry;break;
				    	
				    	
				    	default: System.out.println("You did not choose anything");

				    }

				    System.out.printf("sprinkles (1 for yes , 0 for no) ? ");
				    char sprinkles_option = sc.next().charAt(0);

				    switch(sprinkles_option)
				    {
				    	case '0': sprinkles_to_add = false;
				    	case '1': sprinkles_to_add = true;
				    }

				    Donut donut_order = new Donut ("Donut" , 2.00 , 3.00 , frosting_to_add , sprinkles_to_add , filling_to_add);
				    this.addProduct(donut_order);





















				    break;
				default: 
				    check=false;
				    break;
			}

			//Print what is in the menu. 
			System.out.println(this.toString());
			




			


		}

	}

}