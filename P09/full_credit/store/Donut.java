package store;

import java.io.*;

public class Donut extends Product 
 {

 

	
	public Frosting frosting;
	public boolean sprinkles;
	public Filling filling;
    

	public Donut(String name , double price , double cost , boolean sprinkles , Frosting frosting , Filling filling)
	{
		
		super(name , price , cost);
		this.sprinkles = sprinkles;
		this.filling = filling;
		this.frosting=frosting;
		
	}



	@Override
	public String toString(){
		return (this.name+ " frosted with " +this.frosting + " and filled with " + this.filling + " $ " + this.price);
	}

	@Override
	public String getAttributes()
	{
		String s = new String(
			"D\n"+this.getName()+" "+this.price+" "+
			this.cost+" "+this.sprinkles+" "+this.frosting
			+" "+this.filling);

		return s;
	}



	

   // public static void main(String[] args )
   // {
   // 	 Donut localDonut = new Donut ("LocalDonut" , 2.0 , 0.5 , true , Frosting.unfrosted , Filling.creme);
   	 

   // 	 System.out.println("Donut constructed from reading file");
   	 
   // 	 System.out.println(localDonut.getAttributes());
   	  

   // }


	

}