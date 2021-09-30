package schoolManagementSystem;

public class Teacher {

	private int id;
	private int salary;
	private String name;
	private int salaryEarned;
	
	public Teacher(int id, String name,int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.salaryEarned = 0;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void recieveSalary(int salary) {
		salaryEarned +=salary;
		School.updateTotalMoneySpent(salary);
	}
	public String toString() {
		return "name of teacher :"+ name + "salary earned is" + salaryEarned;
	}
}
