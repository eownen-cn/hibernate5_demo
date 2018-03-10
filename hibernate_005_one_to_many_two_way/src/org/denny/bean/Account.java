package org.denny.bean;

import java.util.Set;

public class Account implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String countId ;
	private String countName ;
	private Set<Orders> orderSet ;
	public Account() {}
	public Account(String countName) {
		this.countName = countName;
	}
	public final String getCountId() {
		return countId;
	}
	public final void setCountId(String countId) {
		this.countId = countId;
	}
	public final String getCountName() {
		return countName;
	}
	public final void setCountName(String countName) {
		this.countName = countName;
	}
	public final Set<Orders> getOrderSet() {
		return orderSet;
	}
	public final void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}
	
}
