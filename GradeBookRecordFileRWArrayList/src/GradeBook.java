import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;

public class GradeBook
{
   private Scanner input;
   private String fileName;
   private String courseName; // name of course this GradeBook represents
   private ArrayList<Student> studentMember = new ArrayList<Student>(); // array of student grades
   private static Formatter output;
   
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
	   try {
		   output = new Formatter("output.txt");
	   }
	   catch ( SecurityException securityException)
	   {
		   System.err.println("Write permisssion denied: Terminating.");
		   System.exit(1);
	   }
	   catch( FileNotFoundException fileNotFoundException )
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
	   //String title = input.next();
	   //int gradeCounter = input.nextInt();
	   //studentMember =  new Student[gradeCounter];
		
	   int i = 0;
	   try
	   {
		   while (input.hasNext())
		   {
			   tempName = input.next();
	    	       tempGrade = input.nextInt();
	    	       studentMember.add(new Student(tempName,tempGrade));
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
	   //System.out.printf("%s = %d\n\n", title, gradeCounter);
   }
   
 //close file
   public void closeFile()
   {
	   if (input != null)
		   input.close();
	   if (output != null)
		   output.close();
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
      Student lowGrade = studentMember.get(0); // assume grades[0] is smallest
      //int num = 0;
      // loop through grades array
      for (Student next: studentMember) 
      {
         // if grade lower than lowGrade, assign it to lowGrade
         if (next.getGrade() < lowGrade.getGrade())
         {
            lowGrade = next; // new lowest grade
            //num = i;
         }
      } 

      return lowGrade; 
   } 

   // find maximum grade
   public Student getMaximum()
   { 
      Student highGrade = studentMember.get(0); // assume grades[0] is largest
      int num = 0;
      // loop through grades array
      for (Student next: studentMember) 
      {
         // if grade greater than highGrade, assign it to highGrade
    	  	  if (next.getGrade() > highGrade.getGrade())
          {
    		  	  highGrade = next; // new highest grade
              //num = i;
          } 
      }

      return highGrade;
   } 

   // determine average grade for test
   public double getAverage()
   {      
      int total = 0; 
 
      // sum grades for one student
      for (Student next: studentMember)
         total += next.getGrade();

      // return average of grades
      return (double) total / studentMember.size();
   } 

   // output bar chart displaying grade distribution
   public void outputBarChart()
   {
      System.out.println("Grade distribution:");

      // stores frequency of grades in each range of 10 grades
      int[] frequency = new int[11];
      
      // for each grade, increment the appropriate frequency 
      for (Student next: studentMember)
         ++frequency[next.getGrade() / 10];

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
      for (Student next: studentMember) {
    	      System.out.printf("Student: %s%n", next);
    	      output.format("Student: %s%n", next.toString());
      }
         
   } 
} // end class GradeBook