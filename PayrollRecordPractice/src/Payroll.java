import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Payroll {
	private Scanner input;
	private String companyName;
	private String fileName;
	private ArrayList<Employee> payrollList = new ArrayList<Employee>();
	
	public Payroll(String cName, String fName)
	{
		companyName = cName;
		fileName = fName;
	}
	
	public void setCompanyName(String cName)
	{
		companyName = cName;
	}
	
	public String getCompanyName()
	{
		return companyName;
	}
	
	public void openFile()
	{
		try
		{
			input = new Scanner(Paths.get(fileName));
		}
	    catch (IOException ioException)
		{
	    	       System.err.println("Error opening file. Terminating.");
			   System.exit(1);
		}
	}
	public void readData()
    {
		String tempFirstName = "";
		String tempLastName = "";
		String tempSSNum = "";
			
		try
		{
	           while (input.hasNext())
			   {
				   tempFirstName = input.next();
		    	       tempLastName = input.next();
		    	       tempSSNum = input.next();
		    	       payrollList.add(new Employee(tempFirstName,tempLastName,tempSSNum));
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
	}  
	public void outputGrades()
	{    
	    System.out.printf("%s :%n%n", companyName);
	      
	      // output each student's grade
        for (Employee next: payrollList) 
	         System.out.printf("Employee: %s%n", next);
	} 

}
