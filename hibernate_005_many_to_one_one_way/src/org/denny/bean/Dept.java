package org.denny.bean;

public class Dept implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String deptno ;
	private String deptName ;
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(String deptName) {
		this.deptName = deptName;
	}
	public final String getDeptno() {
		return deptno;
	}
	public final void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public final String getDeptName() {
		return deptName;
	}
	public final void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", deptName=" + deptName + "]";
	}
	
}
