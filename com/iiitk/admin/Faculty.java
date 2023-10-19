package com.iiitk.admin;
import com.iiitk.*;
public class Faculty extends Person {
	protected String empcode;
	protected String department;
	protected int experience;
	protected int salary;
	protected int no_courses;
	public Faculty () {
		empcode = "";
		department = "";
		experience = 0;
		salary = 0;
		no_courses = 0;
	}
	public Faculty (String name,String dob,String eMail,long  mobile,String empcode,String dept,int exp,int sal,int nc) {
		super(name,dob,eMail,mobile);
		this.empcode = empcode;
		this.department = dept;
		this.experience = exp;
		this.salary = sal;
		this.no_courses = nc;
	}
	public Faculty (String name,String empcode,String dept) {
		this(name,"1-1-1980","",0,empcode,dept,0,0,0);
	}
	public Faculty (Faculty f) {
		this(f.name,f.dob.toString(),f.eMail,f.mobile,f.empcode,f.department,f.experience,f.salary,f.no_courses);
	}
	public String display() {
		return super.display()+"\n Emp Code: "+empcode+"\n Department: "+department+"\n Experience: "+experience+"\n Salary: "+salary;
	}
	public int getNoCourses() {
		return this.no_courses;
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
		System.out.print("Enter Emp. Code: ");
		String emp = University.sc.next();
		System.out.print("Enter Department: ");
		String dept = sc.next();
		System.out.print("Enter Experience: ");
		int exp = Integer.parseInt(sc.next());
		System.out.print("Enter Salary: ");
		int sal = Integer.parseInt(sc.next());
		System.out.print("Enter Nof. Teaching Courses: ");
		int nc = Integer.parseInt(sc.next());
		this.name = name;
		this.setDOB(dob);
		this.eMail = email;
		this.mobile = mobile;
		this.empcode= emp;
		this.department = dept;
		this.experience = exp;
		this.salary = sal;
		this.no_courses = nc;
		try { 
			Runtime.getRuntime(); 
		} catch (Exception e) {
			System.out.println("\n *-*-*-*-* Execption Caught! *-*-*-*-* \n");
		};
	}
	public String editFacultyData() {
		boolean contd = true;
		while (contd) {
			System.out.print("\nChoose Data Field to be Updated: \n\t1. Name\n\t2. DOB\n\t3. Email ID\n\t4. Mobile\n\t5. Emp. Code\n\t6. Department\n\t7. Experience\n\t8. Salary\n\t9. Nof. Teaching Courses\n\t10. Return to Previous Menu...\n   => ");
			switch (University.sc.nextInt()) {
				case 1: System.out.print("Enter New Name: "); this.name = University.sc.next(); break;
				case 2: System.out.print("Enter New DOB: "); this.setDOB(University.sc.next()); break;
				case 3: System.out.print("Enter New Email ID: "); this.eMail = University.sc.next(); break;
				case 4: System.out.print("Enter New Mobile: "); this.mobile = Long.parseLong(University.sc.next()); break;
				case 5: System.out.print("Enter New Emp. Code: "); this.empcode = University.sc.next(); break;
				case 6: System.out.print("Enter New Department: "); this.department = University.sc.next(); break;
				case 7: System.out.print("Enter New Experience: "); this.experience = Integer.parseInt(University.sc.next()); break;
				case 8: System.out.print("Enter New Salary: "); this.salary = Integer.parseInt(University.sc.next()); break;
				case 9: System.out.print("Enter New Nof. Teaching Courses: "); this.no_courses = Integer.parseInt(University.sc.next()); break;
				case 10: return null;
				default: System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
			}
			System.out.print("\n  Do You Want to Update More Data Fields? (Y/N - Default) : ");
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