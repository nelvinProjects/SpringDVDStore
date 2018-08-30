package com.qa.springDatabase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class DVDStoreOrdersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderID;
	
	private Long userID;
	private Long dvdID;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date rentedOn;
	
	public Long getOrderID() {
		return orderID;
	}


	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}


	public Long getUserID() {
		return userID;
	}


	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public Long getDvdID() {
		return dvdID;
	}


	public void setDvdID(Long dvdID) {
		this.dvdID = dvdID;
	}


	public Date getRentedOn() {
		return rentedOn;
	}


	public void setRentedOn(Date rentedOn) {
		this.rentedOn = rentedOn;
	}
}
