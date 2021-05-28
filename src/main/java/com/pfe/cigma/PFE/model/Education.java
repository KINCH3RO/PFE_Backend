package com.pfe.cigma.PFE.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 20-May-2021 21:24:57
 */
@Entity
@Getter
@Setter
@ToString
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String country;
	private int endYear;
	private String schoolName;
	private String Specialization;
	private int startYear;

	
}//end Education