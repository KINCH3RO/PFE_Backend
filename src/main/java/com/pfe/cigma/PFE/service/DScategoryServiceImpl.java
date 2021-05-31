package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pfe.cigma.PFE.DAO.ICategoryDAO;
import com.pfe.cigma.PFE.DAO.ISubCategoryDAO;
import com.pfe.cigma.PFE.model.DScategory;
import com.pfe.cigma.PFE.model.DSsub_category;
import com.pfe.cigma.PFE.model.User;

@Service
public class DScategoryServiceImpl implements IDScategoryService {

	@Autowired
	ICategoryDAO categoryDAO;
	
	@Autowired
	ISubCategoryDAO subcatDAO;

	@Override
	public DScategory addDScategory(DScategory U) {
		// TODO Auto-generated method stub
		return categoryDAO.save(U);
	}

	@Override
	public DScategory updateDScategory(DScategory u) {
		// TODO Auto-generated method stub
		return categoryDAO.save(u);
	}

	

	@Override
	public boolean deleteDScategory(DScategory u) {
		// TODO Auto-generated method stub
		 categoryDAO.delete(u);
		 
		 return true;
	}

	@Override
	public List<DScategory> getDScategorys() {
		// TODO Auto-generated method stub
		return (List<DScategory>) categoryDAO.findAll();
	}

	@Override
	public DScategory getDScategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.findById(id).get();
	}

	@Override
	public boolean deleteDScategoryById(int id) {
		// TODO Auto-generated method stub
		 categoryDAO.deleteById(id);
		 return true;
	}

	@Override
	public Page<DScategory> getPage(Pageable p) {
		// TODO Auto-generated method stub
		return categoryDAO.findAll(p);
	}

	@Override
	public Page<DScategory> getPageBytitle(String title, Pageable p) {
		// TODO Auto-generated method stub
		return categoryDAO.findAllByTitleContaining( title,p);
	}

	@Override
	public DSsub_category addDSsubcat(DSsub_category U) {
		// TODO Auto-generated method stub
	return	subcatDAO.save(U);
	}

	@Override
	public DSsub_category updateDSsubcat(DSsub_category u) {
		// TODO Auto-generated method stub
		return subcatDAO.save(u);
	}

	@Override
	public DSsub_category getDSsubcat(int id) {
		// TODO Auto-generated method stub
		 return  subcatDAO.findById(id).get();
	}

	@Override
	public boolean deleteDSsubcat(int id) {
		// TODO Auto-generated method stub
		 subcatDAO.deleteById( id);
		 return true;
	}

	@Override
	public Page<DSsub_category> getPageBytitleAndCategory(String title, int id, Pageable p) {
		// TODO Auto-generated method stub
		DScategory cat = categoryDAO.findById(id).get();
		if(cat==null) {
			return null;
		}
		
		return subcatDAO.findAllByTitleContainingAndCategory(title, cat, p);
	}

	@Override
	public List<DSsub_category> getDSsubcategories() {
		// TODO Auto-generated method stub
		return (List<DSsub_category>) subcatDAO.findAll();
	}

}
