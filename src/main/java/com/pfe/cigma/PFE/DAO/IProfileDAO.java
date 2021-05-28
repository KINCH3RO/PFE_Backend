package com.pfe.cigma.PFE.DAO;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.model.User;
import com.pfe.cigma.PFE.model.Profile;



@Repository
public interface IProfileDAO extends PagingAndSortingRepository<Profile,Integer> {
	 Profile findByUser(User u);
}
