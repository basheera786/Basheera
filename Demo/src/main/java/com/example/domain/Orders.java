package com.example.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")

public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_Id")
	private Integer orderId;
	@Column(name = "order_Name")
	private String orderName;
	@ManyToOne
	@JoinColumn(name = "accnt_Id")
	private Accounts accounts;
	@Column(name = "created_By")
	private String createdBy;
	@Column(name = "created_Date")
	private String createdDate;
	@Column(name = "order_price")
	private Integer orderPrice;
	@OneToMany
	private List<Inventory> inventor;

	public Integer getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<Inventory> getInventor() {
		return inventor;
	}

	public void setInventor(List<Inventory> inventor) {
		this.inventor = inventor;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderName=" + orderName + ", accounts=" + accounts + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", orderPrice=" + orderPrice + ", inventor=" + inventor
				+ "]";
	}

}
