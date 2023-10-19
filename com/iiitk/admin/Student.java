package com.iiitk.admin;
import com.iiitk.*;
public class Student extends Person {
	protected String rollNo;
	protected String branch;
	protected int semester;
	protected int no_courses; 
	protected float cgpa; 
	public Student() {
		rollNo = "";
		branch = "";
		semester = 0;
		no_courses = 0;
		cgpa = 0;
	}
	public Student (String name,String dob,String eMail,long mobile,String rollNo,String branch,int sem,int nc,float cgpa) {
		super(name,dob,eMail,mobile);
		this.rollNo = rollNo;
		this.branch = branch;
		this.semester = sem;
		this.no_courses = nc;
		this.cgpa = cgpa;
	}
	public Student (String name,String rollNo,String branch) {
		this(name,"01-01-2000","",0,rollNo,branch,1,0,0.0f);
	}
	public Student(Student s) {
		this(s.name,s.dob.toString(),s.eMail,s.mobile,s.rollNo,s.branch,s.semester,s.no_courses,s.cgpa);
	}
	public String getRollNo() {
		return this.rollNo;
	}
	public int getNoCourses() {
		return this.no_courses;
	}
	public String display() {
		return super.display()+"\n Roll No."+rollNo+"\n Branch: "+branch+"\n Semester: "+semester+"\n Nof. Courses: "+no_courses+"\n CGPA: "+cgpa;
	}
	public void readData() {
		System.out.print("\nEnter Name: "); 
		String name = sc.next();
		System.out.print("Enter DOB: "); 
		String dob = sc.next();
		System.out.print("Enter Email ID: ");
		String email = sc.next();
		System.out.print("Enter Mobile: ");
		long mobile = Long.parseLong(sc.next());
		System.out.print("Enter Roll No: ");
		String roll = sc.next();
		System.out.print("Enter Branch: ");
		String branch = sc.next();
		System.out.print("Enter Semester: ");
		int sem = Integer.parseInt(sc.next());
		System.out.print("Enter Nof. Courses: ");
		int nCou = Integer.parseInt(sc.next());
		System.out.print("Enter CGPA: ");
		float cgpa = Float.parseFloat(sc.next());
		this.name = name;
		this.setDOB(dob);
		this.eMail = email;
		this.mobile = mobile;
		this.rollNo= roll;
		this.branch = branch;
		this.semester = sem;
		this.no_courses = nCou;
		this.cgpa = cgpa;
		try { 
			Runtime.getRuntime(); 
		} catch (Exception e) {
			System.out.println("\n *-*-*-*-* Execption Caught! *-*-*-*-* \n");
		};
	}
	public String editStudentData() {
		boolean contd = true;
		while (contd) {
			System.out.print("\nChoose Data Field to be Updated: \n\t1. Name\n\t2. DOB\n\t3. Email ID\n\t4. Mobile\n\t5. Roll Number\n\t6. Branch\n\t7. Semester\n\t8. Nof. Courses\n\t9. CGPA\n\t10. Return to Previous Menu...\n   => ");
			switch (University.sc.nextInt()) {
				case 1: System.out.print("Enter New Name: "); this.name = University.sc.next(); break;
				case 2: System.out.print("Enter New DOB: "); this.setDOB(University.sc.next()); break;
				case 3: System.out.print("Enter New Email ID: "); this.eMail = University.sc.next(); break;
				case 4: System.out.print("Enter New Mobile: "); this.mobile = Long.parseLong(University.sc.next()); break;
				case 5: System.out.print("Enter New Roll Number: "); this.rollNo = University.sc.next(); break;
				case 6: System.out.print("Enter New Branch: "); this.branch = University.sc.next(); break;
				case 7: System.out.print("Enter New Semester: "); this.semester = Integer.parseInt(University.sc.next()); break;
				case 8: System.out.print("Enter New Nof. Courses: "); this.no_courses = Integer.parseInt(University.sc.next()); break;
				case 9: System.out.print("Enter New CGPA: "); this.cgpa = Float.parseFloat(University.sc.next()); break;
				case 10: return null;
				default: System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
			}
			System.out.print("\n Q. Do You Want to Update More Data Fields? (Y/N - Default) : ");
			char c = sc.next().charAt(0);
			c = Character.toUpperCase(c);
			if (c == 'Y') {
				contd = true;
			} else if (c == 'N') {
				contd = false;
			} else {
				contd = false;
				System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
			}
			try { 
				Runtime.getRuntime(); 
			} catch (Exception e) {
				System.out.println("\n *-*-*-*-* Execption Caught! *-*-*-*-* \n");
			};
		}
		return null;
	}
}