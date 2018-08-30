package com.qa.springDatabase;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class DVDStoreCustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
	

	private String name;

	public Long getId() {
		return userID;
	}

	public void setId(Long id) {
		this.userID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
