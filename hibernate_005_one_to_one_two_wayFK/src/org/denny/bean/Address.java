package org.denny.bean;

public class Address implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Account account ;
	private String dressContent ;
	private String dressId ;
	public Address() { }
	public Address(String dressContent) {
		this.dressContent = dressContent;
	}
	public Account getAccount() {
		return account;
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
	public void setAccount(Account account) {
		this.account = account;
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
