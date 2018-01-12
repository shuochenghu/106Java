
public class StudentTest {

	public static void main(String[] args) {
		
		UnderGraduateStudent student1 = new UnderGraduateStudent("A1063838","Jesica Chen", 11, 25, 1998, 78);
		GraduateStudent student2 = new GraduateStudent("M1051117","Jimmy Yu", 8, 28, 1997, true);
		
		System.out.printf("%s%n%n%s",student1,student2 );
	}

}
