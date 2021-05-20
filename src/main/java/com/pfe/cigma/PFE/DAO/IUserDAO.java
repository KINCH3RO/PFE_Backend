package com.pfe.cigma.PFE.DAO;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.model.User;



@Repository
public interface IUserDAO extends PagingAndSortingRepository<User,Integer> {
	 User findByemail(String email);
	 User findByuserName(String username);
	 User findAllByname(String username);
	 List<User> findAllByRole(Role r);
	 Page<User> findAllByNameContainingAndFamilyNameContaining(String name,String familyname,Pageable pageable);
	 Page<User> findAllByNameContainingAndFamilyNameContainingAndRole(String name,String familyname,Role r,Pageable pageable);
     Page<User> findAll(Pageable pageable) ;
}
