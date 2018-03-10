package org.denny.bean;

public class IDCard implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String cardId ;
	private String content ;
	private Person person ;
	public IDCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IDCard(String content) {
		super();
		this.content = content;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "IDCard [cardId=" + cardId + ", content=" + content
				+ ", person=" + person + "]";
	}
	
}
