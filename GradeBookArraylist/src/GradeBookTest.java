// MODIFY Fig. 7.15: GradeBookTest.java
// GradeBookTest creates a GradeBook object using an array of grades, 
// then invokes method processGrades to analyze them.
import java.util.ArrayList;
import java.util.Scanner;
public class GradeBookTest
{ 
   // main method begins program execution
   public static void main(String[] args)
   {
      // one-dimensional array of student grades
      //int[] gradesArray = new int[6];
	  ArrayList<Integer> gradesArrayList = new ArrayList<Integer>();
      int gradeCounter = 0;
      Scanner input = new Scanner(System.in);
      System.out.println("輸入分數：");
      while (input.hasNext())
      {
    	  //try
    	  //{
    		  gradesArrayList.add(input.nextInt());
    		  gradeCounter++;
    	  //}
    	  //catch (ArrayIndexOutOfBoundsException e)
    	  //{
    		  //System.out.println(e);
    		  //break;
    	  //}
      }
      System.out.printf("gradeCounter = %d\n\n", gradeCounter);
      
      GradeBook myGradeBook = new GradeBook(
         "CS101 Introduction to Java Programming", gradesArrayList);
      System.out.printf("Welcome to the grade book for%n%s%n%n", 
         myGradeBook.getCourseName());
      myGradeBook.processGrades();
   } 
} // end class GradeBookTest