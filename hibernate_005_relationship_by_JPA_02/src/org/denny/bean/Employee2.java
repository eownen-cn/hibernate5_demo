package org.denny.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee_02")
public class Employee2 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="seq_GEN",sequenceName="seq_emp_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_GEN")
	private Integer empId ;
	private String empName ;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="dept_no")
	private Dept2 dept ;
	public final Dept2 getDept() {
		return dept;
	}
	public final void setDept(Dept2 dept) {
		this.dept = dept;
	}
	public Employee2() {
		super();
	}
	public Employee2(String empName) {
		super();
		this.empName = empName;
	}
	public final Integer getEmpId() {
		return empId;
	}
	public final void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public final String getEmpName() {
		return empName;
	}
	public final void setEmpName(String empName) {
		this.empName = empName;
	}
	@Override
	public String toString() {
		return "Employee2 [empId=" + empId + ", empName=" + empName + "]";
	}
	
}
