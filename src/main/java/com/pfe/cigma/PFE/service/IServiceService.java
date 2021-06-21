package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pfe.cigma.PFE.model.DegitalService;
import com.pfe.cigma.PFE.model.IRLservice;
import com.pfe.cigma.PFE.model.Service;

public interface IServiceService {

	Service addService(Service s);
	Service updateService(Service s);
	boolean deleteByid(int id);
	Service findoneByid(int id);
	List<Service> findAll();
	List<Service> findAllBytype (Boolean x,String title);
	List<Service> findAllbyUser(int id);
	List<Service> findAllbyUserAndType(int id,boolean x);
    Page<Service> findAllBytitleAndServiceType(String title, Pageable p,boolean x );
	
	
}
