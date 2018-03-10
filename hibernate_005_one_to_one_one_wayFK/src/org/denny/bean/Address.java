package org.denny.bean;

public class Address implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String dressContent ;
	private String dressId ;
	public Address() { }
	public Address(String dressContent) {
		this.dressContent = dressContent;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (dressContent == null) {
			if (other.dressContent != null)
				return false;
		} else if (!dressContent.equals(other.dressContent))
			return false;
		if (dressId == null) {
			if (other.dressId != null)
				return false;
		} else if (!dressId.equals(other.dressId))
			return false;
		return true;
	}
	public String getDressContent() {
		return dressContent;
	}
	public String getDressId() {
		return dressId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dressContent == null) ? 0 : dressContent.hashCode());
		result = prime * result + ((dressId == null) ? 0 : dressId.hashCode());
		return result;
	}
	public void setDressContent(String dressContent) {
		this.dressContent = dressContent;
	}
	public void setDressId(String dressId) {
		this.dressId = dressId;
	}
	@Override
	public String toString() {
		return "Address [dressContent=" + dressContent + ", dressId=" + dressId
				+ "]";
	}
	
}
