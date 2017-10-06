// Fig. 7.14: GradeBook.java
// GradeBook class using an array to store test grades.

public class GradeBook
{
   private String courseName; // name of course this GradeBook represents
   private int[] grades; // array of student grades
   private int gradeCounter;
   // constructor
   public GradeBook(String courseName, int[] grades, int gradeCounter)
   {
      this.courseName = courseName;
      this.grades = grades; 
      this.gradeCounter = gradeCounter;
      System.out.println("Sizeof(grades)="+grades.length);
      System.out.println("Sizeof(this.grades)="+this.grades.length);
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

   // perform various operations on the data
   public void processGrades()
   {
      // output grades array
      outputGrades();

      // call method getAverage to calculate the average grade      
      System.out.printf("%nClass average is %.2f%n", getAverage()); 

      // call methods getMinimum and getMaximum
      System.out.printf("Lowest grade is %d%nHighest grade is %d%n%n",
         getMinimum(), getMaximum());

      // call outputBarChart to print grade distribution chart
      outputBarChart();
   } 

   // find minimum grade
   public int getMinimum()
   { 
      int lowGrade = grades[0]; // assume grades[0] is smallest

      // loop through grades array
      //for (int grade : grades)
      for (int i = 0; i<gradeCounter; i++)
      {
         // if grade lower than lowGrade, assign it to lowGrade
         if (grades[i] < lowGrade)
            lowGrade = grades[i]; // new lowest grade
      } 

      return lowGrade; 
   } 

   // find maximum grade
   public int getMaximum()
   { 
      int highGrade = grades[0]; // assume grades[0] is largest

      // loop through grades array
      //for (int grade : grades)
      for (int i = 0; i<gradeCounter; i++)
      {
         // if grade greater than highGrade, assign it to highGrade
         if (grades[i] > highGrade)
            highGrade = grades[i]; // new highest grade
      }

      return highGrade; 
   } 

   // determine average grade for test
   public double getAverage()
   {      
      int total = 0; 
 
      // sum grades for one student
      //for (int grade : grades)
      for (int i = 0; i<gradeCounter; i++)
         total += grades[i];

      // return average of grades
      return (double) total / gradeCounter;
   } 

   // output bar chart displaying grade distribution
   public void outputBarChart()
   {
      System.out.println("Grade distribution:");

      // stores frequency of grades in each range of 10 grades
      int[] frequency = new int[11];
      
      // for each grade, increment the appropriate frequency 
      //for (int grade : grades)
      for (int i = 0; i<gradeCounter; i++)
         ++frequency[grades[i] / 10];

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
      for (int student = 0; student < gradeCounter; student++) 
         System.out.printf("Student %2d: %3d%n", 
            student + 1, grades[student]);
   } 
} // end class GradeBook