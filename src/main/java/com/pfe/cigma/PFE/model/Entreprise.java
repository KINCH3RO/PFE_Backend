package com.pfe.cigma.PFE.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 09-Jun-2021 13:35:16
 */
@Getter
@Setter
@Entity
public class Entreprise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String country;
	private String city;
	private String adresse;
	private String description;
	public String website;
	private Date initiatedDate;
	public String coverPhotoUrl;
    public String pagePhotoUrl;
    public Date createdDate;

	private String specialization;

	private String status="Normal";

	@ManyToOne
	User owner;

	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="Entreprise_id")
	List<EntrepriseRecruitments> EntrepriseRects;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="Entreprise_id")
	List<EntreprisePosts > entreprisePosts;

}// end Entreprise