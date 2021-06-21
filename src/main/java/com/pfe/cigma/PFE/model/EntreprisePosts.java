package com.pfe.cigma.PFE.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EntreprisePosts {
	
	@Id
	@GeneratedValue
	 int id;
	
	String content;
	String imageUrl;
	Date createdDate;

}
