import java.util.ArrayList;
import java.text.NumberFormat;
import java.lang.Math;

public class Primes extends Thread{

    private int numThreads;
    private ArrayList<Integer> prime_numbers = new ArrayList<Integer>();
    private int lower;
    private int upper;


    //Constructor
    public Primes(int numThreads)
    {
        this.numThreads = numThreads;

    }
    public Primes(int numThreads , int lower , int upper)
    {
        this.numThreads=numThreads;
        this.lower = lower;
        this.upper = upper;
    }

    @Override
    public void run()
    {
        

         for (int num = this.lower ; num<=this.upper;num++)
        {
            // System.out.println("I am checking if " + num + "is prime \n");
            if (isPrime(num))
            {
                //Add value to the arraylist

                this.prime_numbers.add(num);
               
            }
        }

        // System.out.println("Prime number in this run function");

        // for (Integer a: this.prime_numbers)
        // {
        //     System.out.println(a);
        // }
        


    }

    public void findPrimes(int lower , int upper)
    {

        //Divide into equal slices. 
        int numSlices ;
        numSlices = (int) (upper-lower)/numThreads;

        final Primes[] pThreads = new Primes[numThreads];
        System.out.println("Created " + numThreads + " threads" );



        //Create that many htreads.
        
        upper = (upper-lower)/numThreads;

        for (int i=0; i< numThreads;i++)
        {

            pThreads[i] = new Primes(numThreads , lower , upper);
            lower = upper;
            upper = upper + numSlices;
            pThreads[i].start();

        }

        

        try {
             for (int i = 0; i < numThreads; i++)
                 pThreads[i].join();
         } catch (InterruptedException e) {
         }

        for (int i=0; i<numThreads;i++)
       {
             // System.out.println("Prime numbers in thread" + (i) + "\n");
            for (Integer a: pThreads[i].prime_numbers)
            {
                //add to prime number array in 
                // System.out.println(a);
                this.prime_numbers.add(a);

                
            }
       }



        



        
    }

   

    public boolean isPrime(int num)
    {
        int squarerootOfNum = (int) Math.sqrt(num);

        for (int i= 2; i<= squarerootOfNum;i++)
        {
            if (num % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    public int numberOfPrimes()
    {
        return this.prime_numbers.size();
    }

    //Return Prime numbers arraylist  as Integer[]
    public Integer[] toArray()
    {
        Integer[] primeNumbersArray = new Integer[this.numberOfPrimes()];
        int i=0;
        for (Integer a: prime_numbers)
        {
            primeNumbersArray[i++]=a;
        }

        return primeNumbersArray;

    }

    public static void main(String[] args)
    {
        

        int numThreads = 1;
        int lower = 0;
        int upper = 1000; // defaults
        if(args.length > 0) numThreads = Integer.parseInt(args[0]);
        if(args.length > 1) lower = Integer.parseInt(args[1]);
        if(args.length > 2) upper = Integer.parseInt(args[2]);
        if(args.length > 3) {
            System.err.println("usage: java Primes [lower upper]");
            System.exit(-args.length);
        }
        
        

        Primes p = new Primes(numThreads);
        
        p.findPrimes(lower , upper);
        
       

        // System.out.println("Prime numbers in the arraylist \n");
        // for (Integer a: p.prime_numbers)
        // {
        //     System.out.println(a + "\n");
        // }

        
        long sum =0;
        Integer[] prime_numbers_sum = p.toArray();
        for (int i=0; i<p.numberOfPrimes();i++)
        {
            sum = (long) sum + prime_numbers_sum[i];
        }

        System.out.println("Sum: " + sum + "\n");


        
    }

}