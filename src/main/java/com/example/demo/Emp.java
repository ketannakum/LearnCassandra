package com.example.demo;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Emp {

	@PrimaryKey
	private int empid;
	private String emp_dept;
	private String emp_first;
	private String emp_last;
	
	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public String getEmp_first() {
		return emp_first;
	}


	public void setEmp_first(String emp_first) {
		this.emp_first = emp_first;
	}


	public String getEmp_last() {
		return emp_last;
	}


	public void setEmp_last(String emp_last) {
		this.emp_last = emp_last;
	}



	public Emp(int empid, String emp_dept, String emp_first, String emp_last) {
		this.empid = empid;
		this.emp_dept = emp_dept;
		this.emp_first = emp_first;
		this.emp_last = emp_last;
	}

	
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", emp_dept=" + emp_dept + ", emp_first=" + emp_first + 
				",emp_last=" + "]";
	}

	public String getEmp_dept() {
		return emp_dept;
	}

	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	
}
