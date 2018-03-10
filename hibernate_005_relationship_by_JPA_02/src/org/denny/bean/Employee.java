package org.denny.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employee_01")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="seq_GEN",sequenceName="seq_emp_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_GEN")
	private Integer empId ;
	private String empName ;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empName) {
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
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
}
