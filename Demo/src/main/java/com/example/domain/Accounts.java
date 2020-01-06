package com.example.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accnt_Id")
	private Integer accntId;
	@Column(name = "user_Name")
	private String userName;
	@Column(name = "order_Name")
	private String orderName;
	@Column(name = "user_Address")
	private String userAddress;
	@Column(name = "user_Email")
	private String userEmail;
	@Column(name = "user_Tel")
	private String userTel;
	@Column(name = "created_By")
	private String createdBy;
	@Column(name = "created_Date")
	private String createdDate;
	@Column(name = "accnt_Bal")
	private Integer accntBal;
	@OneToMany
	@JoinColumn(name = "order_Id")
	private List<Orders> orders;

	public Integer getAccntBal() {
		return accntBal;
	}

	public void setAccntBal(Integer accntBal) {
		this.accntBal = accntBal;
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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Integer getAccntId() {
		return accntId;
	}

	public void setAccntId(Integer accntId) {
		this.accntId = accntId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Override
	public String toString() {
		return "Accounts [accntId=" + accntId + ", userName=" + userName + ", orderName=" + orderName + ", userAddress="
				+ userAddress + ", userEmail=" + userEmail + ", userTel=" + userTel + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", accntBal=" + accntBal + ", orders=" + orders + "]";
	}

}
