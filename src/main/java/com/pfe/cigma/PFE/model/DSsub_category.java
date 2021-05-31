package com.pfe.cigma.PFE.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class DSsub_category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	Date createdDate;
	
	@ManyToOne()
	DScategory category;
}
