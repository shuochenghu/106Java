
public class WrapperDemo {
	public static void main(String[] args)
	{
		Integer ageOfStudent = new Integer(20);
		
		System.out.print("原來int值：");
	    System.out.println(ageOfStudent.intValue());
	    
	    System.out.print("double型態值：");
	    System.out.println(ageOfStudent.doubleValue());

	    Integer ageOfOther = 10;
	    int result = ageOfStudent.compareTo(ageOfOther);
	    System.out.print("ageOfStudent");
	    
	    switch(result) {
	     case 1:
	    	System.out.print(" 大於 ");
	    	break;
	     case -1:
	    	System.out.print(" 小 於 ");
		    break;
	     case 0:
	    	 System.out.print(" 等於 ");
		    break;
	    }
	    System.out.println("ageOfOther");				
	}

}
