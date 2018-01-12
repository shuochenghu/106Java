
public class UnderGraduateStudent extends Student{

	private int grade;
	public UnderGraduateStudent(String studentID, String studentName, int year, int month, int day, int grade) {
		super(studentID, studentName, year, month, day);
		
		setGrade(grade);
	}
	
	public void setGrade(int grade) {
		if (grade>=0 && grade <= 100)
			this.grade = grade;
		else
			throw new IllegalArgumentException("Grade must be >=0 and <= 100");
	}

	@Override
	public String LetterGrade() {
		String letterGrade;
		switch(this.grade/10) {
		case 10:
		case 9:
			letterGrade = "A";
			break;
		case 8:
			letterGrade = "B";
			break;
		case 7:
			letterGrade = "C";
			break;
		case 6:
			letterGrade = "D";
			break;
		default:
			letterGrade = "F";
			break;			
		}
		return letterGrade;
	}

	@Override
	public String toString() {
		return String.format("%s: %s%n%s:%s%n","Undergraduate Student",super.toString(),"Letter Grade",LetterGrade());
	}
}
