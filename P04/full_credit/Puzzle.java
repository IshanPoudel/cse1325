class Puzzle{

	private String solution;
	private boolean[] guesses;

	public Puzzle(String soln)
	{
		this.solution=soln;
		this.guesses = new boolean[26];


	}

	public boolean guess(char c){
		
		int len = this.solution.length();

		for(int i=0;i<len;i++){

			char to_check=this.solution.charAt(i);

			if(Character.compare(to_check , c)==0)
			{
				this.guesses[(int) to_check-97]=true;
				return true;
			}
		}
		return false;
	}

	//use the boolean of isguess to decrease fuse

	public void solve(String proposedSolution){

		if(proposedSolution.equals(this.solution) )
		{
			System.out.println(" ");
			System.out.println("CONGRATS YOU WON");
			System.out.println(" ");
			System.exit(0);

		}
		else{
			System.out.println(" You lost ");
			System.out.println("The correct phrase: " + this.getSolution());
		    System.exit(0);
		}
	}

	

	public String getSolution(){
		return this.solution;
	}


	 public  String toString(){

	 	String soln = this.getSolution();
	 	int len = soln.length();

	 	//convert solution to char
	 	char[] ch = soln.toCharArray();
	 	// convert each char to its corresponding index
	 	//create anarray to store bools.
	 	int char_to_index=0;
	 	for (int i=0; i<len;i++)
	 	{
	 		char_to_index=(int) ch[i] -97;
	 		if(this.guesses[char_to_index]){
	 		}
	 		else
	 		{
	 			ch[i]='-';

	 		}
	 		

	 	}
	 	
	 	// convert it back to string.
	 	String str = new String(ch);

	 	return str;
 


	 }

	 	

	 



	public static void main(String[] args){
		
		

	}
}