
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

public class ReviewAndRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private Date createdDate;
	private int rating;
	private String reviewText;

	
}// end ReviewAndRating