
public class Student {
	
	private String name;
	private int grade;
	
	public Student(String studentName, int studentGrade)
	{
		this.name = studentName;
		this.grade = studentGrade;
	}	
	
	public String getName()
	{
		return name;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public void setGrade(int studentGrade)
	{
		this.grade = studentGrade;
	}
	
	public void setName(String studentName)
	{
		this.name = studentName;
	}
	public String toString()
	{
		return String.format("%s: %d", name,grade);
	}

}
