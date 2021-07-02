package com.pfe.cigma.PFE.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.DScategory;
import com.pfe.cigma.PFE.model.Role;

@Repository
public interface ICategoryDAO extends CrudRepository<DScategory, Integer> {
	
	Page<DScategory> findAll(Pageable p);
	Page<DScategory> findAllByTitleContaining(String title,Pageable p);
	 DScategory findByTitle(String Title);

}
