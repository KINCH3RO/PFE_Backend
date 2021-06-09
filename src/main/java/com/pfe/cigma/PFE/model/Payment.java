

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
/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 01-Jun-2021 14:03:41
 */
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float pay_amount;
	private Date pay_date;
	private int paymend_id;

	
}//end Payment