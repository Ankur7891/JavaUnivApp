package com.iiitk.admin;
import com.iiitk.*;
import com.iiitk.facultyUser.*;
public class Course implements University {
	public String code;
	public String name;
	public int credits;
	public int semester;
	public int nofPeriods = 0;
	public int[] atd; 
	public Period[] per;
	public Marks marks;
	public Course (String code,String name,int cr,int sem) {
		this.code = code;
		this.name = name;
		this.credits = cr;
		this.semester = sem;
		this.marks = new Marks();
	}
	public Course () {
		this.code="";
		this.name="";
		this.credits=0;
		this.semester=0;
	}
	public String display () {
		return "\tCode: "+code+"\t Credits: "+credits+"\tSemester: "+semester+"\tName: "+name+"\n";
	}
	public void readData () {
		System.out.print("\nEnter Course Code: ");
		String code = sc.next();
		System.out.print("Enter Name: ");
		String name = sc.next();
		System.out.print("Enter Credits: ");
		int credits = Integer.parseInt(sc.next());
		System.out.print("Enter Semester: ");
		int sem = Integer.parseInt(sc.next());
		this.code = code;
		this.name = name;
		this.credits = credits;
		this.semester = sem;
		try { 
			Runtime.getRuntime(); 
		} catch (Exception e) {
			System.out.println("\n *-*-*-*-* Execption Caught! *-*-*-*-* \n");
		};
	}
	public String getStudentAtd() {
		var f = new java.text.DecimalFormat("###.##");
		int p = 0;
		for (int i=0;i<nofPeriods;i++) {
			if (atd[i] == 1) { 
				p++;
			}
		}
		double atPc = ((double) p / (double) nofPeriods) * 100;
		return f.format(atPc).toString();
	} 
}