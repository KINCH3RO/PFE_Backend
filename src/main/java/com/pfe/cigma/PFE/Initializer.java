package com.pfe.cigma.PFE;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.service.IRoleService;



@Component
public class Initializer implements CommandLineRunner {

	@Value("${spring.jpa.hibernate.ddl-auto}")	
	String ddlValue;
	
	@Autowired
	IRoleService roleService;
	
	@Override
	public void run(String... args) throws Exception {
	  if(ddlValue.equals("create")) {
		  String[] mandaroryRoles= {"ADMIN","USER_ADMIN", "SUPPORT", "USER","SELLER","BUYER"};
		  
		  for (String role : mandaroryRoles) {
			 roleService.addRole(new Role(0,role,"",new Date()));
		}
	  }
		
	 
	}

}
