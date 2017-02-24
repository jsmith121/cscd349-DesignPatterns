import java.util.ArrayList;
import java.util.Iterator;
import course.*;
import course.Course.CourseIterator;

public class CourseIteratorTester {

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Student 1", 12345));
		students.add(new Student("Student 2", 67890));
		students.add(new Student("Student 3", 23568));
		students.add(new Student("Student 4", 88297));
		students.add(new Student("Student 5", 92874));
		students.add(new Student("Student 6", 12345));
		students.add(new Student("Student 7", 67890));
		students.add(new Student("Student 8", 23568));
		students.add(new Student("Student 9", 88297));
		students.add(new Student("Student 10", 92874));
		Course course = new Course(students);		

		System.out.println("Enhanced For:");
		Iterator<Student> iter = course.iterator();
		for(Student s: course)
		{
			System.out.println(s.toString());
		}
		System.out.println("\nWhile:");
		while(iter.hasNext())
		{
			Student s = (Student) iter.next();
			System.out.println(s.toString());
			
		}
		
	}

}
