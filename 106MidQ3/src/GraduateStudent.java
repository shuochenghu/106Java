
public class GraduateStudent extends Student{
	
	private boolean defense;
	
	public GraduateStudent(String studentID, String studentName, int year, int month, int day, boolean result) {
		super(studentID, studentName, year, month, day);
		
		this.defense = result;
	}

	@Override
	public String LetterGrade() {
		
		if (defense)
			return "PASS!";
		else
			return "FAIL!";					
	}
		
	@Override
	public String toString() {
		return String.format("%s: %s%n%s:%s%n","Graduate Student",super.toString(),"Oral Defense",LetterGrade());
	}
}
