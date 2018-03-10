package org.denny.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="dept_02")
public class Dept2 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="seq_GEN",sequenceName="seq_dept_id",allocationSize=10,initialValue=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_GEN")
	private Integer deptId ;
	private String deptName ;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="dept")
	private Set<Employee2> empSet ;
	public Dept2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept2(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName
				+ ", empSet=" + empSet + "]";
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee2> getEmpSet() {
		return empSet;
	}
	public void setEmpSet(Set<Employee2> empSet) {
		this.empSet = empSet;
	}
	
}
