package org.denny.bean;

public class Employee implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String empno ;
	private String ename ;
	
	private Dept dept ;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String ename) {
		this.ename = ename;
	}

	public final String getEmpno() {
		return empno;
	}

	public final void setEmpno(String empno) {
		this.empno = empno;
	}

	public final String getEname() {
		return ename;
	}

	public final void setEname(String ename) {
		this.ename = ename;
	}

	public final Dept getDept() {
		return dept;
	}

	public final void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", dept="
				+ dept + "]";
	}
}
