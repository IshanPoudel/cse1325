class Taxfree extends Product{

	public Taxfree(String name , double cost)
	{
		super(name , cost);

	}

	@Override
	public Product placeOrder(int quantity)
	{

		this.quantity=quantity;
		return this;
		

	}

	@Override
	public double price()
	{
		return (this.quantity*this.unitCost);

	}

	// public static void main(String[] args){
		
	// 	Taxfree Pen = new Taxfree ("pen" , 2.00);
	// 	System.out.println(Pen);
	// }
}
