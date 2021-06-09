package com.pfe.cigma.PFE.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pfe.cigma.PFE.DAO.IServiceDAO;
import com.pfe.cigma.PFE.DAO.IUserDAO;
import com.pfe.cigma.PFE.model.DegitalService;
import com.pfe.cigma.PFE.model.IRLservice;
import com.pfe.cigma.PFE.model.Service;
import com.pfe.cigma.PFE.model.User;

@Transactional
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {

	@Autowired
	IServiceDAO serviceDAO;

	@Autowired
	IUserDAO userDAO;

	@Override
	public Service addService(Service s) {
		// TODO Auto-generated method stub
		return serviceDAO.save(s);
	}

	@Override
	public Service updateService(Service s) {
		// TODO Auto-generated method stub
		return serviceDAO.save(s);
	}

	@Override
	public boolean deleteByid(int id) {
		// TODO Auto-generated method stub
		return serviceDAO.existsById(id);
	}

	@Override
	public Service findoneByid(int id) {
		// TODO Auto-generated method stub
		return serviceDAO.findById(id).get();
	}

	@Override
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		return (List<Service>) serviceDAO.findAll();
	}

	@Override
	public List<Service> findAllBytype(Boolean x,String title) {
		// TODO Auto-generated method stub
		return serviceDAO.findAllByIsDegitalAndTitleContaining(x,title);
	}

	@Override
	public List<Service> findAllbyUser(int id) {
		// TODO Auto-generated method stub
		User u = userDAO.findById(id).get();
		 if(u==null) {
			 return null;
		 }
		  return serviceDAO.findAllByUser(u);
	}

	@Override
	public Page<Service> findAllBytitleAndServiceType(String title, Pageable p, boolean x) {
		
		
		// TODO Auto-generated method stub
		return serviceDAO.findAllByTitleContainingAndIsDegital(title, p, x);
	}


}
