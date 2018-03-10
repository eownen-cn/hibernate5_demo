package org.denny.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="account2")
public class Account2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_GEN")
	@SequenceGenerator(name="seq_GEN",sequenceName="count_seq",initialValue=1,allocationSize=2)
	private Integer countId ;
	private String countName ;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="dress_id")
	private Address2 address ;
	public Account2() {
		super();
	}
	public Account2(String countName) {
		this.countName = countName;
	}
	public final Integer getCountId() {
		return countId;
	}
	public final void setCountId(Integer countId) {
		this.countId = countId;
	}
	public final String getCountName() {
		return countName;
	}
	public final void setCountName(String countName) {
		this.countName = countName;
	}
	public final Address2 getAddress() {
		return address;
	}
	public final void setAddress(Address2 address) {
		this.address = address;
	}
	
}
