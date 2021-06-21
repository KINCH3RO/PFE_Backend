package com.pfe.cigma.PFE.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EntrepriseRecruitments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int places;
	String jobName;
	String jobDescription;
	Date createdDate;
	boolean completed;
	
	@ManyToMany
	List<User> participants;

}
