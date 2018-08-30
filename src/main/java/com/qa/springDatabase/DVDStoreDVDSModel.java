package com.qa.springDatabase;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "dvds", schema="dvdstore")
@EntityListeners(AuditingEntityListener.class)
public class DVDStoreDVDSModel implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dvdID;
	
	@NotBlank
	private String title;
	
	private Boolean rented;

	public Long getId() {
		return dvdID;
	}

	public void setId(Long id) {
		this.dvdID = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getRented() {
		return rented;
	}

	public void setRented(Boolean rented) {
		this.rented = rented;
	}
	
}
