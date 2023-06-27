package com.iiitk;
import com.iiitk.admin.*;
import com.iiitk.academics.*;
class UniversityApp implements University {
	AdminApp admin = null;
	AcademicsApp acad = null;
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
		System.out.print("\nChoose: \n\t1. Admin User\n\t2. Academics User\n\t0. Exit...\n   => ");
		return sc.nextInt();
	}
	public static void main (String ar[]) {
		UniversityApp university = new UniversityApp();
		while (true) {
			int ch = showUniversityMenu();
			switch (ch) {
				case 1: if (university.admin == null) {
							university.admin = new AdminApp();
						} else {
							university.admin.display();
						} break;
				case 2: if (university.acad == null) {
							university.acad = new AcademicsApp();
						} else {
							university.acad.display();
						} break;
				case 0: System.exit(0);
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