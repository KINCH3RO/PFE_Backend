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
 * @created 20-May-2021 21:24:50
 */
@Entity
@Getter
@Setter
@ToString

public class LanguageLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String language;
	private String languagelevel;

	
}//end LanguageLevel