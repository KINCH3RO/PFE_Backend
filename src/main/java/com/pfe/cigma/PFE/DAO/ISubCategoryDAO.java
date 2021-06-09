package com.pfe.cigma.PFE.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.DScategory;
import com.pfe.cigma.PFE.model.DSsub_category;

@Repository
public interface ISubCategoryDAO extends CrudRepository<DSsub_category, Integer> {
	Page<DSsub_category> findAll(Pageable p);
	Page<DSsub_category> findAllByTitleContainingAndCategory(String title,DScategory cat,Pageable p);
	List<DSsub_category> findAllByCategory(DScategory cat);

}
