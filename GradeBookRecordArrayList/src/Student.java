
public class Student {
	
	private String name;
	private int Grade;
	
	public Student(String studentName, int studentGrade)
	{
		this.name = studentName;
		this.Grade = studentGrade;
	}	
	
	public String getName()
	{
		return name;
	}
	
	public int getGrade()
	{
		return Grade;
	}
	
	public void setGrade(int studentGrade)
	{
		this.Grade = studentGrade;
	}
	
	public void setName(String studentName)
	{
		this.name = studentName;
	}
	public String toString()
	{
		return String.format("%s: %d", name,Grade);
	}

}