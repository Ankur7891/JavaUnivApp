package com.iiitk.admin;
import com.iiitk.*;
import java.util.HashMap;
public class AdminApp implements University {
	private static HashMap<String,Integer> rnUnq = new HashMap<String,Integer>();
	private static HashMap<String,Integer> ecUnq = new HashMap<String,Integer>();
	public static int total_students, stu_count;
	public static int total_faculty, fac_count;
	public Student student[];
	public Faculty faculty[];
	public AdminApp() {
		student = new Student[total_students];
		faculty = new Faculty[total_faculty];
	};
	public AdminApp(String garbage) {
		System.out.println("\n----------------------------------");
		System.out.println("\n  Welcome to Admin Dept of IIITK  ");
		System.out.println("\n----------------------------------");
		System.out.print("\nEnter Nof. Students: ");
		total_students = sc.nextInt();
		while (total_students <= 0) {
			System.out.println("\n   => Nof. Students Must be More than 0!...");
			System.out.print("\nRe-Enter Nof. Students: ");
			total_students = sc.nextInt();
		}
		System.out.print("\nEnter Nof. Faculty: "); 
		total_faculty = sc.nextInt();		
		while (total_faculty <= 0) {
			System.out.println("\n   => Nof. Faculty Must be More than 0!..."); 
			System.out.print("\nRe-Enter Nof. Faculty: "); 
			total_faculty = sc.nextInt();
		}
		student = new Student[total_students];
		faculty = new Faculty[total_faculty];
		stu_count = 0;
		fac_count = 0;
		display();
	}
	public void displayStudents() {
		for(int i=0;i<stu_count;i++) {
			if (student[i] != null) {
				student[i].display();
			}
		}
	}
	public void editStudentList() {
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<stu_count;i++) {
			System.out.print("\n\t\t"+(i+1)+". "+student[i].getName());
		}
		System.out.print("\n\tYour Choice: "); 
		int id = sc.nextInt();
		if (id > 0 && id <= stu_count) {
			String x = student[id-1].rollNo;
			student[id-1].editStudentData();							
			while (!x.equals(student[id-1].rollNo)) {
				if (rnUnq.get(student[id-1].rollNo) == null) {
					rnUnq.put(student[id-1].rollNo,1);
					break;
				} else {
					System.out.print("\n   => Roll No. must be Unique for Each Student!...\n\t Kindly, Re-Enter the Roll No: ");
					student[id-1].rollNo = University.sc.next(); 
				}
			}
			System.out.println("\n Data Updation Successful.\n");
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void editFacultyList() {
		System.out.println("\n\tChoose a Faculty:");
		for(int i=0;i<fac_count;i++) {
			System.out.print("\n\t\t"+(i+1)+". "+faculty[i].getName());
		}
		System.out.print("\n\tYour Choice: "); 
		int id = sc.nextInt();
		if (id > 0 && id <= fac_count) {
			String x = faculty[id-1].empcode;
			faculty[id-1].editFacultyData();							
			while (!x.equals(faculty[id-1].empcode)) {
				if (ecUnq.get(faculty[id-1].empcode) == null) {
					ecUnq.put(faculty[id-1].empcode,1);
					break;
				} else {
					System.out.print("\n   => Emp. Code must be Unique for Each Faculty!...\n\t Kindly, Re-Enter the Emp. Code: ");
					faculty[id-1].empcode = University.sc.next(); 
				}
			}
			System.out.println("\n Data Updation Successful.\n");
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
	}
	public void delStudent() {
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<stu_count;i++) {
			System.out.print("\n\t\t"+(i+1)+". "+student[i].getName());
		}
		System.out.print("\n\tYour Choice: "); 
		int id = sc.nextInt();
		if (!(id > 0 && id <= stu_count)) {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
			return;
		}
		for (int i=(id-1);i<(stu_count-1);i++) {
			Student temp = student[i];
			student[i] = student[i+1];
			student[i+1] = temp;
		}
		student[stu_count-1] = null;
		System.out.println("\n Deletion Successful.\n");
		stu_count--;
	}	
	public void delFaculty() {
		System.out.println("\n\tChoose a Faculty:");
		for(int i=0;i<fac_count;i++) {
			System.out.print("\n\t\t"+(i+1)+". "+faculty[i].getName());
		}
		System.out.print("\n\tYour Choice: "); 
		int id = sc.nextInt();
		if (!(id > 0 && id <= fac_count)) {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
			return;
		}
		for (int i=(id-1);i<(fac_count-1);i++) {
			Faculty temp = faculty[i];
			faculty[i] = faculty[i+1];
			faculty[i+1] = temp;
		}
		faculty[fac_count-1] = null;
		System.out.println("\n Deletion Successful.\n");
		fac_count--;
	}
	public void showStudentList() {
		System.out.println("\n\tChoose a Student:");
		for(int i=0;i<stu_count;i++) {
			System.out.print("\n\t\t"+(i+1)+". "+student[i].getName());
		}
		System.out.print("\n\tYour Choice: "); 
		int id = sc.nextInt();
		System.out.println(student[id-1].display());
	}
	public void showFacultyList() {
		System.out.println("\n\tChoose a Faculty:");
		for(int i=0;i<fac_count;i++) {
			System.out.print("\n\t\t"+(i+1)+". "+faculty[i].getName());
		}
		System.out.print("\n\tYour Choice: "); 
		int id = sc.nextInt();
		System.out.println(faculty[id-1].display());
	}
	public String display() {
		while (true) {
			System.out.print("\nChoose: \n\t1. Add Student Details\n\t2. Add Faculty Details\n\t3. Update Student Details\n\t4. Update Faculty Details\n\t5. Delete Student Details\n\t6. Delete Faculty Details\n\t7. Display Student Details\n\t8. Display Faculty Details\n\t0. Return to University App...\n   => ");
			switch(University.sc.nextInt()) {
				case 1: if (stu_count<total_students) {
							student[stu_count] = new Student();
							student[stu_count].readData();
							while (true) {
								if (rnUnq.get(student[stu_count].rollNo) == null) {
									rnUnq.put(student[stu_count].rollNo,1);
									break;
								} else {
									System.out.print("\n   => Roll No. must be Unique for Each Student!...\n\t Kindly, Re-Enter the Roll No: ");
									student[stu_count].rollNo = University.sc.next(); 
								}
							}
							stu_count++;
							System.out.println("\n Insertion Successful.\n");
						} else { 
							System.out.println("\n   => Maximum Student Data in the App!..."); 
						} break;
				case 2: if (fac_count<total_faculty) {
							faculty[fac_count] = new Faculty(); 
							faculty[fac_count].readData();
							while (true) {
								if (ecUnq.get(faculty[fac_count].empcode) == null) {
									ecUnq.put(faculty[fac_count].empcode,1);
									break;
								} else {
									System.out.print("\n   => Emp. Code must be Unique for Each Faculty!...\n\t Kindly, Re-Enter the Emp. Code: ");
									faculty[fac_count].empcode = University.sc.next(); 
								}
							}
							fac_count++;
							System.out.println("\n Insertion Successful.\n");
						} else {
							System.out.println("\n   => Maximum Faculty Data in the App!...");
						} break;
				case 3: if (student[0] == null) {
							System.out.println("\n   => No Student Data to be Updated!...\n");
						} else {
							editStudentList();
						} break;
				case 4: if (faculty[0] == null) {
							System.out.println("\n   => No Faculty Data to be Updated!...\n");
						} else {
							editFacultyList();
						} break;
				case 5: if (student[0] == null) {
							System.out.println("\n   => No Student Data to be Deleted!...\n");
						} else {
							delStudent();
						} break;
				case 6: if (faculty[0] == null) {
							System.out.println("\n   => No Faculty Data to be Deleted!...\n");
						} else {
							delFaculty();
						} break;
				case 7: if (student[0] == null) {
							System.out.println("\n   => No Student Data to be Displayed!...\n");
						} else {
							showStudentList();
						} break;
				case 8: if (faculty[0] == null) {
							System.out.println("\n   => No Faculty Data to be Displayed!...\n");
						} else {
							showFacultyList();
						} break;
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