
//import java.util.Scanner;
public class GradeBookTest
{ 
   // main method begins program execution
   public static void main(String[] args)
   {
      // one-dimensional array of student grades
      /*Student[] myClass = new Student[6];
      int gradeCounter = 0;
      String tempName="";
      int tempGrade = 0;
      Scanner input = new Scanner(System.in);
      System.out.println("輸入姓名及成績：");
      while (input.hasNext())
      {
    	  try
    	  {
    		  tempName = input.next();
    		  tempGrade = input.nextInt();
    		  myClass[gradeCounter] = new Student(tempName,tempGrade);
    		  gradeCounter++;
    	  }
    	  catch (ArrayIndexOutOfBoundsException e)
    	  {
    		  System.out.println(e);
    		  break;
    	  }
      }
      System.out.printf("gradeCounter = %d\n\n", gradeCounter);*/
      
      GradeBook myGradeBook = new GradeBook(
         "CS101 Introduction to Java Programming", "c:\\GradeBookData.txt");
      System.out.printf("Welcome to the grade book for%n%s%n%n", 
         myGradeBook.getCourseName());
      myGradeBook.processGrades();
   } 
}