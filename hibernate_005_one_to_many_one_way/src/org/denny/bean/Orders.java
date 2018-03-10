package org.denny.bean;

import java.util.Date;

/**
 * 订单
 * @author Ewonen-PC
 *
 */
public class Orders implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String orderId ;
	private String orderNO ;
	private Date orderTime ;
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(String orderNO) {
		super();
		this.orderNO = orderNO;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	
}
