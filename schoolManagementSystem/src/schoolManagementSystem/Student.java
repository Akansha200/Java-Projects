package schoolManagementSystem;

public class Student {
private int id;
private String name;
private int grade;
private int feesPaid;
private int feesTotal;
//initial fees paid is 0 and total fees is 30000
public Student(int id,String name,int grade) {
	this.id = id;
	this.grade= grade;
	this.name = name;
	this.feesPaid = 0;
	this.feesTotal = 30000;
}

public void setGrade(int grade) {
	this.grade = grade;
}
//fees that student pays
public void payfees(int fees) {
	feesPaid += fees;
	School.updateTotalMoneyEarned(feesPaid);
}

public int getId() {
	return id;
}


public String getName() {
	return name;
}



public int getFeesPaid() {
	return feesPaid;
}



public int getFeesTotal() {
	return feesTotal;
}



public int getGrade() {
	return grade;
}

public int getRemainingFees() {
	return feesTotal = feesPaid;
}

public String toString() {
	return "Student's name:" + name+ "Total fees paid so far is Rs"+ feesPaid;
}

}

