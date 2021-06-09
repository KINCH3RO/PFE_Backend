
package com.pfe.cigma.PFE.model;

import java.util.Date;

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
 * @created 20-May-2021 21:25:02
 */
@Entity
@Getter
@Setter
@ToString

public class Plans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	private int deliveryTime;
	private String deliveryTimeUnit;
	private String description;
	private float price;
	private String title;
	private int packageLevel;

	
}// end Plans