
package com.pfe.cigma.PFE.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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
@DiscriminatorValue("0")
public class IRLservice extends Service {

	private boolean available;
	private String category;
	public String adresse;
	private String city;
	private String country;
	private float price;
	private float lng;
	private float lat;
	private int deliveryTime;
	private String deliveryTimeUnit;
	

	
}// end IRLservice