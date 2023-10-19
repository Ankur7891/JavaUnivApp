package com.iiitk.academics;
import com.iiitk.*;
import com.iiitk.admin.*;
import java.util.HashMap;
public class AcademicsApp implements University {
	public static int total_courses, c_count;
	private static HashMap <String,Integer> cCodeUnq = new HashMap <String,Integer>(); 
	private static HashMap <String,Integer> cNameUnq = new HashMap <String,Integer>();
	public Course course[];
	public StudentCourses sc[] = new StudentCourses[AdminApp.total_students];
	public FacultyCourses fc[] = new FacultyCourses[AdminApp.total_faculty];
	public AcademicsApp() {        
		System.out.println("\n--------------------------------------");
		System.out.println("\n  Welcome to Academics Dept of IIITK  ");
		System.out.println("\n--------------------------------------");
		System.out.print("\nEnter Nof. Courses: "); 
		total_courses = University.sc.nextInt();
		this.course = new Course[total_courses];
		c_count = 0;
		for (int i=0;i<AdminApp.total_students;i++) {
			if (UniversityApp.university.admin.student[i] == null) {
				break;
			}
			sc[i] = new StudentCourses(UniversityApp.university.admin.student[i]);
		}
		for (int i=0;i<AdminApp.total_faculty;i++) {
			if (UniversityApp.university.admin.faculty[i] == null) {
				break;
			}
			fc[i] = new FacultyCourses(UniversityApp.university.admin.faculty[i]);
		}
		display();
	}
	public void displayCourses() {
		System.out.println();
		for(int i=0;i<c_count;i++) {
			System.out.println(course[i].display());
		}
	}
	public void addStudentCourses() {		
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.stu_count == 0) {
			System.out.println("\n   => Student Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<UniversityApp.university.admin.student.length;i++) {
			if (UniversityApp.university.admin.student[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.student[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: ");
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.student.length) {
			boolean contd = true;
			while (contd) {
				if (sc[id-1] != null && sc[id-1].getCount() == sc[id-1].getNofCourses()) {
					System.out.println("\n   => Maximum Courses Registered for the Student!...");
					return;
				}
				if (sc[id-1].getNoCourses() > c_count) {
					System.out.println("\n   => Nof. Students' Courses must be at Max the Nof. Courses in the University!...");
					System.out.println("   => Admin Needs to Update the Nof. Courses for This Student!...");
					return;
				}
				boolean cont = true;
				while (cont) {
					cont = false;
					System.out.println("\n\tChoose a Course:");
					for (int i=0;i<course.length;i++) {
						System.out.print("\n\t\t"+(i+1)+". "+course[i].name);
					}
					System.out.print("\n\tYour Choice: "); 
					int code = Integer.parseInt(University.sc.next());
					if (code <= 0 || code > course.length) {
						System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
					} else {
						int count = sc[id-1].getCount();
						for (int i=0;i<count;i++) {
							if (sc[id-1].sCourse[i].code == course[code-1].code) {
								System.out.println("\n   => Courses must be Unique for Each Member!...\n\t Kindly, Choose the Course Again:");
								cont = true;
							}
						}
						if (cont == false) {
							sc[id-1].sCourse[count] = new Course(course[code-1].code,course[code-1].name,course[code-1].credits,course[code-1].semester);
							sc[id-1].setCount(count+1);
							System.out.println("\n Course Addition Successful.\n");
							break;
						}
					}
				}
				System.out.print("\n Q. Do You Want to Add More Courses? (Y/N - Default) : ");
				char c = University.sc.next().charAt(0);
				c = Character.toUpperCase(c);
				if (c == 'Y') {
					contd = true;
				} else if (c == 'N') {
					contd = false;
				} else {
					contd = false;
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				}
			}
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void addFacultyCourses() {
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.fac_count == 0) {
			System.out.println("\n   => Faculty Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Faculty:");
		for(int i=0;i<UniversityApp.university.admin.faculty.length;i++) {
			if (UniversityApp.university.admin.faculty[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.faculty[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: "); 
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.faculty.length) {
			boolean contd = true;
			while (contd) {
				if (fc[id-1] != null && fc[id-1].getCount() == fc[id-1].getNofCourses()) {
					System.out.println("\n   => Maximum Courses Registered for the Faculty!...");
					return;
				}
				if (fc[id-1].getNoCourses() > c_count) {
					System.out.println("\n   => Nof. Faculty' Courses must be at Max the Nof. Courses in the University!...");
					System.out.println("   => Admin Needs to Update the Nof. Courses for This Faculty!...");
					return;
				}
				boolean cont = true;
				while (cont) {
					cont = false;
					System.out.println("\n\tChoose a Course:");
					for (int i=0;i<course.length;i++) {
						System.out.print("\n\t\t"+(i+1)+". "+course[i].name);
					}
					System.out.print("\n\tYour Choice: "); 
					int code = Integer.parseInt(University.sc.next());
					if (code <= 0 || code > course.length) {
						System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
					} else {
						int count = fc[id-1].getCount();
						for (int i=0;i<count;i++) {
							if (fc[id-1].fCourse[i].code == course[code-1].code) {
								System.out.println("\n   => Courses must be Unique for Each Member!...\n\t Kindly, Choose the Course Again:");
								cont = true;
							}
						}
						if (cont == false) {
							fc[id-1].fCourse[count] = new Course(course[code-1].code,course[code-1].name,course[code-1].credits,course[code-1].semester);
							fc[id-1].setCount(count+1);
							System.out.println("\n Course Addition Successful.\n");
							break;
						}
					}
				}
				System.out.print("\n Q. Do You Want to Add More Courses? (Y/N - Default) : ");
				char c = University.sc.next().charAt(0);
				c = Character.toUpperCase(c);
				if (c == 'Y') {
					contd = true;
				} else if (c == 'N') {
					contd = false;
				} else {
					contd = false;
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				}
			}
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void editStudentCourses() {
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.stu_count == 0) {
			System.out.println("\n   => Student Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<UniversityApp.university.admin.student.length;i++) {
			if (UniversityApp.university.admin.student[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.student[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: "); 
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.student.length) {
			boolean contd = true;
			while (contd) {
				int n = sc[id-1].getCount();
				if (n == 0) {
					System.out.println("\n   => No Student-Course Data to be Updated!...\n");
					return;
				}
				if (sc[id-1].getNoCourses() > c_count) {
					System.out.println("\n   => Nof. Students' Courses must be at Max the Nof. Courses in the University!...");
					System.out.println("   => Admin Needs to Update the Nof. Courses for This Student!...");
					return;
				}
				System.out.println("\n\tChoose a Student-Course:");
				for (int i=0;i<n;i++) {
					System.out.print("\n\t\t"+(i+1)+". "+sc[id-1].sCourse[i].name);
				}
				System.out.print("\n\tYour Choice: ");
				int code = Integer.parseInt(University.sc.next());
				if (code <= 0 || code > course.length) {
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				} else {
					System.out.println("\n\tEnter New Data for the Course:");
					Course temp = new Course();
					temp.readData();
					while (true) {
						if (cCodeUnq.get(temp.code) == null) {
							cCodeUnq.put(temp.code,1);
							cCodeUnq.put(sc[id-1].sCourse[code-1].code,null);
							break;
						} else {
							System.out.print("\n   => Course Code must be Unique!...\n\t Kindly, Re-Enter the Course Code: ");
							temp.code = University.sc.next(); 
						}
					}							
					while (true) {
						if (cNameUnq.get(temp.name) == null) {
							cNameUnq.put(temp.name,1);
							cNameUnq.put(sc[id-1].sCourse[code-1].name,null);
							break;
						} else {
							System.out.print("\n   => Course Name should be Unique!...\n\t Kindly, Re-Enter the Course Name: ");
							temp.name = University.sc.next(); 
						}
					}
					sc[id-1].sCourse[code-1] = temp;
					temp = null;
					System.out.println("\n Course Updation Successful.\n");
				}
				System.out.print("\n Q. Do You Want to Update More Courses? (Y/N - Default) : ");
				char c = University.sc.next().charAt(0);
				c = Character.toUpperCase(c);
				if (c == 'Y') {
					contd = true;
				} else if (c == 'N') {
					contd = false;
				} else {
					contd = false;
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				}
			}
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void editFacultyCourses() {
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.fac_count == 0) {
			System.out.println("\n   => Faculty Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Faculty:");
		for(int i=0;i<UniversityApp.university.admin.faculty.length;i++) {
			if (UniversityApp.university.admin.faculty[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.faculty[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: "); 
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.faculty.length) {
			boolean contd = true;
			while (contd) {
				int n = fc[id-1].getCount();
				if (n == 0) {
					System.out.println("\n   => No Faculty-Course Data to be Updated!...\n");
					return;
				}
				if (fc[id-1].getNoCourses() > c_count) {
					System.out.println("\n   => Nof. Faculty' Courses must be at Max the Nof. Courses in the University!...");
					System.out.println("   => Admin Needs to Update the Nof. Courses for This Faculty!...");
					return;
				}
				System.out.println("\n\tChoose a Faculty-Course:");
				for (int i=0;i<n;i++) {
					System.out.print("\n\t\t"+(i+1)+". "+fc[id-1].fCourse[i].name);
				}
				System.out.print("\n\tYour Choice: ");
				int code = Integer.parseInt(University.sc.next());
				if (code <= 0 || code > course.length) {
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				} else {
					System.out.println("\n\tEnter New Data for the Course:");
					Course temp = new Course();
					temp.readData();
					while (true) {
						if (cCodeUnq.get(temp.code) == null) {
							cCodeUnq.put(temp.code,1);
							cCodeUnq.put(fc[id-1].fCourse[code-1].code,null);
							break;
						} else {
							System.out.print("\n   => Course Code must be Unique!...\n\t Kindly, Re-Enter the Course Code: ");
							temp.code = University.sc.next(); 
						}
					}							
					while (true) {
						if (cNameUnq.get(temp.name) == null) {
							cNameUnq.put(temp.name,1);
							cNameUnq.put(fc[id-1].fCourse[code-1].name,null);
							break;
						} else {
							System.out.print("\n   => Course Name should be Unique!...\n\t Kindly, Re-Enter the Course Name: ");
							temp.name = University.sc.next(); 
						}
					}
					fc[id-1].fCourse[code-1] = temp;
					temp = null;
					System.out.println("\n Course Updation Successful.\n");
				}
				System.out.print("\n Q. Do You Want to Update More Courses? (Y/N - Default) : ");
				char c = University.sc.next().charAt(0);
				c = Character.toUpperCase(c);
				if (c == 'Y') {
					contd = true;
				} else if (c == 'N') {
					contd = false;
				} else {
					contd = false;
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				}
			}
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void delStudentCourses() {
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.stu_count == 0) {
			System.out.println("\n   => Student Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<UniversityApp.university.admin.student.length;i++) {
			if (UniversityApp.university.admin.student[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.student[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: "); 
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.student.length) {
			boolean contd = true;
			while (contd) {
				int n = sc[id-1].getCount();
				if (n == 0) {
					System.out.println("\n   => No Student-Course Data to be Deleted!...\n");
					return;
				}
				if (sc[id-1].getNoCourses() > c_count) {
					System.out.println("\n   => Nof. Students' Courses must be at Max the Nof. Courses in the University!...");
					System.out.println("   => Admin Needs to Update the Nof. Courses for This Student!...");
					return;
				}
				System.out.println("\n\tChoose a Student-Course:");
				for (int i=0;i<n;i++) {
					System.out.print("\n\t\t"+(i+1)+". "+sc[id-1].sCourse[i].name);
				}
				System.out.print("\n\tYour Choice: ");
				int code = Integer.parseInt(University.sc.next());
				if (code <= 0 || code > course.length) {
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				} else {
					for (int i=(code-1);i<(n-1);i++) {
						Course temp = sc[id-1].sCourse[i];
						sc[id-1].sCourse[i] = sc[id-1].sCourse[i+1];
						sc[id-1].sCourse[i+1] = temp;
					}
					sc[id-1].sCourse[n-1] = null;
					System.out.println("\n Course Deletion Successful.\n");
					n--;
					sc[id-1].setCount(n);
				}
				System.out.print("\n Q. Do You Want to Delete More Courses? (Y/N - Default) : ");
				char c = University.sc.next().charAt(0);
				c = Character.toUpperCase(c);
				if (c == 'Y') {
					contd = true;
				} else if (c == 'N') {
					contd = false;
				} else {
					contd = false;
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				}
			}
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void delFacultyCourses() {
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.fac_count == 0) {
			System.out.println("\n   => Faculty Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Faculty:");
		for(int i=0;i<UniversityApp.university.admin.faculty.length;i++) {
			if (UniversityApp.university.admin.faculty[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.faculty[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: "); 
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.faculty.length) {
			boolean contd = true;
			while (contd) {
				int n = fc[id-1].getCount();
				if (n == 0) {
					System.out.println("\n   => No Faculty-Course Data to be Deleted!...\n");
					return;
				}
				if (fc[id-1].getNoCourses() > c_count) {
					System.out.println("\n   => Nof. Faculty' Courses must be at Max the Nof. Courses in the University!...");
					System.out.println("   => Admin Needs to Update the Nof. Courses for This Faculty!...");
					return;
				}
				System.out.println("\n\tChoose a Faculty-Course:");
				for (int i=0;i<n;i++) {
					System.out.print("\n\t\t"+(i+1)+". "+fc[id-1].fCourse[i].name);
				}
				System.out.print("\n\tYour Choice: ");
				int code = Integer.parseInt(University.sc.next());
				if (code <= 0 || code > course.length) {
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				} else {
					for (int i=(code-1);i<(n-1);i++) {
						Course temp = fc[id-1].fCourse[i];
						fc[id-1].fCourse[i] = fc[id-1].fCourse[i+1];
						fc[id-1].fCourse[i+1] = temp;
					}
					fc[id-1].fCourse[n-1] = null;
					System.out.println("\n Course Deletion Successful.\n");
					n--;
					fc[id-1].setCount(n);
				}
				System.out.print("\n Q. Do You Want to Delete More Courses? (Y/N - Default) : ");
				char c = University.sc.next().charAt(0);
				c = Character.toUpperCase(c);
				if (c == 'Y') {
					contd = true;
				} else if (c == 'N') {
					contd = false;
				} else {
					contd = false;
					System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
				}
			}
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void displayStudentCourses() {
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.stu_count == 0) {
			System.out.println("\n   => Student Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<UniversityApp.university.admin.student.length;i++) {
			if (UniversityApp.university.admin.student[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.student[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: ");
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.student.length) {
			if (sc[id-1].sCourse[0] == null) {
				System.out.println("\n   => Student Courses are Yet to be Added!...\n");
				return;
			}
			String cat = sc[id-1].display();
			System.out.println(cat);
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void displayFacultyCourses() {
		if (c_count == 0) {
			System.out.println("\n   => Courses for the System have not been Added Yet!...\n");
			return;
		}
		if (AdminApp.fac_count == 0) {
			System.out.println("\n   => Faculty Data Yet to be Added (By the Admin)!...\n");
			return;
		}
		System.out.println("\n\tChoose a Faculty:");
		for(int i=0;i<UniversityApp.university.admin.faculty.length;i++) {
			if (UniversityApp.university.admin.faculty[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.faculty[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: ");
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.faculty.length) {
			if (fc[id-1].fCourse[0] == null) {
				System.out.println("\n   => Faculty Courses are Yet to be Added!...\n");
				return;
			}
			String cat = fc[id-1].display();
			System.out.println(cat);
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public String display() {
		while (true) {
			System.out.print("\nChoose: \n\t1. Add Course Details\n\t2. Display Course Details\n\t3. Add Student-Course Details\n\t4. Add Faculty-Course Details\n\t5. Update Student-Course Details\n\t6. Update Faculty-Course Details\n\t7. Delete Student-Course Details\n\t8. Delete Faculty-Course Details\n\t9. Display Student-Course Details\n\t10.Display Faculty-Course Details\n\t0. Return to University App...\n   => ");
			switch (University.sc.nextInt()) {
				case 1: if (c_count<total_courses) {
							course[c_count] = new Course();
							course[c_count].readData();
							while (true) { 
								if (cCodeUnq.get(course[c_count].code) == null) {
									cCodeUnq.put(course[c_count].code,0);
									break;
								} else {
									System.out.print("\n   => Course Code must be Unique!...\n\t Kindly, Re-Enter the Course Code: ");
									course[c_count].code = University.sc.next(); 
								}
							}							
							while (true) {
								if (cNameUnq.get(course[c_count].name) == null) {
									cNameUnq.put(course[c_count].name,0);
									break;
								} else {
									System.out.print("\n   => Course Name should be Unique!...\n\t Kindly, Re-Enter the Course Name: ");
									course[c_count].name = University.sc.next(); 
								}
							}
							c_count++;
							System.out.println("\n Insertion Successful.\n");
						} else {
							System.out.println("\n   => Maximum Courses Data in the App!...");
						} break;
				case 2: displayCourses(); break;
				case 3: addStudentCourses(); break;
				case 4: addFacultyCourses(); break;
				case 5: editStudentCourses(); break;
				case 6: editFacultyCourses(); break;
				case 7: delStudentCourses(); break;
				case 8: delFacultyCourses(); break;
				case 9: displayStudentCourses(); break;
				case 10: displayFacultyCourses(); break;
				case 0: return null;
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