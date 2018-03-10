package org.denny.bean;

import java.util.Date;

public class Orders implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String orderId ;
	private String orderNum ;
	private Date orderTime ;
	private Account account ;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String orderNum, Date orderTime) {
		super();
		this.orderNum = orderNum;
		this.orderTime = orderTime;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderNum=" + orderNum
				+ ", orderTime=" + orderTime + "]";
	}
	public final Account getAccount() {
		return account;
	}
	public final void setAccount(Account account) {
		this.account = account;
	}
	
}
