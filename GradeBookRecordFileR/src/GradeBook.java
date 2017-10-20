import java.util.Scanner;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class GradeBook
{
   private Scanner input;
   private String fileName;
   private String courseName; // name of course this GradeBook represents
   private Student[] studentMember; // array of student grades
   
   // constructor
   public GradeBook(String courseName, String fileName)
   {
      this.courseName = courseName;
      //this.studentMember = studentMember;
      this.fileName = fileName;
      System.out.println("Filename: "+ this.fileName);
   } 

   // method to set the course name
   public void setCourseName(String courseName)
   {
      this.courseName = courseName; 
   } 

   // method to retrieve the course name
   public String getCourseName()
   {
      return courseName;
   } 
   
   //open file
   public void openFile()
   {
	   try
	   {
		   input = new Scanner(Paths.get(fileName));	
		   //input = new Scanner(new File("grades.txt"));
	   }
	   catch (IOException ioException)
	   {
		   System.err.println("Error opening file. Terminating.");
		   System.exit(1);
	   }
   }
   
 //read data from file
   public void readData()
   {
	   String tempName = "";
	   int tempGrade = 0;
	   String title = input.next();
	   int gradeCounter = input.nextInt();
	   studentMember =  new Student[gradeCounter];
		
	   int i = 0;
	   try
	   {
		   while (input.hasNext())
		   {
			   tempName = input.next();
	    	   tempGrade = input.nextInt();
	    	   studentMember[i++] = new Student(tempName,tempGrade);
		   }
	   }
	   catch (NoSuchElementException elementException)
	   {
		   System.err.println("File improperly formed. Terminating.");		   
	   }
	   catch (IllegalStateException stateException)
	   {
		   System.err.println("Error reading from file. Terminating");
	   }	
	   catch (ArrayIndexOutOfBoundsException e)
 	   {
 		   System.out.println(e);
 	   }
	   System.out.printf("%s = %d\n\n", title, gradeCounter);
   }
   
 //close file
   public void closeFile()
   {
	   if (input != null)
		   input.close();
   }  

   // perform various operations on the data
   public void processGrades()
   {
      openFile();
      readData();
	   // output grades array
      outputGrades();

      // call method getAverage to calculate the average grade      
      System.out.printf("%nClass average is %.2f%n", getAverage()); 

      // call methods getMinimum and getMaximum
      System.out.printf("Lowest grade is %s%nHighest grade is %s%n%n",
         getMinimum(), getMaximum());

      // call outputBarChart to print grade distribution chart
      outputBarChart();
      
      closeFile();
   } 

   // find minimum grade
   public Student getMinimum()
   { 
      int lowGrade = studentMember[0].getGrade(); // assume grades[0] is smallest
      int num = 0;
      // loop through grades array
      for (int i = 1; i<studentMember.length; i++) 
      {
         // if grade lower than lowGrade, assign it to lowGrade
         if (studentMember[i].getGrade() < lowGrade)
         {
            lowGrade = studentMember[i].getGrade(); // new lowest grade
            num = i;
         }
      } 

      return studentMember[num]; 
   } 

   // find maximum grade
   public Student getMaximum()
   { 
      int highGrade = studentMember[0].getGrade(); // assume grades[0] is largest
      int num = 0;
      // loop through grades array
      for (int i = 1; i<studentMember.length; i++) 
      {
         // if grade greater than highGrade, assign it to highGrade
    	  if (studentMember[i].getGrade() > highGrade)
          {
    		  highGrade = studentMember[i].getGrade(); // new highest grade
              num = i;
          } 
      }

      return studentMember[num];
   } 

   // determine average grade for test
   public double getAverage()
   {      
      int total = 0; 
 
      // sum grades for one student
      for (int i = 1; i<studentMember.length; i++)
         total += studentMember[i].getGrade();

      // return average of grades
      return (double) total / studentMember.length;
   } 

   // output bar chart displaying grade distribution
   public void outputBarChart()
   {
      System.out.println("Grade distribution:");

      // stores frequency of grades in each range of 10 grades
      int[] frequency = new int[11];
      
      // for each grade, increment the appropriate frequency 
      for (int i = 1; i<studentMember.length; i++)
         ++frequency[studentMember[i].getGrade() / 10];

      // for each grade frequency, print bar in chart
      for (int count = 0; count < frequency.length; count++)
      {
         // output bar label ("00-09: ", ..., "90-99: ", "100: ")
         if (count == 10)
            System.out.printf("%5d: ", 100); 
         else
            System.out.printf("%02d-%02d: ", 
               count * 10, count * 10 + 9); 
         
         // print bar of asterisks
         for (int stars = 0; stars < frequency[count]; stars++)
            System.out.print("*");

         System.out.println(); 
      } 
   } 

   // output the contents of the grades array
   public void outputGrades()
   {    
      System.out.printf("The grades are:%n%n");
      
      // output each student's grade
      for (int student = 0; student < studentMember.length; student++) 
         System.out.printf("Student: %s%n", 
        		 studentMember[student]);
   } 
} // end class GradeBook