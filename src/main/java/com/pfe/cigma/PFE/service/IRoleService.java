package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pfe.cigma.PFE.model.Role;

public interface IRoleService {

	Role addRole(Role U);

	Role updateRole(Role u);

	boolean deleteRole(Role u);

	List<Role> getRoles();

	Role getRoleById(int id);

	boolean deleteRoleById(int id);
	
	Role getRoleByName(String name);
	Page<Role> getPage(Pageable p);

	Page<Role> getPagePerName(String name,Pageable p);
}
