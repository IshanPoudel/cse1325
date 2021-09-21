public class Fuse
{
	private int time;

	public Fuse(int time)
	{
		this.time = time;

	}

	public boolean burn()
	{
		this.time--;
		if(this.time>0){
			return true;
		}
		return false;



	}

	public String toString()
	{
		// if(this.time.equals(0))
		// {
		// 	System.out.println("GAME OVER");


		// }
		return("You have " + this.time + " guesses left" );


	}

}