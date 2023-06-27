package com.iiitk.academics;
import com.iiitk.admin.*;
import com.iiitk.*;
class FacultyCourses extends Faculty implements University {
	Course course[];
	private int count;
	private int no_courses;
	FacultyCourses (Faculty f) {
		super(f);
		no_courses = f.getNoCourses();
		course = new Course[no_courses];
		count=0;
	}
	public void add (Course c) {
		if (no_courses == 0) {
			System.out.println("Choose number of teaching courses !!\n");
		}
		if (count<no_courses) {
			course[count++] = c;
		}
	}
	public String display() {	
		String ret = super.display()+"\nTeaching Courses: \n";
		for (int i=0;i<course.length;i++) {
			ret+=course[i].display();
		}
		return ret;
	}
}