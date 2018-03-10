package org.denny.bean;

import java.util.Set;

public class Course {
	private Integer courseId ;
	private String courseName ;
	private Integer courseScore ;
	private Set<Student> StudentSet ;
	public Set<Student> getStudentSet() {
		return StudentSet;
	}
	public void setStudentSet(Set<Student> studentSet) {
		StudentSet = studentSet;
	}
	public Course() {
		super();
	}
	public Course(String courseName,Integer courseScore) {
		super();
		this.courseName = courseName;
		this.courseScore = courseScore ;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCourseScore() {
		return courseScore;
	}
	public void setCourseScore(Integer courseScore) {
		this.courseScore = courseScore;
	}
	
	
}
