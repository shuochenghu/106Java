package fileOp;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileUtility {
	 
	   private String filename;
	   private Scanner input;
	   public FileUtility(String filename)
	   {
		   this.filename =  filename;
	   }
	
	
	   public Scanner openFileforR()
	   {
		   try
		   {
			   input = new Scanner(Paths.get(filename));	
			   //input = new Scanner(new File("grades.txt"));
		   }
		   catch (IOException ioException)
		   {
			   System.err.println("Error opening file. Terminating.");
			   System.exit(1);
		   }
		   return input;
	   }
	   
	   public void closeFile(Scanner input)
	   {
		   if (input != null)
			   input.close();
	   } 

}
