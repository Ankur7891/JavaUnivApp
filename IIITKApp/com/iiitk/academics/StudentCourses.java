package com.iiitk.academics;
import com.iiitk.admin.*;
import com.iiitk.*;
class StudentCourses extends Student implements University {
	Course course[];
	private int count;
	private int no_courses;
	StudentCourses (Student s) {
		super(s);
		no_courses = s.getNoCourses();
		course = new Course[no_courses];
		count = 0;
	}
	void add (Course c) {
		if (no_courses == 0) {
			System.out.print("Choose Nof. Subjects to Register in This Semester: ");
			int n = Integer.parseInt(University.sc.next());
			no_courses = Integer.valueOf(n);
		}
		if (count<no_courses) {
			course[count++] = c;
		}
	}
	public String display() {	
		String ret = super.display()+"\n Registered Courses: \n";
		for (int i=0;i<course.length;i++) {
			ret += course[i].display();
		}
		return ret;
	}
}