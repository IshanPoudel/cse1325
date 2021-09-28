class Taxed extends Product
{
	public  static double tax;

	public static  void setSalesTaxRate(double salesTaxRate){
		tax=salesTaxRate;

	}

	

	public Taxed (String name , double unitCost){
		super(name , unitCost);
	}

	@Override
	public double price()
	{
		return (this.quantity*this.unitCost*(1+tax));

	}

	@Override
	public Product placeOrder(int a){
		this.quantity=a;
		
		return this;
	}

	

}