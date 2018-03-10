package org.denny.bean;

public class Account implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	// 配置关联关系
	private Address address ;
	
	private String countId ;

	private String countName ;

	public Account() {
		super();
	}

	public Account(String countName) {
		this.countName = countName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (countId == null) {
			if (other.countId != null)
				return false;
		} else if (!countId.equals(other.countId))
			return false;
		if (countName == null) {
			if (other.countName != null)
				return false;
		} else if (!countName.equals(other.countName))
			return false;
		return true;
	}

	public final Address getAddress() {
		return address;
	}

	public final String getCountId() {
		return countId;
	}

	public final String getCountName() {
		return countName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((countId == null) ? 0 : countId.hashCode());
		result = prime * result
				+ ((countName == null) ? 0 : countName.hashCode());
		return result;
	}

	public final void setAddress(Address address) {
		this.address = address;
	}

	public final void setCountId(String countId) {
		this.countId = countId;
	}

	public final void setCountName(String countName) {
		this.countName = countName;
	}

	@Override
	public String toString() {
		return "Account [countId=" + countId + ", countName=" + countName
				+ ", address=" + address + "]";
	}
	
	
}
