package com.pfe.cigma.PFE.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

import com.sun.org.apache.xml.internal.serializer.utils.Messages;

import lombok.Getter;
import lombok.Setter;

/**
 * @author KiNCH3RO
 * @version 1.0
 * @created 22-Jun-2021 23:02:58
 */
@Entity
@Getter
@Setter
public class Chat {

	
	

	@Id
	@Column(length = 50)
	private String channel_Id;
	private Date createdDate;
	
   @ManyToMany
	public List<User> participants;


   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
   @JoinColumn(name = "chat_id")
   @OrderBy("sendDate")
   List<Message> messages=new ArrayList<Message>();




}//end Chat