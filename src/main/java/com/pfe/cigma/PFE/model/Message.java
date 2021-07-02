package com.pfe.cigma.PFE.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 22-Jun-2021 23:03:30
 */
@Entity
@Getter
@Setter
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String content;
	private String fileUrl;
	private String messageType;
	private String originalFileName;
	private Date sendDate;
	private int senderid;
	private String action;

	
	private float customOfferPrice;
	private int customOfferDelTime;
	private String customOfferDelUnit;
	private String customOfferDescription;
	private int customOfferTargetedUser;
	private Date customOfferExpirationDate;
	
	
	@OneToOne
	private Service customOfferTargetedOffer;
	


}// end Message