package com.pfe.cigma.PFE.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.DScategory;
import com.pfe.cigma.PFE.model.IRL_Category;

@Repository
public interface IRL_CategoryDAO extends CrudRepository<IRL_Category, Integer> {
	
	Page<IRL_Category> findAll(Pageable p);
	Page<IRL_Category> findAllByTitleContaining(String title,Pageable p);

}
