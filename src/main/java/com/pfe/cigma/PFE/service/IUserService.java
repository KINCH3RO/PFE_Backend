package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.model.User;

public interface IUserService {
	
	User addUser(User U);
	User updateUser(User u);
	boolean deleteUser(User u);
	List<User> getUsers();
	User getUserById(int id);
	boolean deleteUserById(int id);
	Page<User> getPage(Pageable p);
	Page<User> getFiltredPages(String name,String famName,Pageable p,Role r);

	User login(User u);
}
