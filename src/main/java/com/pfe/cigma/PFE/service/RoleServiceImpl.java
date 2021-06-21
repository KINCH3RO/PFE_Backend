package com.pfe.cigma.PFE.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pfe.cigma.PFE.DAO.IRoleDAO;
import com.pfe.cigma.PFE.model.Role;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	IRoleDAO RoleDAO;
	
	@Override
	public Role addRole(Role U) {
		// TODO Auto-generated method stub
		Role r = RoleDAO.findByRoleName(U.getRoleName());
		if(r!=null) {
			return null;
		}
		return RoleDAO.save(U);
	}

	@Override
	public Role updateRole(Role u) {
		// TODO Auto-generated method stub

		return RoleDAO.save(u);
	}

	@Override
	public boolean deleteRole(Role u) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return (List<Role>) RoleDAO.findAll();
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return RoleDAO.findById(id).get();
	}

	@Override
	public boolean deleteRoleById(int id) {
		// TODO Auto-generated method stub
		 RoleDAO.deleteById(id);
		 return true;
	}

	@Override
	public Page<Role> getPage(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Role> getPagePerName(String name, Pageable p) {
		// TODO Auto-generated method stub
		return RoleDAO.findAllByRoleNameContaining(name, p);
	}

}
