package course;

import java.util.ArrayList;
import java.util.Iterator;

public class Course implements Iterable<Student>{

	private ArrayList<Student> students;
	
	public Course(ArrayList<Student> s)
	{
		this.students = s;
	}

	@Override
	public Iterator<Student> iterator() { return new CourseIterator(this.students);}
	
	public class CourseIterator implements Iterator<Student>
	{
		
		private ArrayList<Student> students;
		private int cur;
		
		public CourseIterator(ArrayList<Student> s)
		{
			this.students = s;
			this.cur = 0;
		}
		
		@Override
		public boolean hasNext() {
			if(cur<this.students.size())
				return true;
			return false;
		}

		@Override
		public Student next() {
			Student stu = this.students.get(cur);
			cur++;
			return stu;
		}
		
	}
	
}
