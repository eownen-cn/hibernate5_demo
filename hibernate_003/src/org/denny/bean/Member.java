package org.denny.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="member")
public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	private String content ;
	private Integer mid ;
	private String title ;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
//	@Id
//	@SequenceGenerator(name = "m_seq", sequenceName = "m_seq",initialValue=1,allocationSize=1)  
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_seq")  
	public Integer getMid() {
		return mid;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", title=" + title + ", content="
				+ content + "]";
	}
}
