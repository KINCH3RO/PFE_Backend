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
 * @created 20-May-2021 21:36:11
 */
@Entity
@Getter
@Setter
@ToString
public class AssociatedAccounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String accountEmail;
	private String fullName;
	private String provider;
	private Date saveDate;
	private String userName;

	public AssociatedAccounts(){

	}

	public void finalize() throws Throwable {

	}
}//end AssociatedAccounts