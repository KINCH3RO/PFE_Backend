package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pfe.cigma.PFE.model.DScategory;
import com.pfe.cigma.PFE.model.DSsub_category;
import com.pfe.cigma.PFE.model.User;


public interface IDScategoryService {
	
	//category
	DScategory addDScategory(DScategory U);
	DScategory updateDScategory(DScategory u);

	boolean deleteDScategory(DScategory u);	
	List<DScategory> getDScategorys();
	DScategory getDScategoryById(int id);
	boolean deleteDScategoryById(int id);
	Page<DScategory> getPage(Pageable p);
	Page<DScategory> getPageBytitle(String title,Pageable p);
	//subCat
	List<DSsub_category> getDSsubcategories();
	DSsub_category addDSsubcat(DSsub_category U);
	DSsub_category updateDSsubcat(DSsub_category u);
	DSsub_category getDSsubcat(int id);
	boolean deleteDSsubcat(int id);
	Page<DSsub_category> getPageBytitleAndCategory(String title,int id,Pageable p);
	

}
