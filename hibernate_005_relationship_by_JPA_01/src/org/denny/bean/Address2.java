package org.denny.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="address2")
public class Address2 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_GEN")
	@SequenceGenerator(name="seq_GEN",sequenceName="dress_seq",initialValue=1,allocationSize=2)
	private Integer dressId ;
	private String dressContent ;
	@OneToOne(mappedBy="address")
	private Account2 account ;
	public final Account2 getAccount() {
		return account;
	}
	public final void setAccount(Account2 account) {
		this.account = account;
	}
	public Address2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address2(String dressContent) {
		this.dressContent = dressContent;
	}
	public Integer getDressId() {
		return dressId;
	}
	public void setDressId(Integer dressId) {
		this.dressId = dressId;
	}
	public String getDressContent() {
		return dressContent;
	}
	public void setDressContent(String dressContent) {
		this.dressContent = dressContent;
	}
	
}
