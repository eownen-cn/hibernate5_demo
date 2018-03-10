package org.denny.bean;

import java.util.Set;

/**
 * 账户
 * @author Ewonen-PC
 *
 */
public class Account implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String countId ;
	private String countName ;
	private Set<Orders> orderSet;
	public Account() {
		super();
	}
	public Account(String countName) {
		super();
		this.countName = countName;
	}
	public String getCountName() {
		return countName;
	}
	public void setCountName(String countName) {
		this.countName = countName;
	}
	public String getCountId() {
		return countId;
	}
	public void setCountId(String countId) {
		this.countId = countId;
	}
	public Set<Orders> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}
	
}
