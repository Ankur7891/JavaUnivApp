package com.iiitk.studentUser;
import com.iiitk.*;
import com.iiitk.admin.*;
import com.iiitk.academics.*;
public class StudentUser extends Student implements University {
    public StudentUser() {
        System.out.println("\n----------------------------------");
		System.out.println("\n  Dear Student, Welcome to IIITK  ");
		System.out.println("\n----------------------------------");
        display();
    }
    private void showMyAttendence(int id) {
        for (int i=0;i<UniversityApp.university.acad.sc[id-1].getCount();i++) {
            if (UniversityApp.university.acad.sc[id-1].sCourse[i] == null) {
                System.out.println("\n   => Academics Dept Needs to Add Courses here...\n");
                return;
            }
            if (UniversityApp.university.acad.sc[id-1].sCourse[i].nofPeriods == 0) {
                System.out.println("\n   => No Classes Conducted So Far in the Course: "+UniversityApp.university.acad.sc[id-1].sCourse[i].code+" - "+UniversityApp.university.acad.sc[id-1].sCourse[i].name+"...");
                continue;
            } else {
                System.out.println("\n\t"+UniversityApp.university.acad.sc[id-1].sCourse[i].code+" - "+UniversityApp.university.acad.sc[id-1].sCourse[i].name+"\t => "+UniversityApp.university.acad.sc[id-1].sCourse[i].getStudentAtd()+" %");
            }
        }
    }
    private void showMyMarks(int id) {
        for (int i=0;i<UniversityApp.university.acad.sc[id-1].getCount();i++) {
            if (UniversityApp.university.acad.sc[id-1].sCourse[i] == null) {
                System.out.println("\n   => Academics Dept Needs to Add Courses here...\n");
                return;
            }
            if (UniversityApp.university.acad.sc[id-1].sCourse[i].marks.tMarks == -1) {
                System.out.println("\n   => No Marks Registered in the Course: "+UniversityApp.university.acad.sc[id-1].sCourse[i].code+" - "+UniversityApp.university.acad.sc[id-1].sCourse[i].name+"...");
                continue;
            } else {
                System.out.println("\n\t"+UniversityApp.university.acad.sc[id-1].sCourse[i].code+" - "+UniversityApp.university.acad.sc[id-1].sCourse[i].name+": ");
                UniversityApp.university.acad.sc[id-1].sCourse[i].marks.display();
            }
        }
    }
    public String display() {
        if (AdminApp.stu_count == 0) {
			System.out.println("\n   => Student Data Yet to be Added (By the Admin)!...\n");
            return "";
		}
		System.out.println("\n\tChoose an Account:");
		for(int i=0;i<UniversityApp.university.admin.student.length;i++) {
			if (UniversityApp.university.admin.student[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.student[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: "); 
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.student.length) {
            int n = UniversityApp.university.acad.sc[id-1].getCount();
            if (n == 0) {
                System.out.println("\n   => This Student does not have any Courses!...\n");
            }
            if (UniversityApp.university.acad.sc[id-1].getNoCourses() > AcademicsApp.c_count) {
                System.out.println("\n   => Nof. Student' Courses must be at Max the Nof. Courses in the University!...");
                System.out.println("   => Admin Needs to Update the Nof. Courses for This Student!...");
            }
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
		}
		while (true) {
			System.out.print("\nChoose: \n\t1. Show Attendence for All Subjects\n\t2. Show Marks for All Subjects\n\t0. Return to University App...\n   => ");
			switch(University.sc.nextInt()) {
				case 1: showMyAttendence(id); break;
				case 2: showMyMarks(id); break;
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