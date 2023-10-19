package com.iiitk.admin;
import com.iiitk.*;
class Person implements University {
	protected String name;
	protected DOB dob;
	protected String eMail;
	protected long mobile;
	Person () {
		this.name = "";
		this.dob = new DOB(01,01,2000);
		this.eMail = "";
		this.mobile = 0;
	}
	Person (String name,String dob,String eMail,long mobile) {
		this.name = name;
		this.dob = new DOB(dob);
		this.eMail = eMail;
		this.mobile = mobile;
	}
	Person (String name) {
		new Person(name,"01-01-2000","",0);
	}
	public String display() {
		return "\n Name: "+name+"\n DOB: "+dob+"\n Email ID: "+eMail+"\n Mobile: "+mobile;
	}
	void setDOB(String d) {
		this.dob = new DOB(d);
	}
	class DOB {
		private int day = 01;
		private int month = 01;
		private int year = 2000;
		DOB (int day,int month,int year) {
			this.day = day; 
			this.month = month;
			this.year = year;
		}
		DOB (String date) {
			if (date.length()>4) {
				String intDate[] = date.split("-");
				new DOB(Integer.parseInt(intDate[0]),Integer.parseInt(intDate[1]),Integer.parseInt(intDate[2]));
			} else {
				new DOB(01,01,2000);
			}
		}
		public String toString() {
			return ""+day+"-"+month+"-"+year+"";
		}
	}
	public String getName() {
		return this.name;
	}
	public String getDOB() {
		return this.dob.toString();
	}
	public String getEmailId() {
		return this.eMail;
	}
	public long getMobile() {
		return this.mobile;
	}
}