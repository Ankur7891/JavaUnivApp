package com.iiitk.academics;
import com.iiitk.*;
import com.iiitk.admin.*;
public class AcademicsApp extends AdminApp implements University {
	static int total_courses, c_count;
	Course course[];
	public AcademicsApp() {
		System.out.println("\n--------------------------------------");
		System.out.println("\n  Welcome to Academics Dept of IIITK  ");
		System.out.println("\n--------------------------------------");
		System.out.print("\nEnter Nof. Courses: "); 
		total_courses = University.sc.nextInt();
		this.course = new Course[total_courses];
		c_count = 0;
		display();
	}
	public void displayCourses() {
		for(int i=0;i<c_count;i++) {
			System.out.println(course[i].display());
		}
	}
	public void addStudentCourses() {
		if (stu_count == 0) {
			System.out.println("\n   => No Student Added Yet (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<student.length;i++) {
			System.out.print("\n\t\t"+(i+1)+". "+student[i].getName());
		}
		System.out.print("\n\tYour Choice: "); 
		int id = sc.nextInt();
		if (id >= 0 && id <= student.length-1) {
			int n = student[id-1].getNoCourses();
			StudentCourses sc[] = new StudentCourses[n];
			for (int i=0;i<n;i++) {
				sc[i].this();
			}
			System.out.println("\n Course Addition Successful.\n");
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void addFacultyCourses() {

	}
	public void displayStudentCourses() {

	}
	public void displayFacultyCourses() {

	}
	public String display() {
		while (true) {
			System.out.print("\nChoose : \n\t1. Add Course Details\n\t2. Display Course Details\n\t3. Add Student-Course Details\n\t4. Add Faculty-Course Details\n\t5. Display Student-Course Details\n\t6. Display Faculty-Course Details\n\t7. Return to University App...\n   => ");
			switch (University.sc.nextInt()) {
				case 1: if (c_count<total_courses) {
							course[c_count] = new Course();
							course[c_count].readData();
							c_count++;
							System.out.println("\n Insertion Successful.\n");
						} else {
							System.out.println("\n   => Maximum Student Data in the App!...");
						} break;
				case 2: displayCourses(); break;
				case 3: addStudentCourses(); break;
				case 4: addFacultyCourses(); break;
				case 5: displayStudentCourses(); break;
				case 6: displayFacultyCourses(); break;
				case 7: return null;
				default: System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
			}
			try { 
				Runtime.getRuntime(); 
			} catch (Exception e) {
				System.out.println("\n *-*-*-*-* Execption Caught! *-*-*-*-* \n");
			};
		}
	}
}