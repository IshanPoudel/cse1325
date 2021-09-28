
import java.util.*;



public class Store{

	public static void main(String[] args){
		Store shop = new Store();
		shop.cli();

		
	}

	public void cli()
	{
		// setSalesTaxRate(0.010);



		Product[] arr;

		arr = new Product[6];
		arr[0]= new Taxed ("Modelo" , 8.00);
		arr[1]= new Taxed("Marlboro" , 4.99);
		arr[2] = new Taxed("BlackNMild" , 6.99);
		arr[3]= new Taxfree("Cheese" , 8.99);
		arr[4]= new Taxfree("Tomatoes" , 2.99);
		arr[5]= new Taxfree("Carrots" , 2.99);

		//predefine several taxed and taxfree grocery items.
		


		// print the menu out
		for (int i=0; i<6; i++){
			System.out.println(arr[i]);
			
		}

		Scanner in = new Scanner(System.in);
		String choice_name;

		Product[] cart = new Product[6];

		int counter=0;

		while(true){
			
			System.out.println("Enter choice and quantity(Press 0 to checkout)");
			choice_name = in.nextLine();

			if(choice_name.trim().equals("0") ){
				break;
			}

			String[] split_choice = choice_name.split(" ");
			int qty = Integer.parseInt(split_choice[1]);

			for (int i=0; i<arr.length;i++)
			{
				if (split_choice[0].equals(arr[i].name))
				{

					
					cart[counter] = arr[i].placeOrder(qty);
					counter++;
					

				}

			}
			if (counter==0){
				System.out.println("Incorrect Input");
			}
		    


		}

		double totalPrice=0;

		for (int i=0; i<counter;i++)
		{
			System.out.println(cart[i]);
			totalPrice=totalPrice+cart[i].price();


		}

		System.out.println("Total Price : " + totalPrice );

		



	}
}