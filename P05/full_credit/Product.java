abstract class Product{

	protected String name;
	protected double unitCost;
	protected int quantity;

	public Product(String name , double unitCost){
		this.name=name;
		this.unitCost=unitCost;
		
		this.quantity=0;

	}


    // call the onject's placeOrder method with the quant to be ordered.
	public abstract Product placeOrder(int quantity);



	

	public  abstract double price();

	public  String toString()
	{
		if (this.quantity<=1)
		{
			return(this.name + " " + " (@" +this.unitCost + ")" );


		}
		else
		{
			return(this.name + (" " + this.quantity + " (@" +this.unitCost + ") " ));

		}

	}




}