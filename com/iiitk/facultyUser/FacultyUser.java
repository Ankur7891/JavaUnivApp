package com.iiitk.facultyUser;
import com.iiitk.*;
import com.iiitk.admin.*;
import com.iiitk.academics.*;
public class FacultyUser extends Faculty implements University {
    public static int nPeriods;
    int pCount = 0;
    public FacultyUser() {
        System.out.println("\n----------------------------------");
		System.out.println("\n  Dear Faculty, Welcome to IIITK  ");
		System.out.println("\n----------------------------------");	
        System.out.print("\nEnter Total Nof. Classes for Each Course in the Academic Calendar: ");
        nPeriods = University.sc.nextInt();	
        for (int i=0;i<UniversityApp.university.acad.fc.length;i++) {
            for (int j=0;j<UniversityApp.university.acad.fc[i].fCourse.length;j++) {
                if (UniversityApp.university.acad.fc[i].fCourse[j] != null) {
                    UniversityApp.university.acad.fc[i].fCourse[j].per = new Period[FacultyUser.nPeriods]; 
                }
            }
        }
        for (int i=0;i<UniversityApp.university.acad.sc.length;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    UniversityApp.university.acad.sc[i].sCourse[j].per = new Period[FacultyUser.nPeriods]; 
                    UniversityApp.university.acad.sc[i].sCourse[j].atd = new int[FacultyUser.nPeriods]; 
                }
            }
        }
        display();
    }
    public String display() {
        if (AdminApp.fac_count == 0) {
			System.out.println("\n   => Faculty Data Yet to be Added (By the Admin)!...\n");
			return "";
		}
		System.out.println("\n\tChoose an Account:");
		for(int i=0;i<UniversityApp.university.admin.faculty.length;i++) {
			if (UniversityApp.university.admin.faculty[i] != null) {
				System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.admin.faculty[i].getName());
			}
		}
		System.out.print("\n\tYour Choice: "); 
		int id = Integer.parseInt(University.sc.next());
		if (id >= 1 && id <= UniversityApp.university.admin.faculty.length) {
            int n = UniversityApp.university.acad.fc[id-1].getCount();
            if (n == 0) {
                System.out.println("\n   => This Faculty does not have any Courses!...\n");
                return "";
            }
            if (UniversityApp.university.acad.fc[id-1].getNoCourses() > AcademicsApp.c_count) {
                System.out.println("\n   => Nof. Faculty' Courses must be at Max the Nof. Courses in the University!...");
                System.out.println("   => Admin Needs to Update the Nof. Courses for This Faculty!...");
                return "";
            }
		} else {
			System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return "";
		}
		while (true) {
			System.out.print("\nChoose: \n\t1. Add Attendence\n\t2. Update Attendence\n\t3. Delete Attendence\n\t4. Show Attendence\n\t5. Add Marks\n\t6. Update Marks\n\t7. Delete Marks\n\t8. Show Marks\n\t0. Return to University App...\n   => ");
			switch(University.sc.nextInt()) {
				case 1: addAttendence(id); break;
				case 2: editAttendence(id); break;
                case 3: delAttendence(id); break;
                case 4: showAttendence(id); break;
                case 5: addMarks(id); break;
                case 6: editMarks(id); break;
                case 7: delMarks(id); break;
                case 8: showMarks(id); break;
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
    public void addAttendence(int id) {	
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        if (UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods == nPeriods) {
            System.out.println("\n   => Course Already Reached Max Nof. Classes / Periods !...\n");
            return;
        }
        String fcStr = UniversityApp.university.acad.fc[id-1].fCourse[code-1].name;            
        int c = UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods;
        boolean anyS = false; int sCount = 0; int spCount = 0;
        System.out.println("\n\tEnter Attendence ('P'/'A' - Default): ");
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name)) {
                        anyS = true; sCount++;
                        System.out.print("\n\t\t"+UniversityApp.university.admin.student[i].getRollNo()+" - "+UniversityApp.university.admin.student[i].getName()+"\t -> ");
                        char att = Character.toUpperCase(University.sc.next().charAt(0)); 
                        UniversityApp.university.acad.sc[i].sCourse[j].nofPeriods++;
                        UniversityApp.university.acad.sc[i].sCourse[j].atd[c] = 0;
                        if (att == 'P') {
                            UniversityApp.university.acad.sc[i].sCourse[j].atd[c] = 1;
                            spCount++;
                        }
                    }
                }
            }
        }
        if (anyS == false) {
            System.out.println("\n   => Oops! Looks Like No Student is Registered for this Course...\n");
            return;
        }
        UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[c] = new Period(sCount,spCount);
        UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods++;
		System.out.println("\n Attendence Addition Successful.\n");
    }
    public void editAttendence(int id) {        
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        if (UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods == 0) {
            System.out.println("\n   => No Attendence Data to be Edited / Updated !...\n");
            return;
        }
        System.out.println("\n\tChoose the Period:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods;i++) {
            if (UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i] == null) {
                break;
            }
            System.out.print("\n\t\tPeriod - "+(i+1)+" = "+UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i].present+"/"+UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i].total);
        }
        System.out.print("\n\tYour Choice: ");
        int pVal = Integer.parseInt(University.sc.next());
        if (pVal <= 0 || pVal > UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        String fcStr = UniversityApp.university.acad.fc[id-1].fCourse[code-1].name;
        int sCount = 0; int spCount = 0;
        System.out.println("\n\tEnter New Attendence ('P'/'A' - Default): ");
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name)) {
                        sCount++;
                        System.out.print("\n\t\t"+UniversityApp.university.admin.student[i].getRollNo()+" - "+UniversityApp.university.admin.student[i].getName()+"\t -> ");
                        char att = Character.toUpperCase(University.sc.next().charAt(0));
                        UniversityApp.university.acad.sc[i].sCourse[j].nofPeriods++;
                        UniversityApp.university.acad.sc[i].sCourse[j].atd[pVal-1] = 0;
                        if (att == 'P') {
                            UniversityApp.university.acad.sc[i].sCourse[j].atd[pVal-1] = 1;
                            spCount++;
                        }
                    }
                }
            }
        }
        UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[pVal-1].total = sCount;
        UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[pVal-1].present = spCount;
		System.out.println("\n Attendence Updation Successful.\n");
    }
    public void delAttendence(int id) {
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        if (UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods == 0) {
            System.out.println("\n   => No Attendence Data to be Deleted !...\n");
            return;
        }
        System.out.println("\n\tChoose the Period:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods;i++) {
            if (UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i] == null) {
                break;
            }
            System.out.print("\n\t\tPeriod - "+(i+1)+" = "+UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i].present+"/"+UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i].total);
        }
        System.out.print("\n\tYour Choice: ");
        int pVal = Integer.parseInt(University.sc.next());
        if (pVal <= 0 || pVal > UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        String fcStr = UniversityApp.university.acad.fc[id-1].fCourse[code-1].name;
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name)) {
                        for (int k=(pVal-1);k<UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods-1;k++) {
                            int temp = UniversityApp.university.acad.sc[i].sCourse[j].atd[k];
                            UniversityApp.university.acad.sc[i].sCourse[j].atd[k] = UniversityApp.university.acad.sc[i].sCourse[j].atd[k+1];
                            UniversityApp.university.acad.sc[i].sCourse[j].atd[k+1] = temp;
                        }
                        UniversityApp.university.acad.sc[i].sCourse[j].atd[UniversityApp.university.acad.sc[i].sCourse[j].nofPeriods-1] = -1;
                        UniversityApp.university.acad.sc[i].sCourse[j].nofPeriods--;
                    }
                }
            }
        }
        for (int k=(pVal-1);k<UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods-1;k++) {
            var temp = UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[k];
            UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[k] = UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[k+1];
            UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[k+1] = temp;
        }
        UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods-1] = null;
        UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods--;
		System.out.println("\n Attendence Deletion Successful.\n");
    }
    public void showAttendence(int id) {
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        if (UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods == 0) {
            System.out.println("\n   => No Attendence Data to be Displayed !...\n");
            return;
        }
        System.out.println("\n\tAttendence as per the Periods: ");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].fCourse[code-1].nofPeriods;i++) {
            if (UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i] == null) {
                break;
            }
            System.out.println("\n\t\tPeriod - "+(i+1)+" = "+UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i].present+"/"+UniversityApp.university.acad.fc[id-1].fCourse[code-1].per[i].total);
        }
    }
    public void addMarks(int id) {
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        String fcStr = UniversityApp.university.acad.fc[id-1].fCourse[code-1].name;            
        boolean anyS = false;
        System.out.println("\n\tEnter Marks for Various Exams of the Students:");
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name)) {
                        anyS = true;
                        System.out.println("\t\t"+UniversityApp.university.admin.student[i].getRollNo()+" - "+UniversityApp.university.admin.student[i].getName());
                        if (UniversityApp.university.acad.sc[i].sCourse[j].marks.tMarks != -1) {
                            System.out.println("\n   => Student's Marks are Already Entered!...\n"); return;
                        }
                        UniversityApp.university.acad.sc[i].sCourse[j].marks.readMarks();
                        UniversityApp.university.acad.sc[i].sCourse[j].marks.setTMarks();
                        System.out.println();
                    }
                }
            }
        }
        if (anyS == false) {
            System.out.println("\n   => Oops! Looks Like No Student is Registered for this Course...\n");
            return;
        }
		System.out.println("\n Marks Added Successfully.\n");
    }
    public void editMarks(int id) {
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        String fcStr = UniversityApp.university.acad.fc[id-1].fCourse[code-1].name;            
        boolean anyS = false;
        System.out.println("\n\tChoose a Student:");
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name)) {
                        anyS = true;
                        System.out.println("\t\t"+UniversityApp.university.admin.student[i].getRollNo()+" - "+UniversityApp.university.admin.student[i].getName());
                    }
                }
            }
        }
        if (anyS == false) {
            System.out.println("\n   => Oops! Looks Like No Student is Registered for this Course...\n");
            return;
        }
        System.out.print("\t\tEnter Roll No. ");
        String rn = University.sc.next();
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name) && rn.equals(UniversityApp.university.admin.student[i].getRollNo())) {
                        if (UniversityApp.university.acad.sc[i].sCourse[j].marks.tMarks == -1) {
                            System.out.println("\n   => No Data for Marks of this Student to be Updated!...\n"); return;
                        }
                        System.out.print("\n\tChoose Exam: \n\t\t1. Mid Sem-I\n\t\t2. Mid Sem-II\n\t\t3. End Sem\n\t\t   => "); 
                        int ch = University.sc.nextInt();
                        switch(ch) {
                            case 1: {
                                int m = 0;
                                System.out.print("\n\t\t Enter Mid Sem-I Marks: ");
                                m = Integer.parseInt(University.sc.next());
                                UniversityApp.university.acad.sc[i].sCourse[j].marks.midSem1 = m;
                                while (!UniversityApp.university.acad.sc[i].sCourse[j].marks.checkMarks()) {
                                    System.out.print("\n   => Mid Sem-I Marks must Lie in Between 0 and 50 !...\n Kindly, Re-Enter: ");
                                    m = Integer.parseInt(University.sc.next());
                                    UniversityApp.university.acad.sc[i].sCourse[j].marks.midSem1 = m;
                                }
                                UniversityApp.university.acad.sc[i].sCourse[j].marks.setTMarks();
                            } break;
                            case 2: {
                                int m = 0;
                                System.out.print("\n\t\t Enter Mid Sem-II Marks: ");
                                m = Integer.parseInt(University.sc.next());
                                UniversityApp.university.acad.sc[i].sCourse[j].marks.midSem2 = m;
                                while (!UniversityApp.university.acad.sc[i].sCourse[j].marks.checkMarks()) {
                                    System.out.print("\n   => Mid Sem-II Marks must Lie in Between 0 and 50 !...\n Kindly, Re-Enter: ");
                                    m = Integer.parseInt(University.sc.next());
                                    UniversityApp.university.acad.sc[i].sCourse[j].marks.midSem2 = m;
                                }
                                UniversityApp.university.acad.sc[i].sCourse[j].marks.setTMarks();
                            } break;
                            case 3: {
                                int m = 0;
                                System.out.print("\n\t\t Enter End Sem Marks: ");
                                m = Integer.parseInt(University.sc.next());
                                UniversityApp.university.acad.sc[i].sCourse[j].marks.endSem = m;
                                while (!UniversityApp.university.acad.sc[i].sCourse[j].marks.checkMarks()) {
			                        System.out.print("\n   => End Sem Marks must Lie in Between 0 and 100 !...\n Kindly, Re-Enter: ");
                                    m = Integer.parseInt(University.sc.next());
                                    UniversityApp.university.acad.sc[i].sCourse[j].marks.endSem = m;
                                }
                                UniversityApp.university.acad.sc[i].sCourse[j].marks.setTMarks();
                            } break;
                            default: System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n"); return;
                        }
                    }
                }
            }
        }
		System.out.println("\n Marks Updated Successfully.\n");
    }
    public void delMarks(int id) {
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        String fcStr = UniversityApp.university.acad.fc[id-1].fCourse[code-1].name;            
        boolean anyS = false;
        System.out.println("\n\tChoose a Student:");
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name)) {
                        anyS = true;
                        System.out.println("\t\t"+UniversityApp.university.admin.student[i].getRollNo()+" - "+UniversityApp.university.admin.student[i].getName());
                    }
                }
            }
        }
        if (anyS == false) {
            System.out.println("\n   => Oops! Looks Like No Student is Registered for this Course...\n");
            return;
        }
        System.out.print("\t\tEnter Roll No. ");
        String rn = University.sc.next();
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name) && rn.equals(UniversityApp.university.admin.student[i].getRollNo())) {
                        if (UniversityApp.university.acad.sc[i].sCourse[j].marks.tMarks == -1) {
                            System.out.println("\n   => No Data for Marks of this Student to be Deleted!...\n"); return;
                        }
                        UniversityApp.university.acad.sc[i].sCourse[j].marks.tMarks = -1;
                    }
                }
            }
        }
		System.out.println("\n Marks Deleted Successfully.\n");
    }
    public void showMarks(int id) {
        System.out.println("\n\tChoose a Course / Subject:");
        for (int i=0;i<UniversityApp.university.acad.fc[id-1].getCount();i++) {
            System.out.print("\n\t\t"+(i+1)+". "+UniversityApp.university.acad.fc[id-1].fCourse[i].name);
        }
        System.out.print("\n\tYour Choice: ");
        int code = Integer.parseInt(University.sc.next());
        if (code <= 0 || code > UniversityApp.university.acad.fc[id-1].getCount()) {
            System.out.println("\n\t#-#-# Invalid Choice Entered! #-#-#\n");
            return;
        }
        String fcStr = UniversityApp.university.acad.fc[id-1].fCourse[code-1].name;            
        boolean anyS = false;
        for (int i=0;i<AdminApp.stu_count;i++) {
            for (int j=0;j<UniversityApp.university.acad.sc[i].sCourse.length;j++) {
                if (UniversityApp.university.acad.sc[i].sCourse[j] != null) {
                    if (fcStr.equals(UniversityApp.university.acad.sc[i].sCourse[j].name)) {
                        anyS = true;
                        System.out.println("\t\t"+UniversityApp.university.admin.student[i].getRollNo()+" - "+UniversityApp.university.admin.student[i].getName());
                        if (UniversityApp.university.acad.sc[i].sCourse[j].marks.tMarks == -1) {
                            System.out.println("\n   => No Data for Marks of this Student to be Displayed!...\n"); continue;
                        }
                        UniversityApp.university.acad.sc[i].sCourse[j].marks.display();
                    }
                }
            }
        }
        if (anyS == false) {
            System.out.println("\n   => Oops! Looks Like No Student is Registered for this Course...\n");
            return;
        }
    }
}