package com.pfe.cigma.PFE.model;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.context.annotation.Primary;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 10-May-2021 14:44:52
 */
@Entity
@Getter
@Setter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	private String accountStatus;
	private String userName;
	private Date administrationDate;
	private float balance;
	private Date bornDate;
	private String email;
	private Date entryDate;
	private String familyName;
	private boolean isEmailVerified;
	private String name;
	private boolean onlineStatus;
	private String password;
	private String profilePhotoUrl;
	
	@ManyToMany
	List<Role> role;
	
	public User(){

	}

	
}//end User