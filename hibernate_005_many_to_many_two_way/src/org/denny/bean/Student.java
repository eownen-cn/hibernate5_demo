package org.denny.bean;

import java.util.Set;

public class Student {
	private Integer stuId ;
	private String stuName ;
	
	private Set<Course> courseSet ;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String stuName) {
		this.stuName = stuName;
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Set<Course> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName
				+ ", courseSet=" + courseSet + "]";
	}
	
}
