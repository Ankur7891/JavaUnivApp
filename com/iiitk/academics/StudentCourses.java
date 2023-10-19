package com.iiitk.academics;
import com.iiitk.admin.*;
import com.iiitk.*;
public class StudentCourses extends Student implements University {
	public Course sCourse[];
	private int count;
	private int no_courses;
	public StudentCourses () {};
	public StudentCourses (Student s) {
		super(s);
		this.no_courses = s.getNoCourses();
		this.sCourse = new Course[no_courses];
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
		String ret = super.display()+"\n\n Registered Courses: \n";
		for (int i=0;i<sCourse.length;i++) {
			if (sCourse[i] == null) {
				break;
			}
			ret += sCourse[i].display();
		}
		return ret;
	}
}