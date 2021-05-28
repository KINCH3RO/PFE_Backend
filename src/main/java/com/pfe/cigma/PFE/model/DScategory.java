package com.pfe.cigma.PFE.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class DScategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	Date createdDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<DSsub_category> sub_cat;
	
}
