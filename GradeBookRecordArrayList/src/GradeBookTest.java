
import java.util.ArrayList;
import java.util.Scanner;
public class GradeBookTest
{ 
   // main method begins program execution
   public static void main(String[] args)
   {
      // one-dimensional array of student grades
      //Student[] myClass = new Student[6];
	  ArrayList<Student> myClass = new ArrayList<Student>();
      int gradeCounter = 0;
      String tempName="";
      int tempGrade = 0;
      Scanner input = new Scanner(System.in);
      System.out.println("輸入姓名及成績：");
      
      while (input.hasNext())
      {
    	  tempName = input.next();
    	  tempGrade = input.nextInt();
    	  myClass.add(new Student(tempName,tempGrade));
    	  gradeCounter++;    	  
      }
      System.out.printf("gradeCounter = %d\n\n", gradeCounter);
      
      GradeBook myGradeBook = new GradeBook(
         "CS101 Introduction to Java Programming", myClass);
      System.out.printf("Welcome to the grade book for%n%s%n%n", 
         myGradeBook.getCourseName());
      myGradeBook.processGrades();
   } 
}