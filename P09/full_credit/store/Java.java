package store;

import java.util.*;

public class Java extends Product
{
	protected ArrayList <Shot> shots = new ArrayList<Shot>();
	protected Darkness darkness;

	public Java(String name , double price , double cost , Darkness darkness)
	{
		super(name , price , cost);
		this.darkness=darkness;

	}

	public void addShot(Shot shot){
		this.shots.add(shot);
	}

	public String toString(){
		return (this.name + " with the following shots " + this.shots + " $" + this.price );
	}

	@Override
	public String getAttributes()
	{
		String s = new String(
			"J\n"+this.name+" "+this.price+" "+
			this.cost+" " + this.darkness+" ");

		

		for (Shot shot : this.shots)
		{
			s = s + shot + " ";
		}

		s = s + this.shots.size();

		

		return s;
	}

	public static void main(String[] args)
	{
		Java cof = new Java("Local" , 2.00 , 2.00 , Darkness.blond);
		cof.addShot(Shot.chocolate);
		cof.addShot(Shot.vanilla);
		System.out.println(cof);
		System.out.println(cof.getAttributes());
	}
}