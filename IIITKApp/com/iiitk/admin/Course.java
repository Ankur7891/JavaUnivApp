package com.iiitk.admin;
import com.iiitk.*;
public class Course implements University {
	public String code;
	public String name;
	public int credits;
	public int semester;
	public Course (String code,String name,int cr,int sem) {
		this.code = code;
		this.name = name;
		this.credits = cr;
		this.semester = sem;
	}
	public Course () {
		this.code="";
		this.name="";
		this.credits=0;
		this.semester=0;
	}
	public String display () {
		return "\n Code: "+code+"\tCredits: "+credits+"\tSem: "+credits+"\tName: "+name+"\n";
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
}

