

package com.pfe.cigma.PFE.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@DiscriminatorValue("1")
public class DegitalService extends Service {

	@ManyToOne
	DScategory category;
	@ManyToOne
	DSsub_category subcat;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "Service_id")
	List<Plans> plans;
	
	
	
//	public OnGoingService m_OnGoingService;
//	public Plans m_Plans;
//	public ReviewAndRating m_ReviewAndRating;


}//end DegitalService