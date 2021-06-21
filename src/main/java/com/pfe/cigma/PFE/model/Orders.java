package com.pfe.cigma.PFE.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 09-Jun-2021 13:34:55
 */
@Entity
@Getter
@Setter
@ToString
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date createdDate;
	private String title;
	private String description;
	private String category;
	private String sub_category;
	private int deliveryTime;
	private float price;
	private String deliveryTimeUnit;
	private boolean isDegital;

	@Column(columnDefinition = "VARCHAR(60) CHECK (status IN ('ACTIVE', 'PENDING', 'INACTIVE'))")
	private String status = "PENDING";

	@ManyToMany
	List<Service> services;
	
	@ManyToOne
	User user;

}// end Order