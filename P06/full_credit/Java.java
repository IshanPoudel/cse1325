import java.util.*;

class Java extends Product
{
	
	

	protected ArrayList<Shot> shots = new ArrayList<Shot>();
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

	public static void main(String[] args)
	{
		System.out.println("Hey");
		Java cof = new Java("Local" , 2.00 , 2.00 , Darkness.blond);
		cof.addShot(Shot.chocolate);
		cof.addShot(Shot.vanilla);
		System.out.println(cof);



	}




}