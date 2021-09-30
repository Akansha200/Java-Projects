package schoolManagementSystem;
import java.util.List;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		Teacher prem = new Teacher(1,"prem",500);
		Teacher harry = new Teacher(2,"harry",1500);
		Teacher mona = new Teacher(3,"mona",3500);
		Teacher priya = new Teacher(4,"priya",800);
		
		List<Teacher> teacherList = new ArrayList<>();
		teacherList.add(prem);
		teacherList.add(harry);
		teacherList.add(mona);
		teacherList.add(priya);
		
		Student tamanna = new Student(1,"tamanna",5);
		Student aashna = new Student(2,"aashna",6);
		Student rita = new Student(3,"rita",9);
		Student rohit = new Student(4,"rohit",2);
		List<Student> studentList = new ArrayList<>();
		studentList.add(rohit);
		studentList.add(rita);
		studentList.add(aashna);
		studentList.add(tamanna);
		
		School lvs = new School(teacherList,studentList);
		
		tamanna.payfees(5000);
		
rita.payfees(8000);
System.out.println("lvs has earned rs"+ lvs.getTotalMoneyEarned());

System.out.println(".....MAKING SCHOOL PAY SALARY.....");
harry.recieveSalary(harry.getSalary());
System.out.println("lvs has spend for salary to " + harry.getName()+ "and now has rs"
		+ ""+ lvs.getTotalMoneyEarned());
System.out.println(tamanna);
System.out.println(harry);
	}

}
