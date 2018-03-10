package org.denny.bean;

public class Person implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String pid ;
	private String pname ;
	private IDCard cardId ;
	public IDCard getCardId() {
		return cardId;
	}
	public void setCardId(IDCard cardId) {
		this.cardId = cardId;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String pname) {
		super();
		this.pname = pname;
	}
	public String getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + "]";
	}
	
	
}
