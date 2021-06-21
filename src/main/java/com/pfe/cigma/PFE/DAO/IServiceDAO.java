package com.pfe.cigma.PFE.DAO;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.DegitalService;
import com.pfe.cigma.PFE.model.IRLservice;
import com.pfe.cigma.PFE.model.Service;
import com.pfe.cigma.PFE.model.User;

@Repository
public interface IServiceDAO extends CrudRepository<Service, Integer> {

	
	
	List<Service> findAllByIsDegitalAndTitleContaining(Boolean x,String title);
	List<Service> findAllByUser(User u);
	List<Service> findAllByUserAndIsDegital(User u, Boolean x);
	
	Page<Service> findAllByTitleContainingAndIsDegital(String title, Pageable p, Boolean x);
}
