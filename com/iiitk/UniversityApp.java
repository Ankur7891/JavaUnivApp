package com.iiitk;
import com.iiitk.admin.*;
import com.iiitk.academics.*;
import com.iiitk.facultyUser.*;
import com.iiitk.studentUser.*;
public class UniversityApp implements University {
	public AdminApp admin = null;
	public AcademicsApp acad = null;
	public FacultyUser facUser = null;
	public StudentUser stuUser = null;
	UniversityApp() {
		System.out.println("\n############################");
		System.out.println("\n  WELCOME TO IIIT-KOTTAYAM  ");
		System.out.println("\n############################");
	}
	public String display() {
		String ret = "\n############################";
		ret+="\n  WELCOME TO IIIT-KOTTAYAM  ";
		ret+="\n############################";
		return ret;
	} 
	static int showUniversityMenu() {
		System.out.print("\nChoose: \n\t1. Admin User\n\t2. Academics User\n\t3. Faculty User\n\t4. Student User\n\t0. Exit...\n   => ");
		return University.sc.nextInt();
	}
	public static UniversityApp university = null;
	public static void main (String[] args) {
		university = new UniversityApp();
		while (true) {
			int ch = showUniversityMenu();
			switch (ch) {
				case 1: if (university.admin == null) {
							university.admin = new AdminApp(" ");
						} else {
							university.admin.display();
						} break;
				case 2: {		
					if (university.admin == null) {
						System.out.println("\n   => Admin Dept Needs to Add Necessary Data For Academics Dept Portal to Function!...\n");
						break;
					}
					if (university.acad == null) {
						university.acad = new AcademicsApp();
					} else {
						university.acad.display();
					}
				} break;
				case 3: {		
					if (university.admin == null || university.acad == null) {
						System.out.println("\n   => Admin and Academics Dept Need to Add Necessary Data For Faculty User Portal to Function!...\n");
						break;
					}
					if (university.facUser == null) {
						university.facUser = new FacultyUser();
					} else {
						university.facUser.display();
					}
				} break;
				case 4: {		
					if (university.admin == null || university.acad == null || university.facUser == null) {
						System.out.println("\n   => Admin, Academics and Faculty Dept Need to Add Necessary Data For Faculty User Portal to Function!...\n");
						break;
					}
					if (university.stuUser == null) {
						university.stuUser = new StudentUser();
					} else {
						university.stuUser.display();
					}
				} break;
				case 0: {
					System.out.print("\n###############################");
					System.out.print("\n . Thanks For Using the App! . ");
					System.out.print("\n###############################");
					System.out.println("\n");
					System.exit(0);
				} break;
				default: System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
			}
			try { 
			} catch (Exception e) {
				System.out.println("\n *-*-*-*-* Execption Caught! *-*-*-*-* \n");
			};
		}
	}
}