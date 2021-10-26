package store;

public abstract class Product
{
	protected  String name;
	protected double price;
	protected double cost;


	public Product(String name , double price , double cost)
	{
		this.name = name;
		this.price = price;
		this.cost = cost;
	}

	public String getName()
	{
		return this.name;
	}

	public double getPrice()
	{
		return this.price;
	}

	public double getCost()
	{
		return this.cost;
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