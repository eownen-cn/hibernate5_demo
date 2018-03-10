package org.denny.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="account")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_GEN")
	@SequenceGenerator(name="seq_GEN",sequenceName="count_seq",initialValue=1,allocationSize=2)
	private Integer countId ;
	private String countName ;
	
	@OneToOne(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER,optional=true)
	@JoinColumn(
		name="dress_id",
		foreignKey=@ForeignKey(name="FK_DRESS_ID",foreignKeyDefinition="the foreignkey references by address (dress_id)")
	)
	private Address address ;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String countName) {
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
	public final Address getAddress() {
		return address;
	}
	public final void setAddress(Address address) {
		this.address = address;
	}
	
}
