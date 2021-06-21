
package com.pfe.cigma.PFE.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

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

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="isDegital",discriminatorType = DiscriminatorType.INTEGER)
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String description;
	 @Column(name = "isDegital", insertable = false, updatable = false)
	 
    private boolean isDegital;
	@ElementCollection
	private Set<String> serviceImageUrl = Collections.emptySortedSet();
	private int mainPhotoIndex;
	private String title;
	@ElementCollection
	private Set<String> videoImageUrl = Collections.emptySortedSet();
	
	@ManyToOne
	User user;

}// end Service