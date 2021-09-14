import java.util.Scanner;

public class student
{
	//Initialize attributes.
	String studentName;
	double examSum;
	double examNumGrades;


	//Create Constructor.
	public student(String name)
	{
		studentName=name;
		examSum=0.0;
		examNumGrades=0.0;
	}



	//Create methods.
	public String getName()
	{
		return studentName;


	}

	public void addExam(double num)
	{
		if(num>=0)
		{
			double sum = this.examSum;
	
		    this.examSum = sum + num;
		    this.examNumGrades = this.examNumGrades+1;

		}
		


	}

	
	public double average()
	{
		if(this.examNumGrades ==(0.0))
		{
			return 100;
		}
		

		return (this.examSum/this.examNumGrades);


	}



	public static void main(String[] args){
		//reads student's name;
		Scanner a = new Scanner(System.in);
		System.out.println("Enter the name of the student");
		String name = a.nextLine();

		//create object for that student.
		student newStudent  = new student(name);


		

		//requests exam grade
		//press Q to quit
		double examGrade = 1;

		while(examGrade > 0)
		{
			System.out.printf("Enter next grade (<0 when done): ");
		    examGrade = a.nextDouble();
		    newStudent.addExam(examGrade);

		}

		

		




		//print name and average;
	
		System.out.println(newStudent.getName() + " has an average of " + newStudent.average());


	}
}