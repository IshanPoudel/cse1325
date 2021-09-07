import java.util.Arrays;
import java.lang.Math;

public class roller
{
	public static void main(String[] args)
	{

		if (args.length!=2)
		{
			System.err.println("usage: java Roll [#dice] [#sides]");
			System.exit(0);

		}
		int numDieToRoll = Integer.parseInt(args[0]);
		int numFaces =Integer.parseInt(args[1]);


		// System.out.println(numDieToRoll + "Hey" + numFaces);

		
		//declare min and max for random
		int min=1;
		int max=numFaces;

		int sum =0;


		int[] dieroll= new int[numDieToRoll];
		for (int i=0; i<numDieToRoll;i++)
		{
			dieroll[i]=(int) (Math.random()*(max-min+1)+min);
			sum = sum+dieroll[i];
			

		}

		//sort the array
		Arrays.sort(dieroll);

		//print all values
		
		for (int i=0; i<numDieToRoll-1;i++)
		{
			
			
			System.out.printf(dieroll[i] + "," );

		}
		System.out.println(dieroll[numDieToRoll-1]);
		System.out.println("The total sum is " + sum);
		System.out.println("The avergae  is " + (int) sum/numDieToRoll);







	}

}