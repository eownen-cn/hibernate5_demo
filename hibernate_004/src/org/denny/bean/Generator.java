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
@Table(name="generator")
public class Generator implements Serializable{
	private static final long serialVersionUID = 1L;
	private String content ;
	private Integer mid ;
	private String title ;
	
	public Generator() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Generator(String title, String content) {
		super();
		this.title = title;
		this.content = content;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Generator other = (Generator) obj;
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
	
	@Id
	@SequenceGenerator(name="gen_name",sequenceName="seq_name")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen_name")
	public Integer getMid() {
		return mid;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
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
		return "Generator [content=" + content + ", mid=" + mid + ", title="
				+ title + "]";
	}
	
	
}
