public class Student {
	private String id;
	private String name;
	private Date birthDate;
	
	public Student(String studentID,String studentName, int month, int day, int year)
	{
		this.id = studentID;
		this.name = studentName;
		this.birthDate = new Date(month, day, year);
	}	
	
	public String getName()
	{
		return name;
	}
	
	public String getID()
	{
		return id;
	}
	
	public Date getBirthDate()
	{
		return birthDate;
	}
	
	public String LetterGrade()
	{
		return "NONE";
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s%n%s: %s", id, name, "Birthday", birthDate);
	}

}