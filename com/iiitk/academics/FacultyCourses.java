package com.iiitk.academics;
import com.iiitk.admin.*;
import com.iiitk.*;
public class FacultyCourses extends Faculty implements University {
	public Course fCourse[];
	private int count;
	private int no_courses;
	public FacultyCourses () {};
	public FacultyCourses (Faculty f) {
		super(f);
		this.no_courses = f.getNoCourses();
		this.fCourse = new Course[no_courses];
		this.count = 0;
	}
	public int getNofCourses() {
		return this.no_courses;
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int c) {
		this.count = c;
	}
	public String display() {	
		String ret = super.display()+"\n\n Teaching Courses: \n";
		for (int i=0;i<fCourse.length;i++) {
			if (fCourse[i] == null) {
				break;
			}
			ret += fCourse[i].display();
		}
		return ret;
	}
}