package com.pfe.cigma.PFE.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pfe.cigma.PFE.DAO.IRoleDAO;
import com.pfe.cigma.PFE.DAO.IUserDAO;
import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.model.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO userDAO;

	@Autowired
	IRoleDAO IRoleDAO;

	@Override
	public User addUser(User U) {
		User foundUserEmail = userDAO.findByemail(U.getEmail());
		if(foundUserEmail !=null) {
			return null;
		}
		
//		User foundUserUsername= userDAO.findByuserName(U.getUserName());
//		if(foundUserUsername !=null) {
//			System.out.println(foundUserUsername.getUserName());
//			return null;
//		}

		U.setEmailVerified(false);
		U.setAdministrationDate(null);
		U.setAccountStatus("normal");
		U.setBalance(0);
		U.setEntryDate(new Date());
		U.setOnlineStatus(false);
		U.setProfilePhotoUrl(null);
		Role role = new Role();

		role.setIdRole(4);
		role.setRoleName("USER");
		List<Role> r = new ArrayList<>(); 	
		r.add(role);
		U.setRole(r);
		// TODO Auto-generated method stub
		return userDAO.save(U);
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return userDAO.save(u);
	}

	@Override
	public boolean deleteUser(User u) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userDAO.findAll();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id).get();
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		userDAO.deleteById(id);
		return true;
	}

	@Override
	public Page<User> getPage(Pageable p) {
		// TODO Auto-generated method stub
		return userDAO.findAll(p);
	}

	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		User foundUser = userDAO.findByemail(u.getEmail());
		if (foundUser != null) {
			if (u.getPassword().equals(foundUser.getPassword())) {
				return foundUser;
			} else {
				return null;
			}
		}
		return null;
	}

	@Override
	public Page<User> getFiltredPages(String name,String famName,Pageable p,Role r) {
		// TODO Auto-generated method stub
		if(r!=null) {
			return userDAO.findAllByNameContainingAndFamilyNameContainingAndRole(name,famName,r,p);
		}
		return userDAO.findAllByNameContainingAndFamilyNameContaining(name,famName,p);
	}


	

}
