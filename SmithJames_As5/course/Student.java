package course;

public class Student {

	private String name;
	private int studentID;
	
	public Student(String n, int id)
	{
		this.name = n;
		this.studentID = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String toString()
	{
		return "Name: " + this.name + " ID: " + this.studentID;
		
	}
}
