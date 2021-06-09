package com.pfe.cigma.PFE.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * -gggg
 * @author KiNCH3RO
 * @version 1.0
 * @created 10-May-2021 14:46:55
 */
@Entity
@Getter
@Setter
@ToString
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String roleName;
	private String roleDescription;
	private Date creationDate;
//	@ElementCollection
//	private List<String> rolePermissions = new ArrayList<>()  ;


	public Role(){

	}

	
}//end Role