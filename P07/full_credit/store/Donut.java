 class Donut extends Product
 {

 

	public Frosting frosting;
	public boolean sprinkles;
	public Filling filling;

	public Donut(String name , double price , double cost , Frosting frosting , boolean sprinkles ,  Filling filling){
		super(name , price , cost);
		this.frosting = frosting;
		this.sprinkles=sprinkles;
		this.filling=filling;
	}

	@Override
	public String toString(){
		return (this.name+ " frosted with " +this.frosting + " and filled with " + this.filling + " $ " + this.price);
	}


	

}