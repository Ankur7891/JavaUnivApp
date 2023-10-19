package com.iiitk.facultyUser;
import com.iiitk.University;
public class Marks {
    public final static int TOTAL = 100;
    public int midSem1 = 0;
    public int midSem2 = 0;
    public int endSem = 0;
    public int tMarks = -1;
    public void readMarks() {
        System.out.println();
        int m = 0;
        System.out.print("\t\t Enter Mid Sem-I Marks: ");
		m = Integer.parseInt(University.sc.next());
        this.midSem1 = m;
        while (!checkMarks()) {
			System.out.print("\n   => Mid Sem-I Marks must Lie in Between 0 and 50 !...\n Kindly, Re-Enter: ");
		    m = Integer.parseInt(University.sc.next());
            this.midSem1 = m;
        }
		System.out.print("\t\t Enter Mid Sem-II Marks: ");
		m = Integer.parseInt(University.sc.next());
        this.midSem2 = m;
        while (!checkMarks()) {
			System.out.print("\n   => Mid Sem-II Marks must Lie in Between 0 and 50 !...\n Kindly, Re-Enter: ");
		    m = Integer.parseInt(University.sc.next());
            this.midSem2 = m;
        }
        System.out.print("\t\t Enter End Sem Marks: ");
		m = Integer.parseInt(University.sc.next());
        this.endSem = m;
        while (!checkMarks()) {
			System.out.print("\n   => End Sem Marks must Lie in Between 0 and 100 !...\n Kindly, Re-Enter: ");
		    m = Integer.parseInt(University.sc.next());
            this.endSem = m;
        }
    }
    public boolean checkMarks() {
        if (midSem1 < 0 || midSem1 > 50) {
            return false;
        }
        if (midSem2 < 0 || midSem2 > 50) {
            return false;
        }        
        if (endSem < 0 || endSem > 100) {
            return false;
        }
        return true;
    }
    public void setTMarks() {
        int marks = (midSem1+midSem2+endSem)/2;
        if (marks > Marks.TOTAL) {
			System.out.println("\n   => Sorry, Unexpected Marks Calculation Error...\n");
            return;
        }
        tMarks = marks;
    }
    public void display () {
		System.out.println("\t\t\t Mid Sem-I: "+midSem1+"\t Mid Sem-II: "+midSem2+"\t  End Sem: "+endSem+"\n\t\t\t -> Overall Marks (Out of 100): "+tMarks+"\n");
	}
}