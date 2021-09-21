import java.util.Scanner;

public class Boom{

	
	private Puzzle puzzle;
	private Fuse fuse;
	

	

	public void cli(){
		puzzle = new Puzzle ("persistence");
		fuse = new Fuse(6);



		System.out.println(fuse);
		System.out.println(puzzle);

		String proposedsoln = new String();

		Scanner input = new Scanner (System.in);

		//create bool to return of fuse.
		boolean a = true;

		int b=0;


		
		while(true)
		{
			char c = input.nextLine().charAt(0);

			switch(c)
			{
				case '!':
				     System.out.println("What is the solution?");
				     proposedsoln=input.nextLine();
				     puzzle.solve(proposedsoln);

				case '0':
				     System.exit(0);
				default:
				     
				     

				     
				     if(puzzle.guess(c))
				     {
				     	System.out.println( c + " is in the phrase!!");
				     	System.out.println("   " +puzzle);
				     	System.out.println("   " +fuse);
				     	

				     	//check if the person got the whole part.

				     	//check the number of true guesses.

				     	//compare puzzle with solution.
				     	if( puzzle.toString().equals( puzzle.getSolution() )   )
		                {
		                   System.out.println(" ");
			               System.out.println("   CONGRATS! YOU WON");
			               System.out.println(" ");
			               System.exit(0);

		                }



				     }
				     else   //the user guessed wrong.
				     {

				     	 a = fuse.burn();
				     	 System.out.println("   Wrong!. Guess Again");
				     	 System.out.println("   " +puzzle);
				     	 System.out.println("   " +fuse);

				     	 if(a==false)
				     	 {
				     	 	System.out.println("Game Over");
				     	 	System.out.println("The correct phrase: " + puzzle.getSolution());
				     	 	System.exit(0);

				     	 }

				     }


			}

		}
		


	}

	public static  void main(String[] args)
	{

		
		Boom boom = new Boom();
		System.out.println("\tWelcome to BOOM\t");
		System.out.println(" Enter lower case letters to guess , \t");
		System.out.println(" ! to propose a solution , ");
		System.out.println(" 0 to exit");
		
		boom.cli();
	}




}