package com.pfe.cigma.PFE.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 20-May-2021 21:24:18
 */
@Entity
@Getter
@Setter
@ToString
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String country;
	private String streetAddress;
	private String description;
	private Date profileDate;
	private String protfolioWebSiteUrl;
	public  String speciality;
	public String primaryLanguage;
	private boolean completed=false;
   
	@OneToMany(cascade = CascadeType.ALL)
	public List<Education> educations;
	@OneToMany(cascade = CascadeType.ALL)

	public List<Certification> certifications;
	@OneToMany(cascade = CascadeType.ALL)

	public List<Occupation> occupations;
	@OneToMany(cascade = CascadeType.ALL)

	public List<LanguageLevel> languages;
	@OneToMany(cascade = CascadeType.ALL)

	public List<AssociatedAccounts> associatedAccounts;

	@OneToOne
	User user;

}// end Profile